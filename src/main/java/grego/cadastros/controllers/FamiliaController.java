package grego.cadastros.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.cadastros.models.Empresa;
import grego.cadastros.models.Familia;
import grego.cadastros.repositories.EmpresaRepository;
import grego.cadastros.repositories.FamiliaRepository;

@RestController
@RequestMapping("/familia")
@CrossOrigin(origins = "*")
public class FamiliaController {

	@Autowired
	private EmpresaRepository empRepo; 
	
	@Autowired
	private FamiliaRepository famRepo; 
	
	@GetMapping("/list")
	public List<Familia> findAll(){
		return famRepo.findAll();
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<String> insertFam(@RequestBody Familia fam){
		if(fam.getFamEmp() != null && fam.getFamEmp().getId() != null) {
			Optional<Empresa> optEmp = empRepo.findById(fam.getFamEmp().getId()); 
			if(!optEmp.isPresent()) {
				return new ResponseEntity<>("Empresa não existe!", HttpStatus.BAD_REQUEST); 
			}
			fam.setFamEmp(optEmp.get()); 
		}else {
			return new ResponseEntity<>("Objeto empresa é obrigatório!", HttpStatus.BAD_REQUEST);
		}
		Optional<Familia> optFam = famRepo.findBySiglaAndUfdEmp(fam.getDescr(), fam.getFamEmp());
		if(optFam.isPresent()) {
			return new ResponseEntity<>("Objeto Familia já existe no banco de dados!", HttpStatus.CONFLICT); 
 		}
		famRepo.saveAndFlush(fam); 
		return new ResponseEntity<>("Familia cadastrada", HttpStatus.OK); 
	}
		
}

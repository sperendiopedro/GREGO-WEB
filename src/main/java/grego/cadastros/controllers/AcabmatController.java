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

import grego.cadastros.models.Acabmat;
import grego.cadastros.models.Empresa;
import grego.cadastros.repositories.AcabmatRepository;
import grego.cadastros.repositories.EmpresaRepository;

@RestController
@RequestMapping("/acabmat")
public class AcabmatController {
	@Autowired
	private AcabmatRepository acabmatRepo;
	
	@Autowired
	private EmpresaRepository empRepo; 
	
	@GetMapping("/list")
	public List<Acabmat> findAll(){
		return acabmatRepo.findAll(); 
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Acabmat acabmat){
		if(acabmat.getAcabmatEmp() != null && acabmat.getAcabmatEmp().getCdEmp() != null) {
			Optional<Empresa> optEmp = empRepo.findById(acabmat.getAcabmatEmp().getCdEmp()); 
			if(!optEmp.isPresent()) {
				return new ResponseEntity<>("Empresa inexistente!", HttpStatus.BAD_REQUEST); 
			}
			acabmat.setAcabmatEmp(optEmp.get()); 
		}else {
			return new ResponseEntity<>("Empresa é obrigatório!", HttpStatus.OK); 
		}
		Optional<Acabmat> optAcab = acabmatRepo.findByDescrAndEmp(acabmat.getDescr(), acabmat.getAcabmatEmp()); 
		if(optAcab.isPresent()) {
			return new ResponseEntity<>("Objeto Acabamento já existe no banco de dados!", HttpStatus.CONFLICT); 
		}
		
		acabmatRepo.saveAndFlush(acabmat); 
		return new ResponseEntity<>("Objeto Acabamento inserido com sucesso!", HttpStatus.OK); 
	}
	
}

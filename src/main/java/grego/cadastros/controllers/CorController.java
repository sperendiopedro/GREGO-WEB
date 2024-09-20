package grego.cadastros.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.cadastros.models.Cor;
import grego.cadastros.models.Empresa;
import grego.cadastros.repositories.CorRepository;
import grego.cadastros.repositories.EmpresaRepository;

@RestController
@RequestMapping("/cor")
public class CorController {
	@Autowired
	private CorRepository corRepo; 
	@Autowired
	private EmpresaRepository empRepo; 
	
	@GetMapping("/list")
	public List<Cor> findAll(){
		return corRepo.findAll(); 
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCor(@RequestBody Cor cor){
		if(cor.getCorEmp() != null && cor.getCorEmp().getId() != null) {
			Optional<Empresa> optEmp = empRepo.findById(cor.getCorEmp().getId());
			if(!optEmp.isPresent()) {
				return new ResponseEntity<>("Objeto empresa inexistente!", HttpStatus.BAD_REQUEST); 
			}
			cor.setCorEmp(optEmp.get()); 
		}else {
			return new ResponseEntity<>("Objeto empresa é obrigatório!", HttpStatus.BAD_REQUEST); 
		}
		Optional<Cor> optCor = corRepo.findByDescrAndEmp(cor.getDescr(), cor.getCorEmp());
		if(optCor.isPresent()) {
			return new ResponseEntity<>("Objeto cor já existe no banco de dados", HttpStatus.CONFLICT); 
		}
		corRepo.saveAndFlush(cor); 
		return new ResponseEntity<>("Objeto cor registrado com sucesso!", HttpStatus.OK); 
	}
	
	
}

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

import grego.cadastros.models.Empresa;
import grego.cadastros.models.UFD;
import grego.cadastros.repositories.EmpresaRepository;
import grego.cadastros.repositories.UFDRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empRepo; 
	@Autowired
	private UFDRepository ufdRepo; 
	
	@GetMapping("/listEMP")
	public List<Empresa> listAll(){
		return empRepo.findAll(); 
	}
	
	@PostMapping("/saveEmp")
	public ResponseEntity<String> insert(@RequestBody Empresa empresa) {
		if(empRepo.findByCnpj(empresa.getCnpj()) != null) {
			return new ResponseEntity<>("Empresa com CNPJ existente", HttpStatus.BAD_REQUEST);
		}
		if(empresa.getUfd() != null && empresa.getUfd().getId()	!= null) {
			  Optional<UFD> ufdOpt = ufdRepo.findById(empresa.getUfd().getId());
	            if (!ufdOpt.isPresent()) {
	                return new ResponseEntity<>("UFD não encontrada!", HttpStatus.BAD_REQUEST);
	            }
	         empresa.setUfd(ufdOpt.get()); 
		}
		
		empRepo.saveAndFlush(empresa); 
		return ResponseEntity.ok(("Empresa registrada")); 
	}
	
	
}

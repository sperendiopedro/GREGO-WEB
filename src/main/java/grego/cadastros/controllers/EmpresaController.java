package grego.cadastros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.cadastros.models.Empresa;
import grego.cadastros.repositories.EmpresaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empRepo; 
	
	@PostMapping("/saveEmp")
	public ResponseEntity insert(@RequestBody Empresa empresa) {
		if(empRepo.findByCnpj(empresa.getCnpj()) != null) {
			return new ResponseEntity("Empresa com CNPJ existente", HttpStatus.BAD_REQUEST);
		}
		empRepo.saveAndFlush(empresa); 
		return ResponseEntity.ok(("Empresa registrada")); 
	}
	
	
}

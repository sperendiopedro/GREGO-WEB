package grego.cadastros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.cadastros.models.Fornecedor;
import grego.cadastros.repositories.FornecRepository;

@RestController
@RequestMapping("fornec")
public class FornecedorController {
	
	@Autowired
	private FornecRepository fornecRepo; 
	
	
	@GetMapping(value = "/listEmp")
	public List<Fornecedor> listAll(){
		return fornecRepo.findAll(); 
	}
	
	@PostMapping(value = "/saveFornec")
	public ResponseEntity register(@RequestBody Fornecedor fornec){
		if(fornecRepo.findByCnpj(fornec.getCnpj()) != null) return new ResponseEntity("CNPJ já cadastrado!", HttpStatus.BAD_REQUEST);
		else {
			fornecRepo.saveAndFlush(fornec); 
		}
		return ResponseEntity.ok("Fornecedor cadastrado"); 
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity deleteEmp(@PathVariable Long id) {
		if(fornecRepo.findById(id) == null) return new ResponseEntity("Fornecedor não encontrado!", HttpStatus.BAD_REQUEST); 
		else { 
			fornecRepo.deleteById(id); 
		}
		return ResponseEntity.ok("Fornecedor deletado"); 
	}	

}

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
import grego.cadastros.models.Fornecedor;
import grego.cadastros.models.UFD;
import grego.cadastros.repositories.EmpresaRepository;
import grego.cadastros.repositories.FornecRepository;
import grego.cadastros.repositories.UFDRepository;

@RestController
@RequestMapping("fornec")
@CrossOrigin(origins = "*")
public class FornecedorController {

	@Autowired
	private FornecRepository fornecRepo;
	@Autowired
	private UFDRepository ufdRepo;
	@Autowired
	private EmpresaRepository empRepo;

	@GetMapping(value = "/listEmp")
	public List<Fornecedor> listAll() {
		return fornecRepo.findAll();
	}

	@PostMapping(value = "/saveFornec")
	public ResponseEntity<String> register(@RequestBody Fornecedor fornec) {
		if (fornecRepo.findByCnpj(fornec.getCnpj()) != null) {
			return new ResponseEntity<>("CNPJ já cadastrado!", HttpStatus.BAD_REQUEST);
		}
		
		if(fornec.getFornec_emp() != null && fornec.getFornec_emp().getId() != null) {
			Optional<Empresa> optEmp = empRepo.findById(fornec.getFornec_emp().getId()); 
			if(!optEmp.isPresent()) {
				return new ResponseEntity<>("Empresa não existe!", HttpStatus.BAD_REQUEST); 
			}
			fornec.setFornec_emp(optEmp.get());  
		}else {
			return new ResponseEntity<>("Empresa é obrigatório!", HttpStatus.BAD_REQUEST);
		}
		
		if(fornec.getFornec_ufd() != null && fornec.getFornec_ufd().getId() != null) {
			Optional<UFD> optUfd = ufdRepo.findById(fornec.getFornec_ufd().getId()); 
			if(!optUfd.isPresent()) {
				return new ResponseEntity<>("Unidade Federal inexistente", HttpStatus.BAD_REQUEST); 
			}
			fornec.setFornec_ufd(optUfd.get()); 
		}else {
			return new ResponseEntity<>("Unidade federal é obrigatório!", HttpStatus.BAD_REQUEST);
		}
		
		fornecRepo.saveAndFlush(fornec);
		return ResponseEntity.ok("Fornecedor cadastrado");
	}

}

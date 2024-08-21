package grego.cadastros.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@CrossOrigin(origins = "*")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empRepo;

	@GetMapping("/list")
	public List<Empresa> listAll() {
		return empRepo.findAll();
	}

	@PostMapping("/saveEmp")
	public ResponseEntity<String> register(@RequestBody Empresa empresa) {
		if (empRepo.findByCnpj(empresa.getCnpj()) != null) {
			return new ResponseEntity<>("Empresa com CNPJ existente", HttpStatus.BAD_REQUEST);
		}
		empRepo.saveAndFlush(empresa);
		return ResponseEntity.ok(("Empresa registrada"));
	}

	@PatchMapping("/updateEmp")
	public ResponseEntity updateEmp(@RequestBody Empresa newEmp) {
		if (newEmp.getId() == null) {
			return new ResponseEntity("Id não pode ser null", HttpStatus.BAD_REQUEST);
		}
		Optional<Empresa> emp = empRepo.findById(newEmp.getId());
		if (!emp.isPresent()) {
			return new ResponseEntity("Empresa não existe!", HttpStatus.BAD_REQUEST);
		}
		Empresa empAtual = emp.get();
		if (newEmp.getRazSoc() != null)
			empAtual.setRazSoc(newEmp.getRazSoc());
		if (newEmp.getNomeFant() != null)
			empAtual.setNomeFant(newEmp.getNomeFant());
		if (newEmp.getEnd() != null)
			empAtual.setEnd(newEmp.getEnd());
		if (newEmp.getBairro() != null)
			empAtual.setBairro(newEmp.getBairro());
		if (newEmp.getCep() != null)
			empAtual.setRazSoc(newEmp.getRazSoc());
		if (newEmp.getRazSoc() != null)
			empAtual.setRazSoc(newEmp.getRazSoc());
		if (newEmp.getRazSoc() != null)
			empAtual.setRazSoc(newEmp.getRazSoc());
		if (newEmp.getRazSoc() != null)
			empAtual.setRazSoc(newEmp.getRazSoc());
		return ResponseEntity.ok("ok");
	}

}

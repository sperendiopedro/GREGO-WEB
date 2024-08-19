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
import grego.cadastros.models.Fornecedor;
import grego.cadastros.models.UFD;
import grego.cadastros.repositories.EmpresaRepository;
import grego.cadastros.repositories.FornecRepository;
import grego.cadastros.repositories.UFDRepository;

@RestController
@RequestMapping("fornec")
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
		if (fornec.getUfd_fornec() != null && fornec.getUfd_fornec().getId() != null) {
			Optional<UFD> ufdOpt = ufdRepo.findById(fornec.getUfd_fornec().getId());
			if (!ufdOpt.isPresent()) {
				return new ResponseEntity<>("UFD não encontrada", HttpStatus.BAD_REQUEST);
			}
			fornec.setUfd_fornec(ufdOpt.get());
		} else {
			return new ResponseEntity<>("UFD é obrigatória", HttpStatus.BAD_REQUEST);
		}
		if (fornec.getEmp_fornec() != null && fornec.getEmp_fornec().getId() != null) {
			Optional<Empresa> empOpt = empRepo.findById(fornec.getEmp_fornec().getId());
			if (!empOpt.isPresent()) {
				return new ResponseEntity<>("Empresa não encontrada", HttpStatus.BAD_REQUEST);
			}
			fornec.setEmp_fornec(empOpt.get());
		} else {
			return new ResponseEntity<>("Empresa é obrigatória", HttpStatus.BAD_REQUEST);
		}

		fornecRepo.saveAndFlush(fornec);
		return ResponseEntity.ok("Fornecedor cadastrado");
	}

}

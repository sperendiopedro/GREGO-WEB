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

	@GetMapping(value = "/listFornec")
	public List<Fornecedor> listAll() {
		return fornecRepo.findAll();
	}

	@PostMapping(value = "/saveFornec")
	public ResponseEntity<String> register(@RequestBody Fornecedor fornec) {
		if (fornec.getFornecEmp() != null && fornec.getFornecEmp().getCdEmp() != null) {
			Optional<Empresa> optEmp = empRepo.findById(fornec.getFornecEmp().getCdEmp());
			if (!optEmp.isPresent()) {
				return new ResponseEntity<>("Empresa inexistente!", HttpStatus.BAD_REQUEST);
			}
			fornec.setFornecEmp(optEmp.get());
		} else {
			return new ResponseEntity<>("Empresa é obrigatório", HttpStatus.BAD_REQUEST);
		}

		if (fornec.getFornecUfd() != null && fornec.getFornecUfd().getCdUfd() != null) {
			Optional<UFD> optUfd = ufdRepo.findById(fornec.getFornecUfd().getCdUfd());
			if (!optUfd.isPresent()) {
				return new ResponseEntity<>("UFD inexistente", HttpStatus.BAD_REQUEST);
			}
			fornec.setFornecUfd(optUfd.get());
		} else {
			return new ResponseEntity<>("Unidade federal é obrigatória!", HttpStatus.BAD_REQUEST);
		}

		Optional<Fornecedor> optFornec = fornecRepo.findByCnpjAndFornecEmp(fornec.getCnpj(), fornec.getFornecEmp());
		if (optFornec.isPresent()) {
			return new ResponseEntity<>("Fornecedor já existente na base de dados", HttpStatus.BAD_REQUEST);
		}
		fornecRepo.saveAndFlush(fornec);
		return ResponseEntity.ok("Fornecedor cadastrado");
	}

}

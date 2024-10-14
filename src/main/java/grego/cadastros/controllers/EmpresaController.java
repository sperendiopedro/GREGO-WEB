package grego.cadastros.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import grego.cadastros.models.Empresa;
import grego.cadastros.repositories.EmpresaRepository;


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

	@GetMapping("/listBy/{id}")
	public ResponseEntity<Empresa> listById(@PathVariable Long id) {
		Optional<Empresa> optEmp = empRepo.findById(id);
		if (!optEmp.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(optEmp.get(), HttpStatus.OK);
	}

	@PostMapping("/saveEmp")
	public ResponseEntity<String> register(@RequestBody Empresa empresa) {
		if (empRepo.findByCnpj(empresa.getCnpj()) != null) {
			return new ResponseEntity<>("Empresa com CNPJ existente", HttpStatus.BAD_REQUEST);
		}
		empRepo.saveAndFlush(empresa);
		return ResponseEntity.ok(("Empresa registrada"));
	}

	@PostMapping("/empUpload")
	public ResponseEntity<String> empUpload(@RequestParam("file") MultipartFile file) {

		if (file.isEmpty()) {
			return new ResponseEntity<>("Arquivo vazio!", HttpStatus.NOT_FOUND);
		}

		List<Empresa> empList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			empList = br.lines().skip(1).map(line -> line.trim().split(","))
					.map(fields -> {
				String cnpj = fields[6];
				if (empRepo.findByCnpj(cnpj) == null) {
					Empresa emp = new Empresa();
					emp.setCdEmp(Long.parseLong(fields[0]));
					emp.setRazSoc(fields[1]);
					emp.setNomeFant(fields[2]);
					emp.setEndereco(fields[3]);
					emp.setBairro(fields[4]);
					emp.setCep(fields[5]);
					emp.setCnpj(cnpj);
					emp.setInscrMun(fields[7]);
					emp.setInscrEst(fields[8]);
					emp.setTelefone(fields[9]);
					emp.setEmail(fields[10]);
					emp.setRelSoc(Double.parseDouble(fields[11]));
					emp.setNrCupom(Double.parseDouble(fields[12]));
					emp.setObs(fields[13]);
					return emp;
				} else {
					return null;
				}
			}).filter(Objects::nonNull).collect(Collectors.toList());

			if (!empList.isEmpty()) {
				empRepo.saveAll(empList);
			}
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);

		} catch (IOException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PatchMapping("/updateEmp")
	public ResponseEntity<String> updateEmp(@RequestBody Empresa newEmp) {
		if (newEmp.getCdEmp() == null) {
			return new ResponseEntity<>("Id não pode ser null", HttpStatus.BAD_REQUEST);
		}
		Optional<Empresa> emp = empRepo.findById(newEmp.getCdEmp());
		if (!emp.isPresent()) {
			return new ResponseEntity<>("Empresa não existe!", HttpStatus.BAD_REQUEST);
		}
		Empresa empAtual = emp.get();
		if (newEmp.getRazSoc() != null)
			empAtual.setRazSoc(newEmp.getRazSoc());
		if (newEmp.getNomeFant() != null)
			empAtual.setNomeFant(newEmp.getNomeFant());
		if (newEmp.getEndereco() != null)
			empAtual.setEndereco(newEmp.getEndereco());
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

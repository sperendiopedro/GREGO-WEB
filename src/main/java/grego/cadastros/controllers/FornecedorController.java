package grego.cadastros.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

	@PostMapping("/fornecUpload")
	public ResponseEntity<String> uploadFornec(@RequestParam("file") MultipartFile file) {

		if (file.isEmpty()) {
			return new ResponseEntity<>("ERRO! O Arquivo está vazio!", HttpStatus.BAD_REQUEST);
		}

		List<Fornecedor> forList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			forList = br.lines().skip(1).map(line -> line.trim().split(";")).map(fields -> {
				Fornecedor fornec = new Fornecedor();

				Long cdufd = Long.parseLong(fields[7]);
				Optional<UFD> optUfd = ufdRepo.findById(cdufd);

				fornec.setCdFor(Long.parseLong(fields[0]));
				fornec.setRazSoc(fields[1]);
				fornec.setNomeFant(fields[2]);
				fornec.setEndereco(fields[3]);
				fornec.setBairro(fields[4]);
				fornec.setCep(fields[5]);
				fornec.setMunicipio(fields[6]);
				fornec.setFornecUfd(optUfd.get());
				fornec.setContato(fields[8]);
				fornec.setDep(fields[9]);
				fornec.setTipoJF(Double.parseDouble(fields[10]));
				fornec.setCnpj(fields[11]);
				fornec.setInscrEst(fields[12]);
				fornec.setInscrMun(fields[13]);
				fornec.setTelefone1(fields[14]);
				fornec.setTelefone2(fields[15]);
				fornec.setTelefone3(fields[16]);
				fornec.setEmail1(fields[17]);
				fornec.setEmail2(fields[18]);
				fornec.setEmail3(fields[19]);
				fornec.setDesc1(fields[20]);
				fornec.setDesc2(fields[21]);
				fornec.setDesc3(fields[22]);
				fornec.setDesc4(fields[23]);
				fornec.setDesc5(fields[24]);
				fornec.setDesc6(fields[25]);
				fornec.setDiferen(Double.parseDouble(fields[26]));
				fornec.setRep1(fields[27]);
				fornec.setRep2(fields[28]);
				fornec.setRep3(fields[29]);
				fornec.setRep4(fields[30]);
				fornec.setObs(fields[31]);
				fornec.setPlanObs(fields[32]);
				fornec.setBloq(fields[33].equalsIgnoreCase("s"));
				fornec.setCrdIcms(fields[34]);
				fornec.setPcCrIcms1(Double.parseDouble(fields[35]));
				fornec.setPcCrIcms2(Double.parseDouble(fields[36]));
				fornec.setPcCrIcms3(Double.parseDouble(fields[37]));
				
				return fornec;
			
			}).collect(Collectors.toList());
			
			fornecRepo.saveAll(forList); 

			return new ResponseEntity<>("Sucesso ao inserir os dados!", HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}

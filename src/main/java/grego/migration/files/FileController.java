package grego.migration.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import grego.cadastros.models.Empresa;
import grego.cadastros.models.Fornecedor;
import grego.cadastros.repositories.EmpresaRepository;
import grego.cadastros.repositories.FornecRepository;

@RestController
@RequestMapping("/files")
public class FileController {

	@Autowired
	private EmpresaRepository empRepo;
	
	@Autowired
	private FornecRepository forRepo; 

	@PostMapping("uploadEmp")
	public ResponseEntity<String> uploadEmp(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return new ResponseEntity<>("Arquivo vazio!", HttpStatus.NOT_FOUND);
		}

		List<Empresa> empList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			empList = br.lines().skip(1).map(line -> line.trim().split(",")).map(fields -> {
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
	
	/*
	@PostMapping("/fornecUpload")
	public ResponseEntity<String> uploadFornec(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return new ResponseEntity<>("ERRO! O Arquivo está vazio!", HttpStatus.BAD_REQUEST);
		}
	
		List<Fornecedor> forList = new ArrayList<>(); 
	try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
		forList = br.lines().map(line -> line.trim().split(";")).map(fields -> {
			
			
			
			
			
			
			
			
			
			
		})
				

	}catch(IOException e) {
		
	}
	
	}
	*/
}

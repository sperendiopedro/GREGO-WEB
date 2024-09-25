package grego.migration.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import grego.cadastros.models.Empresa;
import grego.cadastros.repositories.EmpresaRepository;

@RestController
@RequestMapping("/files")
public class FileController {

	@Autowired
	private EmpresaRepository empRepo;

	@PostMapping("upload")
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return new ResponseEntity<>("Arquivo vazio!", HttpStatus.NOT_FOUND);
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(";");
					Empresa emp = new Empresa();
					emp.setRazSoc(fields[0]);
					emp.setNomeFant(fields[1]);
					emp.setEndereco(fields[2]);
					emp.setBairro(fields[3]);
					emp.setCep(fields[4]);
					emp.setCnpj(fields[5]);
					emp.setInscrMun(fields[6]);
					emp.setInscrEst(fields[8]);			
					emp.setTelefone(fields[7]);
					emp.setEmail(fields[8]);
					emp.setRelSoc(Double.parseDouble(fields[9]));
					emp.setNrCupom(Double.parseDouble(fields[10]));
					emp.setObs(fields[11]);
					empRepo.saveAndFlush(emp);
					line = br.readLine();
			}
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}

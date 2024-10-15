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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import grego.cadastros.models.UFD;
import grego.cadastros.repositories.UFDRepository;

@RestController
@RequestMapping("/ufd")
public class UFDController {

	@Autowired
	private UFDRepository ufdRepo;
	
	@GetMapping("/listUfd")
	public List<UFD> listAll() {
		return ufdRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<UFD>> listById(@PathVariable Long id) {
		Optional<UFD> data = ufdRepo.findById(id);
		if (data.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@PostMapping("/saveUfd")
	public ResponseEntity<String> register(@RequestBody UFD ufd) {
		if (ufdRepo.findBySigla(ufd.getSigla()) != null) {
			return new ResponseEntity<>("Objeto UFD, já existe!", HttpStatus.CONFLICT);
		}
		ufdRepo.saveAndFlush(ufd);
		return new ResponseEntity<>("Objeto UFD salvo com sucesso!", HttpStatus.OK);
	}
	
	@PostMapping("/uploadUfd")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		if(file.isEmpty()) {
			return new ResponseEntity<>("Arquivo vazio!", HttpStatus.BAD_REQUEST);
		}
		
		List<UFD> ufdList = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			
			ufdList = br.lines().skip(1).map(line -> line.trim().split(";")).map(fields -> {
				UFD ufd = new UFD(); 
				ufd.setSigla(fields[0]); 
				ufd.setNome(fields[1]);
				ufd.setAliqIcms(Double.parseDouble(fields[2])); 
			return ufd;
			}).collect(Collectors.toList()); 
			
			ufdRepo.saveAll(ufdList); 
			return new ResponseEntity<>("Sucesso!", HttpStatus.OK); 
		}catch(IOException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); 
		}
		
	}

	@PatchMapping("/updateUfd")
	public ResponseEntity<String> update(@RequestBody UFD newUfd) {
		if (newUfd.getCdUfd() == null) {
			return new ResponseEntity<>("ID NULL", HttpStatus.BAD_REQUEST);
		}
		Optional<UFD> existingUfdOpt = ufdRepo.findById(newUfd.getCdUfd());
		if (!existingUfdOpt.isPresent()) {
			return new ResponseEntity<>("UFD não encontrada!", HttpStatus.NOT_FOUND);
		}

		// think about a while condition to check the fields
		UFD existingUfd = existingUfdOpt.get();
		if (newUfd.getNome() != null)
			existingUfd.setNome(newUfd.getNome());
		if (newUfd.getSigla() != null)
			existingUfd.setSigla(newUfd.getSigla());
		if (newUfd.getAliqIcms() != 0)
			existingUfd.setAliqIcms(newUfd.getAliqIcms());
		ufdRepo.saveAndFlush(existingUfd);
		return ResponseEntity.ok("UFD altered");
	}

}

package grego.cadastros.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import grego.cadastros.models.UFD;
import grego.cadastros.repositories.UFDRepository;

@RestController
@RequestMapping("/ufd")
@CrossOrigin(origins = "*")
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

	@PatchMapping("/updateUfd")
	public ResponseEntity<String> update(@RequestBody UFD newUfd) {
		if (newUfd.getCdUfd() == null) {
			return new ResponseEntity<>("Id null", HttpStatus.BAD_REQUEST);
		}
		Optional<UFD> existingUfdOpt = ufdRepo.findById(newUfd.getCdUfd());
		if (!existingUfdOpt.isPresent()) {
			return new ResponseEntity<>("UFD não encontrada!", HttpStatus.BAD_REQUEST);
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

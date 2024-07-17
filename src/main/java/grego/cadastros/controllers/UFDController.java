package grego.cadastros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.cadastros.models.UFD;
import grego.cadastros.repositories.UFDRepository;

@RestController
@RequestMapping("/ufd")
public class UFDController {
	
	@Autowired
	private UFDRepository ufdRepo; 
	
	@GetMapping("/listUfd")
	public List<UFD> listAll(){
		return ufdRepo.findAll(); 
	}
	
	@PostMapping("/saveUfd")
	public ResponseEntity register(@RequestBody UFD ufd) {
		if()
		else ufdRepo.saveAndFlush(ufd); 
		return ResponseEntity.ok("UFD Registrado"); 
	}	
	
	@PatchMapping("/updateUfd") 
	public ResponseEntity update(@RequestBody UFD newUfd) {
		if(newUfd.getId() == null) return new ResponseEntity("Id null", HttpStatus.BAD_REQUEST);
		else {
			ufdRepo.save(newUfd); 
		}
		return ResponseEntity.ok("UFD altered"); 
	}

	
}

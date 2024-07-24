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
@CrossOrigin(origins="*")
public class UFDController {
	
	@Autowired
	private UFDRepository ufdRepo; 
	
	@GetMapping("/listUfd")
	public List<UFD> listAll(){
		return ufdRepo.findAll(); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<UFD>> listById(@PathVariable Long id){
		if(ufdRepo.findById(id) != null) return new ResponseEntity("UFD não encontrada!", HttpStatus.BAD_REQUEST); 
		else ufdRepo.findById(id); 
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	@PostMapping("/saveUfd")
	public ResponseEntity<String> register(@RequestBody UFD ufd) {
		if(ufdRepo.findBySigla(ufd.getSigla()) != null) {
			return new ResponseEntity<>("Unidade Federal já existente", HttpStatus.BAD_REQUEST); 
		}
 		ufdRepo.saveAndFlush(ufd); 
		return ResponseEntity.ok("UFD Registrado"); 
	}	
		
	   @PatchMapping("/updateUfd")
	    public ResponseEntity<String> update(@RequestBody UFD newUfd) {
	        if (newUfd.getId() == null) {
	            return new ResponseEntity<>("Id null", HttpStatus.BAD_REQUEST);
	        }
	        Optional<UFD> existingUfdOpt = ufdRepo.findById(newUfd.getId());
	        if (!existingUfdOpt.isPresent()) {
	            return new ResponseEntity<>("UFD não encontrada!", HttpStatus.BAD_REQUEST);
	        }
	        
	        //think about a while condition to check the fieds
	        UFD existingUfd = existingUfdOpt.get();
	        if (newUfd.getNome() != null) existingUfd.setNome(newUfd.getNome());
	        if (newUfd.getSigla() != null) existingUfd.setSigla(newUfd.getSigla());
	        if (newUfd.getAliqIcms() != 0) existingUfd.setAliqIcms(newUfd.getAliqIcms());
	        ufdRepo.saveAndFlush(existingUfd);
	        return ResponseEntity.ok("UFD altered");
	    }
	
}

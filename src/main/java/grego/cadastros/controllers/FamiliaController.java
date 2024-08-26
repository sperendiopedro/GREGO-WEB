package grego.cadastros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.cadastros.models.Familia;
import grego.cadastros.repositories.FamiliaRepository;

@RestController
@RequestMapping("/familia")
public class FamiliaController {

	@Autowired
	private FamiliaRepository famRepo; 
	
	@GetMapping("/list")
	public List<Familia> findAll(){
		return famRepo.findAll();
	}
	
	
	
	
}

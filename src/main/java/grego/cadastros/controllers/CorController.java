package grego.cadastros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.cadastros.models.Cor;
import grego.cadastros.repositories.CorRepository;

@RestController
@RequestMapping("/cor")
public class CorController {
	@Autowired
	private CorRepository corRepo; 
	
	@GetMapping("/list")
	public List<Cor> findAll(){
		return corRepo.findAll(); 
	}
}

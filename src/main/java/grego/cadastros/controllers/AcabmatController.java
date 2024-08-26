package grego.cadastros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.cadastros.models.Acabmat;
import grego.cadastros.repositories.AcabmatRepository;

@RestController
@RequestMapping("/acabmat")
public class AcabmatController {
	@Autowired
	private AcabmatRepository acbmatRepo; 
	
	@GetMapping("/list")
	public List<Acabmat> findAll(){
		return acbmatRepo.findAll(); 
	}
}

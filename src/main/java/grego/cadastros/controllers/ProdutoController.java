package grego.cadastros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.cadastros.models.Produto;
import grego.cadastros.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository prodRepo; 

	@GetMapping
	public List<Produto> findAll(){
		return prodRepo.findAll(); 
	}
 	
	
}

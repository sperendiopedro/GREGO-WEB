package grego.cadastros.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.cadastros.models.Empresa;
import grego.cadastros.models.Produto;
import grego.cadastros.repositories.EmpresaRepository;
import grego.cadastros.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository prodRepo; 
	@Autowired
	private EmpresaRepository empRepo; 
	
	
	@GetMapping
	public List<Produto> findAll(){
		return prodRepo.findAll(); 
	}
 	
	@PostMapping("/register")
	public ResponseEntity<String> registerProd(@RequestBody Produto prod){ 
		if(prod.getProdEmp() != null && prod.getProdEmp().getId() != null) {
			Optional<Empresa> optEmp = empRepo.findById(prod.getProdEmp().getId()); 
			if(!optEmp.isPresent()) {
				return new ResponseEntity<>("Empresa não existe!", HttpStatus.BAD_REQUEST);
			}
				prod.setProdEmp(optEmp.get()); 
			}else{
				return new ResponseEntity<>("Objeto empresa é obrigatório!", HttpStatus.BAD_REQUEST); 
			}
			Optional<Produto> optProd = prodRepo.findByDescAndProdEmp(prod.getDescr(), prod.getProdEmp()); 
			if(!optProd.isPresent()) {
				return new ResponseEntity<>("Objeto produto já existe no banco de dados!", HttpStatus.CONFLICT); 
			}
		prodRepo.saveAndFlush(prod); 	
		return new ResponseEntity<>("Objeto produto criado com sucesso!", HttpStatus.OK);
	}
}

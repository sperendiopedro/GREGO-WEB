package grego.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.models.Empresa;
import grego.respositories.EmpresaRepository;


@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository empRepository; 
	
	@PostMapping("/saveEmp")
	public ResponseEntity<String> saveEmp(@RequestBody Empresa emp, BindingResult result) {
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors occurred.");
        }
        empRepository.saveAndFlush(emp);
        return ResponseEntity.ok("Empresa criada com sucesso!");
    }

	@GetMapping("/listEmp")
	public List<Empresa> listAll(){
		return empRepository.findAll(); 
	}
}

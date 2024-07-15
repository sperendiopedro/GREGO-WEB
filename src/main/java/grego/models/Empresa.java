package grego.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB0002_EMPRESA")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(nullable = false)
	private String razSoc; 
	
	@Column(nullable = false)
	private String cnpj;
	
	public Empresa() {
		
	}
	
	public Empresa(Long id, String razSoc, String cnpj) {
		this.id = id;
		this.razSoc = razSoc;
		this.cnpj = cnpj;
	}

	public Long getId() {
		return id;
	}
	
	public String getRazSoc() {
		return razSoc;
	}

	public void setRazSoc(String razSoc) {
		this.razSoc = razSoc;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	} 
	
}

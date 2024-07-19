package grego.cadastros.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB004_FORNECEDOR")
public class Fornecedor implements Serializable{
	private static final long seialVersionUID = 1L; 
	
	@OneToOne
	private UFD ufd; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(nullable = false)
	private String razSoc; 
	
	@Column(nullable = false)
	private String nomeFant;
	
	@Column(nullable = false)
	private String end;
	
	@Column(nullable = false)
	private String bairro; 
	
	@Column(nullable = false)
	private String cep; 
	
	@Column(nullable = false)
	private String municipio; 
	
	@Column(nullable = false)
	private String contato; 
	
	@Column(nullable = false)
	private String dep; 
	
	@Column(nullable = false)
	private String cnpj; 
	
	@Column(nullable = false)
	private String inscrMun;
	
	@Column(nullable = false)
	private String inscrEst;
	
	@Column(nullable = false)
	private String telefone; 
	
	@Column(nullable = false)
	private String email; 
	
	@Column(nullable = false)
	private Double relSoc; 
	
	@Column(nullable = false)
	private Double nrCupom; 
	
	@Column(nullable = false)
	private String obs;

	
}

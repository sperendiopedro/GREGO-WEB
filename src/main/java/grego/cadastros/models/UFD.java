package grego.cadastros.models;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB0002_UFD")
public class UFD implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "ufd")
	private Set<Empresa> empresa;

	@OneToMany(mappedBy= "ufd")
	private Set<Fornecedor> fornec; 
	
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	@Length(min = 2, max = 2)
	private String sigla;

	@Column(nullable = false)
	private float aliqIcsm;

	public UFD() {
	}

	public UFD(Long id, String nome, String sigla, float aliqIcsm) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.aliqIcsm = aliqIcsm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public float getAliqIcsm() {
		return aliqIcsm;
	}

	public void setAliqIcsm(float aliqIcsm) {
		this.aliqIcsm = aliqIcsm;
	}

	public Long getId() {
		return id;
	}

}

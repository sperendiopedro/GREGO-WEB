package grego.cadastros.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB0002_UFD")
public class UFD {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
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

package grego.cadastros.models;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB0003_UFD")
public class UFD implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	@Length(min = 2, max = 2)
	private String sigla;

	@Column(nullable = false)
	private Double aliqIcms;
	
	@OneToMany(mappedBy= "fornec_ufd")
	@JsonIgnore
	private Set<Fornecedor> ufd_fornec; 
	
	@ManyToOne
	@JoinColumn(name = "id_emp", nullable = false)
	private Empresa ufd_emp; 
	
	public UFD() {
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

	public Double getAliqIcms() {
		return aliqIcms;
	}

	public void setAliqIcms(Double aliqIcms) {
		this.aliqIcms = aliqIcms;
	}
	
	public Set<Fornecedor> getUfd_fornec() {
		return ufd_fornec;
	}

	public void setUfd_fornec(Set<Fornecedor> ufd_fornec) {
		this.ufd_fornec = ufd_fornec;
	}

	public Empresa getUfd_emp() {
		return ufd_emp;
	}

	public void setUfd_emp(Empresa ufd_emp) {
		this.ufd_emp = ufd_emp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}
	
}

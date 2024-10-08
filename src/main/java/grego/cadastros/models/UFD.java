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
	private Long cdUfd;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	@Length(min = 2, max = 2)
	private String sigla;

	@Column(nullable = false)
	private Double aliqIcms;

	@OneToMany(mappedBy = "fornecUfd")
	@JsonIgnore
	private Set<Fornecedor> ufdFornec;

	public UFD() {
	}

	public UFD(Long cdUfd, String nome, @Length(min = 2, max = 2) String sigla, Double aliqIcms, Set<Fornecedor> ufdFornec,
			Empresa ufdEmp) {
		this.cdUfd = cdUfd;
		this.nome = nome;
		this.sigla = sigla;
		this.aliqIcms = aliqIcms;
		this.ufdFornec = ufdFornec;
	}

	public Long getCdUfd() {
		return cdUfd;
	}
	
	public void setCdUfd(Long cdUfd){
		this.cdUfd=cdUfd; 
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

	public Set<Fornecedor> getUfdFornec() {
		return ufdFornec;
	}

	public void setUfdFornec(Set<Fornecedor> ufdFornec) {
		this.ufdFornec = ufdFornec;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

package grego.cadastros.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB0003_EMPRESA")
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@ManyToOne
	@JoinColumn(
				name="ufd_id", nullable=false
			)
	private UFD ufd; 
	
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

	public Empresa() {
	}
	
	public Empresa(Long id, UFD ufd, String razSoc, String nomeFant, String end, String bairro, String cep, String cnpj,
			String inscrMun, String inscrEst, String telefone, String email, Double relSoc, Double nrCupom,
			String obs) {
		this.id = id;
		this.ufd = ufd;
		this.razSoc = razSoc;
		this.nomeFant = nomeFant;
		this.end = end;
		this.bairro = bairro;
		this.cep = cep;
		this.cnpj = cnpj;
		this.inscrMun = inscrMun;
		this.inscrEst = inscrEst;
		this.telefone = telefone;
		this.email = email;
		this.relSoc = relSoc;
		this.nrCupom = nrCupom;
		this.obs = obs;
	}

	public UFD getUfd() {
		return ufd;
	}

	public void setUfd(UFD ufd) {
		this.ufd = ufd;
	}

	public String getRazSoc() {
		return razSoc;
	}

	public void setRazSoc(String razSoc) {
		this.razSoc = razSoc;
	}

	public String getNomeFant() {
		return nomeFant;
	}

	public void setNomeFant(String nomeFant) {
		this.nomeFant = nomeFant;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscrMun() {
		return inscrMun;
	}

	public void setInscrMun(String inscrMun) {
		this.inscrMun = inscrMun;
	}

	public String getInscrEst() {
		return inscrEst;
	}

	public void setInscrEst(String inscrEst) {
		this.inscrEst = inscrEst;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getRelSoc() {
		return relSoc;
	}

	public void setRelSoc(Double relSoc) {
		this.relSoc = relSoc;
	}

	public Double getNrCupom() {
		return nrCupom;
	}

	public void setNrCupom(Double nrCupom) {
		this.nrCupom = nrCupom;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Long getId() {
		return id;
	} 
	
	
	
}

package grego.cadastros.models;

import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB0002_EMPRESA")
@CrossOrigin(origins = "*")
public class Empresa {
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

	@OneToMany(mappedBy = "ufd_emp")
	@JsonIgnore
	private Set<UFD> empUfd;

	@OneToMany(mappedBy = "fornec_emp")
	@JsonIgnore
	private Set<Fornecedor> empFornec;

	@OneToMany(mappedBy = "fam_emp")
	@JsonIgnore
	private Set<Familia> empFam;

	@OneToMany(mappedBy = "prod_emp")
	@JsonIgnore
	private Set<Produto> empProd;

	@OneToMany(mappedBy = "acabmat_emp")
	@JsonIgnore
	private Set<Acabmat> empAcabmat;

	@OneToMany(mappedBy = "cor_emp")
	@JsonIgnore
	private Set<Cor> empCor;

	public Empresa() {
	}

	public Empresa(Long id, String razSoc, String nomeFant, String end, String bairro, String cep, String cnpj,
			String inscrMun, String inscrEst, String telefone, String email, Double relSoc, Double nrCupom, String obs,
			Set<UFD> empUfd, Set<Fornecedor> empFornec, Set<Familia> empFam, Set<Produto> empProd,
			Set<Acabmat> empAcabmat, Set<Cor> empCor) {
		super();
		this.id = id;
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
		this.empUfd = empUfd;
		this.empFornec = empFornec;
		this.empFam = empFam;
		this.empProd = empProd;
		this.empAcabmat = empAcabmat;
		this.empCor = empCor;
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

	public Set<UFD> getEmpUfd() {
		return empUfd;
	}

	public void setEmpUfd(Set<UFD> empUfd) {
		this.empUfd = empUfd;
	}

	public Set<Fornecedor> getEmpFornec() {
		return empFornec;
	}

	public void setEmpFornec(Set<Fornecedor> empFornec) {
		this.empFornec = empFornec;
	}

	public Set<Familia> getEmpFam() {
		return empFam;
	}

	public void setEmpFam(Set<Familia> empFam) {
		this.empFam = empFam;
	}

	public Set<Produto> getEmpProd() {
		return empProd;
	}

	public void setEmpProd(Set<Produto> empProd) {
		this.empProd = empProd;
	}

	public Set<Acabmat> getEmpAcabmat() {
		return empAcabmat;
	}

	public void setEmpAcabmat(Set<Acabmat> empAcabmat) {
		this.empAcabmat = empAcabmat;
	}

	public Set<Cor> getEmpCor() {
		return empCor;
	}

	public void setEmpCor(Set<Cor> empCor) {
		this.empCor = empCor;
	}

}

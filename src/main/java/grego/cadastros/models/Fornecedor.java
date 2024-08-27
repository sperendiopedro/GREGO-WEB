package grego.cadastros.models;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB0004_FORNECEDOR")
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

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
	private Double tipoJF;

	@Column(nullable = false)
	private String cnpj;

	@Column(nullable = false)
	private String inscrEst;

	@Column(nullable = false)
	private String inscrMun;

	@Column(nullable = false)
	private String telefone1;

	@Column(nullable = true)
	private String telefone2;

	@Column(nullable = true)
	private String telefone3;

	@Column(nullable = false)
	private String email1;

	@Column(nullable = true)
	private String email2;

	@Column(nullable = true)
	private String email3;

	@Column(nullable = false)
	private String desc1;

	@Column(nullable = true)
	private String desc2;

	@Column(nullable = true)
	private String desc3;

	@Column(nullable = true)
	private String desc4;

	@Column(nullable = true)
	private String desc5;

	@Column(nullable = true)
	private String desc6;

	@Column(nullable = false)
	private Double diferen;

	@Column(nullable = false)
	private Double rep1;

	@Column(nullable = true)
	private Double rep2;

	@Column(nullable = true)
	private Double rep3;

	@Column(nullable = true)
	private Double rep4;

	@Column(nullable = false)
	private String obs;

	@Column(nullable = false)
	private String planObs;

	@Column(nullable = false)
	private boolean bloq;

	@Column(nullable = false)
	@Length(max = 1, min = 1)
	private String crdIcms;

	@Column(nullable = false)
	private Double pcCrIcms1;

	@Column(nullable = true)
	private Double pcCrIcms2;

	@Column(nullable = true)
	private Double pcCrIcms3;

	@ManyToOne
	@JoinColumn(name = "fornec_ufd", nullable = false)
	private UFD fornecUfd;

	@ManyToOne
	@JoinColumn(name = "fornec_emp", nullable = false)
	private Empresa fornecEmp;

	public Fornecedor() {
	}

	public Fornecedor(Long id, String razSoc, String nomeFant, String end, String bairro, String cep, String municipio,
			String contato, String dep, Double tipoJF, String cnpj, String inscrEst, String inscrMun, String telefone1,
			String telefone2, String telefone3, String email1, String email2, String email3, String desc1, String desc2,
			String desc3, String desc4, String desc5, String desc6, Double diferen, Double rep1, Double rep2,
			Double rep3, Double rep4, String obs, String planObs, boolean bloq,
			@Length(max = 1, min = 1) String crdIcms, Double pcCrIcms1, Double pcCrIcms2, Double pcCrIcms3,
			UFD fornecUfd, Empresa fornecEmp) {
		this.id = id;
		this.razSoc = razSoc;
		this.nomeFant = nomeFant;
		this.end = end;
		this.bairro = bairro;
		this.cep = cep;
		this.municipio = municipio;
		this.contato = contato;
		this.dep = dep;
		this.tipoJF = tipoJF;
		this.cnpj = cnpj;
		this.inscrEst = inscrEst;
		this.inscrMun = inscrMun;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
		this.email1 = email1;
		this.email2 = email2;
		this.email3 = email3;
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.desc3 = desc3;
		this.desc4 = desc4;
		this.desc5 = desc5;
		this.desc6 = desc6;
		this.diferen = diferen;
		this.rep1 = rep1;
		this.rep2 = rep2;
		this.rep3 = rep3;
		this.rep4 = rep4;
		this.obs = obs;
		this.planObs = planObs;
		this.bloq = bloq;
		this.crdIcms = crdIcms;
		this.pcCrIcms1 = pcCrIcms1;
		this.pcCrIcms2 = pcCrIcms2;
		this.pcCrIcms3 = pcCrIcms3;
		this.fornecUfd = fornecUfd;
		this.fornecEmp = fornecEmp;
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

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public Double getTipoJF() {
		return tipoJF;
	}

	public void setTipoJF(Double tipoJF) {
		this.tipoJF = tipoJF;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscrEst() {
		return inscrEst;
	}

	public void setInscrEst(String inscrEst) {
		this.inscrEst = inscrEst;
	}

	public String getInscrMun() {
		return inscrMun;
	}

	public void setInscrMun(String inscrMun) {
		this.inscrMun = inscrMun;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public String getDesc2() {
		return desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}

	public String getDesc3() {
		return desc3;
	}

	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}

	public String getDesc4() {
		return desc4;
	}

	public void setDesc4(String desc4) {
		this.desc4 = desc4;
	}

	public String getDesc5() {
		return desc5;
	}

	public void setDesc5(String desc5) {
		this.desc5 = desc5;
	}

	public String getDesc6() {
		return desc6;
	}

	public void setDesc6(String desc6) {
		this.desc6 = desc6;
	}

	public Double getDiferen() {
		return diferen;
	}

	public void setDiferen(Double diferen) {
		this.diferen = diferen;
	}

	public Double getRep1() {
		return rep1;
	}

	public void setRep1(Double rep1) {
		this.rep1 = rep1;
	}

	public Double getRep2() {
		return rep2;
	}

	public void setRep2(Double rep2) {
		this.rep2 = rep2;
	}

	public Double getRep3() {
		return rep3;
	}

	public void setRep3(Double rep3) {
		this.rep3 = rep3;
	}

	public Double getRep4() {
		return rep4;
	}

	public void setRep4(Double rep4) {
		this.rep4 = rep4;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getPlanObs() {
		return planObs;
	}

	public void setPlanObs(String planObs) {
		this.planObs = planObs;
	}

	public boolean isBloq() {
		return bloq;
	}

	public void setBloq(boolean bloq) {
		this.bloq = bloq;
	}

	public String getCrdIcms() {
		return crdIcms;
	}

	public void setCrdIcms(String crdIcms) {
		this.crdIcms = crdIcms;
	}

	public Double getPcCrIcms1() {
		return pcCrIcms1;
	}

	public void setPcCrIcms1(Double pcCrIcms1) {
		this.pcCrIcms1 = pcCrIcms1;
	}

	public Double getPcCrIcms2() {
		return pcCrIcms2;
	}

	public void setPcCrIcms2(Double pcCrIcms2) {
		this.pcCrIcms2 = pcCrIcms2;
	}

	public Double getPcCrIcms3() {
		return pcCrIcms3;
	}

	public void setPcCrIcms3(Double pcCrIcms3) {
		this.pcCrIcms3 = pcCrIcms3;
	}

	public UFD getFornecUfd() {
		return fornecUfd;
	}

	public void setFornecUfd(UFD fornecUfd) {
		this.fornecUfd = fornecUfd;
	}

	public Empresa getFornecEmp() {
		return fornecEmp;
	}

	public void setFornecEmp(Empresa fornecEmp) {
		this.fornecEmp = fornecEmp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}
	


}

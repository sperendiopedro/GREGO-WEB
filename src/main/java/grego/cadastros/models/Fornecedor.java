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
@Table(name = "TB004_FORNECEDOR")
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "ufd_id_fornec", nullable = false)
    private UFD ufd_fornec;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Empresa emp;

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
    private String telefone_1;

    @Column(nullable = true)
    private String telefone_2;

    @Column(nullable = true)
    private String telefone_3;

    @Column(nullable = false)
    private String email_1;

    @Column(nullable = true)
    private String email_2;

    @Column(nullable = true)
    private String email_3;

    @Column(nullable = false)
    private String desc_1;

    @Column(nullable = true)
    private String desc_2;

    @Column(nullable = true)
    private String desc_3;

    @Column(nullable = true)
    private String desc_4;

    @Column(nullable = true)
    private String desc_5;

    @Column(nullable = true)
    private String desc_6;

    @Column(nullable = false)
    private Double diferen;

    @Column(nullable = false)
    private Double rep_1;

    @Column(nullable = true)
    private Double rep_2;

    @Column(nullable = true)
    private Double rep_3;

    @Column(nullable = true)
    private Double rep_4;

    @Column(nullable = false)
    private String obs;

    @Column(nullable = false)
    private String plan_obs;

    @Column(nullable = false)
    private boolean bloq;

    @Column(nullable = false)
    @Length(max = 1, min = 1)
    private String crd_icms;

    @Column(nullable = false)
    private Double pc_cr_icms_1;

    @Column(nullable = true)
    private Double pc_cr_icms_2;

    @Column(nullable = true)
    private Double pc_cr_icms_3;

    public Fornecedor() {}

    public Fornecedor(UFD ufd_fornec, Empresa emp, Long id, String razSoc, String nomeFant, String end, String bairro,
                      String cep, String municipio, String contato, String dep, Double tipoJF, String cnpj, String inscrEst,
                      String inscrMun, String telefone_1, String telefone_2, String telefone_3, String email_1, String email_2,
                      String email_3, String desc_1, String desc_2, String desc_3, String desc_4, String desc_5,
                      String desc_6, Double diferen, Double rep_1, Double rep_2, Double rep_3, Double rep_4, String obs,
                      String plan_obs, boolean bloq, @Length(max = 1, min = 1) String crd_icms, Double pc_cr_icms_1,
                      Double pc_cr_icms_2, Double pc_cr_icms_3) {
        this.ufd_fornec = ufd_fornec;
        this.emp = emp;
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
        this.telefone_1 = telefone_1;
        this.telefone_2 = telefone_2;
        this.telefone_3 = telefone_3;
        this.email_1 = email_1;
        this.email_2 = email_2;
        this.email_3 = email_3;
        this.desc_1 = desc_1;
        this.desc_2 = desc_2;
        this.desc_3 = desc_3;
        this.desc_4 = desc_4;
        this.desc_5 = desc_5;
        this.desc_6 = desc_6;
        this.diferen = diferen;
        this.rep_1 = rep_1;
        this.rep_2 = rep_2;
        this.rep_3 = rep_3;
        this.rep_4 = rep_4;
        this.obs = obs;
        this.plan_obs = plan_obs;
        this.bloq = bloq;
        this.crd_icms = crd_icms;
        this.pc_cr_icms_1 = pc_cr_icms_1;
        this.pc_cr_icms_2 = pc_cr_icms_2;
        this.pc_cr_icms_3 = pc_cr_icms_3;
    }

	public UFD getUfd() {
		return ufd_fornec;
	}

	public void setUfd(UFD ufd_fornec) {
		this.ufd_fornec = ufd_fornec;
	}

	public Empresa getEmp() {
		return emp;
	}

	public void setEmp(Empresa emp) {
		this.emp = emp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTelefone_1() {
		return telefone_1;
	}

	public void setTelefone_1(String telefone_1) {
		this.telefone_1 = telefone_1;
	}

	public String getTelefone_2() {
		return telefone_2;
	}

	public void setTelefone_2(String telefone_2) {
		this.telefone_2 = telefone_2;
	}

	public String getTelefone_3() {
		return telefone_3;
	}

	public void setTelefone_3(String telefone_3) {
		this.telefone_3 = telefone_3;
	}

	public String getEmail_1() {
		return email_1;
	}

	public void setEmail_1(String email_1) {
		this.email_1 = email_1;
	}

	public String getEmail_2() {
		return email_2;
	}

	public void setEmail_2(String email_2) {
		this.email_2 = email_2;
	}

	public String getEmail_3() {
		return email_3;
	}

	public void setEmail_3(String email_3) {
		this.email_3 = email_3;
	}

	public String getDesc_1() {
		return desc_1;
	}

	public void setDesc_1(String desc_1) {
		this.desc_1 = desc_1;
	}

	public String getDesc_2() {
		return desc_2;
	}

	public void setDesc_2(String desc_2) {
		this.desc_2 = desc_2;
	}

	public String getDesc_3() {
		return desc_3;
	}

	public void setDesc_3(String desc_3) {
		this.desc_3 = desc_3;
	}

	public String getDesc_4() {
		return desc_4;
	}

	public void setDesc_4(String desc_4) {
		this.desc_4 = desc_4;
	}

	public String getDesc_5() {
		return desc_5;
	}

	public void setDesc_5(String desc_5) {
		this.desc_5 = desc_5;
	}

	public String getDesc_6() {
		return desc_6;
	}

	public void setDesc_6(String desc_6) {
		this.desc_6 = desc_6;
	}

	public Double getDiferen() {
		return diferen;
	}

	public void setDiferen(Double diferen) {
		this.diferen = diferen;
	}

	public Double getRep_1() {
		return rep_1;
	}

	public void setRep_1(Double rep_1) {
		this.rep_1 = rep_1;
	}

	public Double getRep_2() {
		return rep_2;
	}

	public void setRep_2(Double rep_2) {
		this.rep_2 = rep_2;
	}

	public Double getRep_3() {
		return rep_3;
	}

	public void setRep_3(Double rep_3) {
		this.rep_3 = rep_3;
	}

	public Double getRep_4() {
		return rep_4;
	}

	public void setRep_4(Double rep_4) {
		this.rep_4 = rep_4;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getPlan_obs() {
		return plan_obs;
	}

	public void setPlan_obs(String plan_obs) {
		this.plan_obs = plan_obs;
	}

	public boolean isBloq() {
		return bloq;
	}

	public void setBloq(boolean bloq) {
		this.bloq = bloq;
	}

	public String getCrd_icms() {
		return crd_icms;
	}

	public void setCrd_icms(String crd_icms) {
		this.crd_icms = crd_icms;
	}

	public Double getPc_cr_icms_1() {
		return pc_cr_icms_1;
	}

	public void setPc_cr_icms_1(Double pc_cr_icms_1) {
		this.pc_cr_icms_1 = pc_cr_icms_1;
	}

	public Double getPc_cr_icms_2() {
		return pc_cr_icms_2;
	}

	public void setPc_cr_icms_2(Double pc_cr_icms_2) {
		this.pc_cr_icms_2 = pc_cr_icms_2;
	}

	public Double getPc_cr_icms_3() {
		return pc_cr_icms_3;
	}

	public void setPc_cr_icms_3(Double pc_cr_icms_3) {
		this.pc_cr_icms_3 = pc_cr_icms_3;
	}

	public static long getSeialversionuid() {
		return serialVersionUID;
	}

	
	




}


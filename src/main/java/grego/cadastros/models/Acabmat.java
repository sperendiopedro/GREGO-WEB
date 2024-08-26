package grego.cadastros.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "TB0007_ACABMAT")
public class Acabmat implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(nullable = false)
	private String desc; 
	
	@Column(nullable = false)
	private String obs; 
	
	@ManyToOne
	@JoinColumn(name="acabmat_emp", nullable = false)
	private Empresa acbmatEmp; 
	
	public Acabmat() {
	}

	public Acabmat(Long id, String desc, String obs, Empresa acbmatEmp) {
		this.id = id;
		this.desc = desc;
		this.obs = obs;
		this.acbmatEmp = acbmatEmp;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Empresa getAcbmatEmp() {
		return acbmatEmp;
	}

	public void setAcbmatEmp(Empresa acbmatEmp) {
		this.acbmatEmp = acbmatEmp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	
	
}


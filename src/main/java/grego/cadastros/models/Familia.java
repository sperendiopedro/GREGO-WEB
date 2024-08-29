package grego.cadastros.models;

import java.io.Serializable;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB0005_FAMILIA")
public class Familia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String descr;
	
	@Column(nullable = false)
	private String obs;

	@ManyToOne
	@JoinColumn(name = "fam_emp", nullable = false)
	private Empresa famEmp;

	public Familia() {
	}

	public Familia(Long id, String descr, String obs, Empresa famEmp) {
		this.id = id;
		this.descr = descr;
		this.obs = obs;
		this.famEmp = famEmp;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Empresa getFamEmp() {
		return famEmp;
	}

	public void setFamEmp(Empresa famEmp) {
		this.famEmp = famEmp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}
	
	
	

}

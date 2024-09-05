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
public class Acabmat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String descr;

	@Column(nullable = false)
	private String obs;

	@ManyToOne
	@JoinColumn(name = "acabmat_emp", nullable = false)
	private Empresa acabmatEmp;

	public Acabmat() {
	}

	public Acabmat(Long id, String descr, String obs, Empresa acabmatEmp) {
		this.id = id;
		this.descr = descr;
		this.obs = obs;
		this.acabmatEmp = acabmatEmp;
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

	public Empresa getAcabmatEmp() {
		return acabmatEmp;
	}

	public void setAcabmatEmp(Empresa acabmatEmp) {
		this.acabmatEmp = acabmatEmp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

}

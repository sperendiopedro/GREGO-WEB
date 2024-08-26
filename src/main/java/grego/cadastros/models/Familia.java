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
	@Column(nullable = false)
	private Long id_fam;

	@Column(nullable = false)
	private String desc;

	@Column(nullable = false)
	private String obs;

	@ManyToOne
	@JoinColumn(name = "fam_emp", nullable = false)
	private Empresa fam_emp;

	public Familia() {
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

	public Empresa getFam_emp() {
		return fam_emp;
	}

	public void setFam_emp(Empresa fam_emp) {
		this.fam_emp = fam_emp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId_fam() {
		return id_fam;
	}

}

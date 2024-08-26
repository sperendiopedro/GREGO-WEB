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
@Table(name = "TB0008_COR")
public class Cor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String desc;

	@Column(nullable = false)
	private String obs;

	@ManyToOne
	@JoinColumn(name = "cor_emp", nullable = false)
	private Empresa corEmp;

	public Cor() {
	}

	public Cor(Long id, String desc, String obs, Empresa corEmp) {
		this.id = id;
		this.desc = desc;
		this.obs = obs;
		this.corEmp = corEmp;
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

	public Empresa getCorEmp() {
		return corEmp;
	}

	public void setCorEmp(Empresa corEmp) {
		this.corEmp = corEmp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

}

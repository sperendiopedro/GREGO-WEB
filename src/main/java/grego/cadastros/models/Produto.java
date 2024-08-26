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
@Table(name = "TB0006_PRODUTOS")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String desc;

	@Column(nullable = false)
	private String obs;

	@ManyToOne
	@JoinColumn(name = "prod_emp", nullable = false)
	private Empresa prod_emp;

	public Produto() {
	}

	public Produto(Long id, String desc, String obs, Empresa prod_emp) {
		this.id = id;
		this.desc = desc;
		this.obs = obs;
		this.prod_emp = prod_emp;
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

	public Empresa getProd_emp() {
		return prod_emp;
	}

	public void setProd_emp(Empresa prod_emp) {
		this.prod_emp = prod_emp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

}

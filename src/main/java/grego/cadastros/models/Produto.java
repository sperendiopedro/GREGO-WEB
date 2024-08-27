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
	private String descr;
	
	@Column(nullable = false)
	private String obs;


	@ManyToOne
	@JoinColumn(name = "prod_emp", nullable = false)
	private Empresa prodEmp;

	public Produto() {
	}

	public Produto(Long id, String descr, String obs, Empresa prodEmp) {
		this.id = id;
		this.descr = descr;
		this.obs = obs;
		this.prodEmp = prodEmp;
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

	public Empresa getProdEmp() {
		return prodEmp;
	}

	public void setProdEmp(Empresa prodEmp) {
		this.prodEmp = prodEmp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}
	
	

}

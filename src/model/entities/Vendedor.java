package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Vendedor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idVend;
	private String nomeVend;
	private String emailVend;
	private Date dataAniVend;
	private Double salarioVend;
	private Departamento depatamento;	// ASSOCIAÇÃO DEPARTAMENTO
	
	public Vendedor() {}

	public Vendedor(Integer idVend, String nomeVend, String emailVend, Date dataAniVend, Double salarioVend,
			Departamento depatamento) {
		this.idVend = idVend;
		this.nomeVend = nomeVend;
		this.emailVend = emailVend;
		this.dataAniVend = dataAniVend;
		this.salarioVend = salarioVend;
		this.depatamento = depatamento;
	}

	public Integer getIdVend() {
		return idVend;
	}

	public void setIdVend(Integer idVend) {
		this.idVend = idVend;
	}

	public String getNomeVend() {
		return nomeVend;
	}

	public void setNomeVend(String nomeVend) {
		this.nomeVend = nomeVend;
	}

	public String getEmailVend() {
		return emailVend;
	}

	public void setEmailVend(String emailVend) {
		this.emailVend = emailVend;
	}

	public Date getDataAniVend() {
		return dataAniVend;
	}

	public void setDataAniVend(Date dataAniVend) {
		this.dataAniVend = dataAniVend;
	}

	public Double getSalarioVend() {
		return salarioVend;
	}

	public void setSalarioVend(Double salarioVend) {
		this.salarioVend = salarioVend;
	}

	public Departamento getDepatamento() {
		return depatamento;
	}

	public void setDepatamento(Departamento depatamento) {
		this.depatamento = depatamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Vendedor [idVend=" + idVend + ", nomeVend=" + nomeVend + ", emailVend=" + emailVend + ", dataAniVend="
				+ dataAniVend + ", salarioVend=" + salarioVend + ", depatamento=" + depatamento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAniVend == null) ? 0 : dataAniVend.hashCode());
		result = prime * result + ((emailVend == null) ? 0 : emailVend.hashCode());
		result = prime * result + ((idVend == null) ? 0 : idVend.hashCode());
		result = prime * result + ((nomeVend == null) ? 0 : nomeVend.hashCode());
		result = prime * result + ((salarioVend == null) ? 0 : salarioVend.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (dataAniVend == null) {
			if (other.dataAniVend != null)
				return false;
		} else if (!dataAniVend.equals(other.dataAniVend))
			return false;
		if (emailVend == null) {
			if (other.emailVend != null)
				return false;
		} else if (!emailVend.equals(other.emailVend))
			return false;
		if (idVend == null) {
			if (other.idVend != null)
				return false;
		} else if (!idVend.equals(other.idVend))
			return false;
		if (nomeVend == null) {
			if (other.nomeVend != null)
				return false;
		} else if (!nomeVend.equals(other.nomeVend))
			return false;
		if (salarioVend == null) {
			if (other.salarioVend != null)
				return false;
		} else if (!salarioVend.equals(other.salarioVend))
			return false;
		return true;
	}
		
}

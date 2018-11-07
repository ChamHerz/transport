package transport.model;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarifa")
public class Tarifa {
	private Integer idTarifa;
	private BigDecimal precioPorPesoKG;
	private BigDecimal precioPorVolumenM3;
	private BigDecimal precioPorDistanciaKM;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idTarifa")
	public Integer getIdTarifa() {
		return idTarifa;
	}
	public void setIdTarifa(Integer idTarifa) {
		this.idTarifa = idTarifa;
	}
	
	@Basic
	@Column(name = "precioPorPesoKG")
	public BigDecimal getPrecioPorPesoKG() {
		return precioPorPesoKG;
	}
	public void setPrecioPorPesoKG(BigDecimal precioPorPesoKG) {
		this.precioPorPesoKG = precioPorPesoKG;
	}
	
	@Basic
	@Column(name = "precioPorVolumenM3")
	public BigDecimal getPrecioPorVolumenM3() {
		return precioPorVolumenM3;
	}
	public void setPrecioPorVolumenM3(BigDecimal precioPorVolumenM3) {
		this.precioPorVolumenM3 = precioPorVolumenM3;
	}
	
	@Basic
	@Column(name = "precioPorDistanciaKM")
	public BigDecimal getPrecioPorDistanciaKM() {
		return precioPorDistanciaKM;
	}
	public void setPrecioPorDistanciaKM(BigDecimal precioPorDistanciaKM) {
		this.precioPorDistanciaKM = precioPorDistanciaKM;
	}
	
	
}

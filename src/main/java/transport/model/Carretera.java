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
@Table(name = "carretera")
public class Carretera {
	private Integer idCarretera;
	private Integer idCiudadOrigen;
	private Integer idCiudadDestino;
	private BigDecimal kilometros;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idCarretera")
	public Integer getIdCarretera() {
		return idCarretera;
	}
	public void setIdCarretera(Integer idCarretera) {
		this.idCarretera = idCarretera;
	}
	
	@Basic
	@Column(name = "idCiudadOrigen")
	public Integer getIdCiudadOrigen() {
		return idCiudadOrigen;
	}
	public void setIdCiudadOrigen(Integer idCiudadOrigen) {
		this.idCiudadOrigen = idCiudadOrigen;
	}
	
	@Basic
	@Column(name = "idCiudadDestino")
	public Integer getIdCiudadDestino() {
		return idCiudadDestino;
	}
	public void setIdCiudadDestino(Integer idCiudadDestino) {
		this.idCiudadDestino = idCiudadDestino;
	}
	
	@Basic
	@Column(name = "kilometros")
	public BigDecimal getKilometros() {
		return kilometros;
	}
	public void setKilometros(BigDecimal kilometros) {
		this.kilometros = kilometros;
	}
	
	

}

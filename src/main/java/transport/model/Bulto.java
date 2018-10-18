package transport.model;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "bulto")
public class Bulto {
	private int idBulto;
	private Integer idCiudadOrigen;
	private Ciudad ciudadOrigen;
	private Integer idCiudadDestino;
	private Ciudad ciudadDestino;
	private BigDecimal pesoKG;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_bulto")
	public int getIdBulto() {
		return idBulto;
	}
	public void setIdBulto(int idBulto) {
		this.idBulto = idBulto;
	}
	
	@Basic
	@Column(name = "id_ciudad_origen")
	public Integer getIdCiudadOrigen() {
		return idCiudadOrigen;
	}
	public void setIdCiudadOrigen(Integer idCiudadOrigen) {
		this.idCiudadOrigen = idCiudadOrigen;
	}
	
	@ManyToOne(targetEntity = Ciudad.class, optional = true)
    @JoinColumn(name = "id_ciudad_origen",referencedColumnName="id_ciudad",
    insertable = false, updatable = false, nullable = true)
	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(Ciudad ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	
	@Basic
	@Column(name = "id_ciudad_destino")
	public Integer getIdCiudadDestino() {
		return idCiudadDestino;
	}
	public void setIdCiudadDestino(Integer idCiudadDestino) {
		this.idCiudadDestino = idCiudadDestino;
	}
	
	@ManyToOne(targetEntity = Ciudad.class, optional = true)
    @JoinColumn(name = "id_ciudad_destino",referencedColumnName="id_ciudad",
    insertable = false, updatable = false, nullable = true)
	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(Ciudad ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	
	@Basic
	@Column(name = "pesoKG")
	public BigDecimal getPesoKG() {
		return pesoKG;
	}
	public void setPesoKG(BigDecimal pesoKG) {
		this.pesoKG = pesoKG;
	}
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idBulto,
				(ciudadOrigen == null) ? "" : ciudadOrigen.getNombre(),
				(ciudadDestino == null) ? "" : ciudadDestino.getNombre(),
				pesoKG
		};
		return item;
	}
}

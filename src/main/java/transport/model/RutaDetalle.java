package transport.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ruta_detalle")
public class RutaDetalle {
	private Integer idRutaDetalle;
	private Integer idRuta;
	private Integer orden;
	private Integer idCiudad;
	private Ciudad ciudad;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idRutaDetalle")
	public Integer getIdRutaDetalle() {
		return idRutaDetalle;
	}
	public void setIdRutaDetalle(Integer idRutaDetalle) {
		this.idRutaDetalle = idRutaDetalle;
	}
	
	@Basic
	@Column(name = "idRuta")
	public Integer getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}
	
	@Basic
	@Column(name = "orden")
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
	@Basic
	@Column(name = "idCiudad")
	public Integer getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}
	
	@ManyToOne(targetEntity = Ciudad.class, optional = true)
    @JoinColumn(name = "idCiudad",referencedColumnName="idCiudad",
    insertable = false, updatable = false, nullable = true)
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				//idRutaDetalle,
				//idRuta,
				orden,
				ciudad.getNombre()
		};
		return item;
	}
}

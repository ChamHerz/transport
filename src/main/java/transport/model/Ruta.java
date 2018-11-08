package transport.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ruta")
public class Ruta {
	private int idRuta;
	private String nombre;
	private List<RutaDetalle> rutaDetalle;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idRuta")
	public int getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}
	
	@Basic
	@Column(name = "descripcion")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@OneToMany(targetEntity = RutaDetalle.class)
    @JoinColumn(name = "idRuta",referencedColumnName="idRuta",
    insertable = false, updatable = false, nullable = true)
	public List<RutaDetalle> getRutaDetalle() {
		return rutaDetalle;
	}
	public void setRutaDetalle(List<RutaDetalle> rutaDetalle) {
		this.rutaDetalle = rutaDetalle;
	}
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idRuta,
				nombre
		};
		return item;
	}
}

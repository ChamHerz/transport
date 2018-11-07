package transport.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ruta")
public class Ruta {
	private int idRuta;
	private String nombre;
	
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
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idRuta,
				nombre
		};
		return item;
	}
}

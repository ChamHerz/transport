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
@Table(name = "ciudad")
public class Ciudad {
	private int idCiudad;
	private String nombre;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idCiudad")
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	
	@Basic
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idCiudad,
				nombre
		};
		return item;
	}
}

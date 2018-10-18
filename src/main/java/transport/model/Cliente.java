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
@Table(name = "cliente")
public class Cliente {
	private int idCliente;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_cliente")
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	@Basic
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Basic
	@Column(name = "apellido")
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Basic
	@Column(name = "direccion")
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Basic
	@Column(name = "telefono")
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idCliente,
				nombre,
				apellido,
				direccion,
				telefono
		};
		return item;
	}
	
	@Transient
	public String getNombreApellido() {
		return nombre + " " + apellido;
	}
}

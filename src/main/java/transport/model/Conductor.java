package transport.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "conductor")
public class Conductor {
	private int idConductor;
	private String nombre;
	private String apellido;
	private String dni;
	private String direccion;
	private String provincia;
	private String telefono;
	private Integer idCamion;
	private Camion camion;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_conductor")
	public int getIdConductor() {
		return idConductor;
	}
	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
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
	@Column(name = "dni")
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	@Column(name = "provincia")
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Basic
	@Column(name = "telefono")
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Basic
	@Column(name = "id_camion", nullable = true)
	public Integer getIdCamion() {
		return idCamion;
	}
	public void setIdCamion(Integer idCamion) {
		this.idCamion = idCamion;
	}
	
	@ManyToOne(targetEntity = Camion.class, optional = true)
    @JoinColumn(name = "id_camion",referencedColumnName="id_camion",
    insertable = false, updatable = false, nullable = true)
	public Camion getCamion() {
		return camion;
	}
	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idConductor,
				nombre,
				apellido,
				dni,
				direccion,
				provincia,
				telefono,
				(camion == null) ? "" : camion.getMatricula()
		};
		return item;
	}

}

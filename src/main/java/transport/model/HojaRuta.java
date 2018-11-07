package transport.model;

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
@Table(name = "hoja_ruta")
public class HojaRuta {
	private Integer idHojaRuta;
	private Integer idRuta;
	private Ruta ruta;
	private Integer idConductor;
	private Conductor conductor;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idHojaRuta")
	public Integer getIdHojaRuta() {
		return idHojaRuta;
	}
	public void setIdHojaRuta(Integer idHojaRuta) {
		this.idHojaRuta = idHojaRuta;
	}
	
	@Basic
	@Column(name = "idRuta")
	public Integer getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}
	
	@ManyToOne(targetEntity = Ruta.class, optional = true)
    @JoinColumn(name = "idRuta",referencedColumnName="idRuta",
    insertable = false, updatable = false, nullable = true)
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	
	@Basic
	@Column(name = "idConductor")
	public Integer getIdConductor() {
		return idConductor;
	}
	public void setIdConductor(Integer idConductor) {
		this.idConductor = idConductor;
	}
	
	@ManyToOne(targetEntity = Conductor.class, optional = true)
    @JoinColumn(name = "idConductor",referencedColumnName="idConductor",
    insertable = false, updatable = false, nullable = true)
	public Conductor getConductor() {
		return conductor;
	}
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idHojaRuta,
				ruta.getNombre(),
				conductor.getNombre()
		};
		return item;
	}
}

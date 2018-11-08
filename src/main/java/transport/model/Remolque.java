package transport.model;

import java.math.BigDecimal;
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
@Table(name = "remolque")
public class Remolque {
	private int idRemolque;
	private Integer idCamion;
	private BigDecimal pesoMaximo;
	private BigDecimal pesoActual;
	private BigDecimal volumenMaximo;
	private BigDecimal volumenActual;
	private Integer cantidadBultos;
	private List<Bulto> bultos;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idRemolque")
	public int getIdRemolque() {
		return idRemolque;
	}
	public void setIdRemolque(int idRemolque) {
		this.idRemolque = idRemolque;
	}
	
	@Basic
	@Column(name = "idCamion")
	public Integer getIdCamion() {
		return idCamion;
	}
	public void setIdCamion(Integer idCamion) {
		this.idCamion = idCamion;
	}
	
	@Basic
	@Column(name = "pesoMaximo")
	public BigDecimal getPesoMaximo() {
		return pesoMaximo;
	}
	public void setPesoMaximo(BigDecimal pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}
	
	@Basic
	@Column(name = "pesoActual")	
	public BigDecimal getPesoActual() {
		return pesoActual;
	}
	public void setPesoActual(BigDecimal pesoActual) {
		this.pesoActual = pesoActual;
	}
	
	@Basic
	@Column(name = "volumenMaximo")
	public BigDecimal getVolumenMaximo() {
		return volumenMaximo;
	}
	public void setVolumenMaximo(BigDecimal volumenMaximo) {
		this.volumenMaximo = volumenMaximo;
	}
	
	@Basic
	@Column(name = "volumenActual")
	public BigDecimal getVolumenActual() {
		return volumenActual;
	}
	public void setVolumenActual(BigDecimal volumenActual) {
		this.volumenActual = volumenActual;
	}
	
	@Basic
	@Column(name = "cantidadBultos")
	public Integer getCantidadBultos() {
		return cantidadBultos;
	}
	public void setCantidadBultos(Integer cantidadBultos) {
		this.cantidadBultos = cantidadBultos;
	}
	
	@OneToMany(targetEntity = Bulto.class)
    @JoinColumn(name = "idRemolque",referencedColumnName="idRemolque",
    insertable = false, updatable = false, nullable = true)
	public List<Bulto> getBultos() {
		return bultos;
	}
	public void setBultos(List<Bulto> bultos) {
		this.bultos = bultos;
	}
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idRemolque,
				idCamion,
				pesoMaximo,
				pesoActual,
				volumenMaximo,
				volumenActual,
				cantidadBultos
		};
		return item;
	}
}

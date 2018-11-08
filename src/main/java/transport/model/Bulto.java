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
	private Integer idPedido;
	private Integer idCiudadOrigen;
	private Ciudad ciudadOrigen;
	private Integer idCiudadDestino;
	private Ciudad ciudadDestino;
	private Integer idRemolque;
	private BigDecimal pesoKG;
	private BigDecimal volumenM3;
	private BigDecimal distanciaKM;
	private BigDecimal costo;
	private Integer idEstado;
	private Estado estado;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idBulto")
	public int getIdBulto() {
		return idBulto;
	}
	public void setIdBulto(int idBulto) {
		this.idBulto = idBulto;
	}
	
	@Basic
	@Column(name = "idPedido")
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	
	@Basic
	@Column(name = "idCiudadOrigen")
	public Integer getIdCiudadOrigen() {
		return idCiudadOrigen;
	}
	public void setIdCiudadOrigen(Integer idCiudadOrigen) {
		this.idCiudadOrigen = idCiudadOrigen;
	}
	
	@ManyToOne(targetEntity = Ciudad.class, optional = true)
    @JoinColumn(name = "idCiudadOrigen",referencedColumnName="idCiudad",
    insertable = false, updatable = false, nullable = true)
	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(Ciudad ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	
	@Basic
	@Column(name = "idCiudadDestino")
	public Integer getIdCiudadDestino() {
		return idCiudadDestino;
	}
	public void setIdCiudadDestino(Integer idCiudadDestino) {
		this.idCiudadDestino = idCiudadDestino;
	}
	
	@ManyToOne(targetEntity = Ciudad.class, optional = true)
    @JoinColumn(name = "idCiudadDestino",referencedColumnName="idCiudad",
    insertable = false, updatable = false, nullable = true)
	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(Ciudad ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	
	@Basic
	@Column(name = "idRemolque")
	public Integer getIdRemolque() {
		return idRemolque;
	}
	public void setIdRemolque(Integer idRemolque) {
		this.idRemolque = idRemolque;
	}
	
	@Basic
	@Column(name = "pesoKG")
	public BigDecimal getPesoKG() {
		return pesoKG;
	}
	public void setPesoKG(BigDecimal pesoKG) {
		this.pesoKG = pesoKG;
	}
	
	@Basic
	@Column(name = "volumenM3")
	public BigDecimal getVolumenM3() {
		return volumenM3;
	}
	public void setVolumenM3(BigDecimal volumenM3) {
		this.volumenM3 = volumenM3;
	}
	
	@Basic
	@Column(name = "distanciaKM")
	public BigDecimal getDistanciaKM() {
		return distanciaKM;
	}
	public void setDistanciaKM(BigDecimal distanciaKM) {
		this.distanciaKM = distanciaKM;
	}
	
	@Basic
	@Column(name = "costo")
	public BigDecimal getCosto() {
		return costo;
	}
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	
	@Basic
	@Column(name = "idEstado")
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	
	@ManyToOne(targetEntity = Estado.class, optional = true)
    @JoinColumn(name = "idEstado",referencedColumnName="idEstado",
    insertable = false, updatable = false, nullable = true)
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idBulto,
				(ciudadOrigen == null) ? "" : ciudadOrigen.getNombre(),
				(ciudadDestino == null) ? "" : ciudadDestino.getNombre(),
				estado.getEstado(),
				idRemolque,
				pesoKG,
				volumenM3,
				distanciaKM,
				costo
		};
		return item;
	}
}

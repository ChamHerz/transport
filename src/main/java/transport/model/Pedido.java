package transport.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@Table(name = "pedido")
public class Pedido {
	private static final SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss");
	
	private Integer idPedido;
	private Integer idCliente;
	private Cliente cliente;
	private Date fechaPedido;
	private BigDecimal costoPedido;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idPedido")
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	
	@Basic
	@Column(name = "idCliente")
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	@ManyToOne(targetEntity = Cliente.class, optional = true)
    @JoinColumn(name = "idCliente",referencedColumnName="idCliente",
    insertable = false, updatable = false, nullable = true)
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
		
	@Basic
	@Column(name = "fechaPedido")
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	@Basic
	@Column(name = "costoPedido")
	public BigDecimal getCostoPedido() {
		return costoPedido;
	}
	public void setCostoPedido(BigDecimal costoPedido) {
		this.costoPedido = costoPedido;
	}
	
	@Transient
	public String getFechaLatino() {
		return formatoFecha.format(this.fechaPedido);
	}
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idPedido,
				(cliente == null) ? "" : cliente.getNombreApellido(),
				fechaPedido,
				costoPedido
		};
		return item;
	}

}

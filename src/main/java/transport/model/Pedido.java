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
@Table(name = "pedido")
public class Pedido {
	private int idPedido;
	private Integer idCliente;
	private Cliente cliente;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_pedido")
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	@Basic
	@Column(name = "id_cliente")
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	@ManyToOne(targetEntity = Cliente.class, optional = true)
    @JoinColumn(name = "id_cliente",referencedColumnName="id_cliente",
    insertable = false, updatable = false, nullable = true)
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idPedido,
				(cliente == null) ? "" : cliente.getNombreApellido()
		};
		return item;
	}

}

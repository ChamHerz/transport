package transport.model;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "remolque")
public class Remolque {
	private int idRemolque;
	private BigDecimal pesoMaximo;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_remolque")
	public int getIdRemolque() {
		return idRemolque;
	}
	public void setIdRemolque(int idRemolque) {
		this.idRemolque = idRemolque;
	}
	
	@Basic
	@Column(name = "pesoMaximo")
	public BigDecimal getPesoMaximo() {
		return pesoMaximo;
	}
	public void setPesoMaximo(BigDecimal pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idRemolque,
				pesoMaximo
		};
		return item;
	}
}

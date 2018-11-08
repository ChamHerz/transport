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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "camion")
public class Camion {
	private int idCamion;
	private String matricula;
	private BigDecimal pesoMaximo;
	private BigDecimal pesoActual;
	private BigDecimal kmPorHoraMedio;
	private List<Remolque> remolques;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idCamion")
	public int getIdCamion() {
		return idCamion;
	}
	public void setIdCamion(int idCamion) {
		this.idCamion = idCamion;
	}
	
	@Basic
	@Column(name = "matricula")
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
	@Column(name = "kmPorHoraMedio")
	public BigDecimal getKmPorHoraMedio() {
		return kmPorHoraMedio;
	}
	public void setKmPorHoraMedio(BigDecimal kmPorHoraMedio) {
		this.kmPorHoraMedio = kmPorHoraMedio;
	}
	
	@OneToMany(targetEntity = Remolque.class)
    @JoinColumn(name = "idCamion",referencedColumnName="idCamion",
    insertable = false, updatable = false, nullable = true)
	public List<Remolque> getRemolques() {
		return remolques;
	}
	public void setRemolques(List<Remolque> remolques) {
		this.remolques = remolques;
	}
	
	@Transient
	public Object[] getObject() {
		Object[] item = {
				idCamion,
				matricula,
				pesoMaximo,
				pesoActual,
				kmPorHoraMedio
		};
		return item;
	}
}

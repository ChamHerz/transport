package transport.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import transport.main.HibernateUtil;
import transport.model.Carretera;
import transport.model.Ciudad;

public class CarreteraDAO {
	
	public Carretera get(int idCarretera) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Carretera carretea = (Carretera) session.get(Carretera.class, idCarretera);
		session.getTransaction().commit();
		return carretea;
	}
	
	public BigDecimal getDistancia(Ciudad origen, Ciudad destino) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Carretera.class);
		criteria.add(Restrictions.eq("idCiudadOrigen",origen.getIdCiudad()))
				.add(Restrictions.eq("idCiudadDestino",destino.getIdCiudad()));
		Carretera carretera = (Carretera) criteria.uniqueResult();
		session.getTransaction().commit();
		return carretera.getKilometros();
		
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Ciudad> getCiudades() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		Criteria criteria = session.createCriteria(Ciudad.class);
//		List<Ciudad> ciudades = null;
//		try {
//			ciudades = (List<Ciudad>)criteria.list();
//		} catch (Exception e) {
//			
//		} finally {
//			session.getTransaction().commit();
//		}
//		return ciudades;
//	}

}

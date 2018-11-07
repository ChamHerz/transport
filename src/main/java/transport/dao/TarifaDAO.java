package transport.dao;

import java.math.BigDecimal;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import transport.main.HibernateUtil;
import transport.model.Carretera;
import transport.model.Ciudad;
import transport.model.Tarifa;

public class TarifaDAO {
	
	public Tarifa get(int idTarifa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Tarifa tarifa = (Tarifa) session.get(Tarifa.class, idTarifa);
		session.getTransaction().commit();
		return tarifa;
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

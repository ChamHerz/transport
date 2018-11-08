package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.Camion;
import transport.model.RutaDetalle;

public class RutaDetalleDAO {
	
	@SuppressWarnings("unchecked")
	public List<RutaDetalle> getRutaDetalles() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(RutaDetalle.class);
		List<RutaDetalle> rutaDetalles = null;
		try {
			rutaDetalles = (List<RutaDetalle>)criteria.list();
		} catch (Exception e) {
			
		} finally {
			session.getTransaction().commit();
		}
		return rutaDetalles;
	}
}

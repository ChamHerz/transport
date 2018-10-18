package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.Camion;

public class CamionDAO {
	
	@SuppressWarnings("unchecked")
	public List<Camion> getCamiones() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Camion.class);
		List<Camion> camiones = null;
		try {
			camiones = (List<Camion>)criteria.list();
		} catch (Exception e) {
			
		} finally {
			session.getTransaction().commit();
		}
		return camiones;
	}
	
	public Camion getCamion(int idCamion) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Camion camion = (Camion)session.get(Camion.class, idCamion);
		session.getTransaction().commit();
		return camion;
	}
}

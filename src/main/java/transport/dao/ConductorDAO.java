package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.Conductor;

public class ConductorDAO {
	
	@SuppressWarnings("unchecked")
	public List<Conductor> getConductores() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Conductor.class);
		List<Conductor> conductores = null;
		try {
			conductores = (List<Conductor>)criteria.list();
		} catch (Exception e) {
			
		} finally {
			session.getTransaction().commit();
		}
		return conductores;
	}
	
	public Conductor getConductor(int idConductor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Conductor conductor = (Conductor)session.get(Conductor.class, idConductor);
		session.getTransaction().commit();
		return conductor;
	}

}

package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.Remolque;

public class RemolqueDAO {
	
	public void updateCantidadesRemolque(Remolque remolque) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Remolque remolqueDos = (Remolque) session.get(Remolque.class, remolque.getIdRemolque());
		remolqueDos.setPesoActual(remolque.getPesoActual());
		remolqueDos.setVolumenActual(remolque.getVolumenActual());
		remolqueDos.setCantidadBultos(remolque.getCantidadBultos());
		session.update(remolqueDos);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Remolque> getRemolques() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Remolque.class);
		List<Remolque> remolques = null;
		try {
			remolques = (List<Remolque>)criteria.list();
		} catch (Exception e) {
			
		} finally {
			session.getTransaction().commit();
		}
		return remolques;
	}

}

package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.Remolque;

public class RemolqueDAO {
	
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

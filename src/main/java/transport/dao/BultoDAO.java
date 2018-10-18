package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.Bulto;

public class BultoDAO {
	
	@SuppressWarnings("unchecked")
	public List<Bulto> getBultos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Bulto.class);
		List<Bulto> bultos = null;
		try {
			bultos = (List<Bulto>)criteria.list();
		} catch (Exception e) {
			
		} finally {
			session.getTransaction().commit();
		}
		return bultos;
	}

}

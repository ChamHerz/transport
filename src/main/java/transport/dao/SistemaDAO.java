package transport.dao;

import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.Sistema;

public class SistemaDAO {
	
	public Sistema getSistema() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Sistema sistema = (Sistema)session.get(Sistema.class, 1);
		session.getTransaction().commit();
		return sistema;
	}

}

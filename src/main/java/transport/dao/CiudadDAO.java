package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.Ciudad;

public class CiudadDAO {
	
	public Ciudad get(int idCiudad) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Ciudad ciudad = (Ciudad) session.get(Ciudad.class, idCiudad);
		session.getTransaction().commit();
		return ciudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> getCiudades() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Ciudad.class);
		List<Ciudad> ciudades = null;
		try {
			ciudades = (List<Ciudad>)criteria.list();
		} catch (Exception e) {
			
		} finally {
			session.getTransaction().commit();
		}
		return ciudades;
	}

}

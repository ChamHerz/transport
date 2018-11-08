package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.Ruta;

public class RutaDAO {
	
	public Ruta getRuta(int idRuta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Ruta ruta = (Ruta) session.get(Ruta.class, idRuta);
		session.getTransaction().commit();
		return ruta;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ruta> getRutas() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Ruta.class);
		List<Ruta> rutas = null;
		try {
			rutas = (List<Ruta>)criteria.list();
		} catch (Exception e) {
			
		} finally {
			session.getTransaction().commit();
		}
		return rutas;
	}

}

package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import transport.main.HibernateUtil;
import transport.model.Bulto;

public class BultoDAO {
	
	public void addBulto(Bulto bulto) {
		bulto.setIdEstado(1);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bulto);
		session.getTransaction().commit();
	}
	
	public Bulto get(int idBulto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Bulto bulto = (Bulto) session.get(Bulto.class, idBulto);
		session.getTransaction().commit();
		return bulto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bulto> getBultos(int idPedido) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Bulto.class);
		criteria.add(Restrictions.eq("idPedido", idPedido));
		List<Bulto> bultos = null;
		try {
			bultos = (List<Bulto>)criteria.list();
		} catch (Exception e) {
			
		} finally {
			session.getTransaction().commit();
		}
		return bultos;
	}
	
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
	
	@SuppressWarnings("unchecked")
	public List<Bulto> getBultosSinRemolques() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Bulto.class);
		criteria.add(Restrictions.eq("idEstado",1));
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

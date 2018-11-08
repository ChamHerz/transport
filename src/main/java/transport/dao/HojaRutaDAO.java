package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.HojaRuta;
import transport.model.Pedido;

public class HojaRutaDAO {
	
	public HojaRuta agregar(HojaRuta hojaRuta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(hojaRuta);
		session.getTransaction().commit();
		return hojaRuta;
	}
	
	public HojaRuta get(int idHojaRuta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		HojaRuta hojaRuta = (HojaRuta) session.get(HojaRuta.class, idHojaRuta);
		session.getTransaction().commit();
		return hojaRuta;
	}
	
	@SuppressWarnings("unchecked")
	public List<HojaRuta> getHojaRutas() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(HojaRuta.class);
		List<HojaRuta> hojaRutas = null;
		try {
			hojaRutas = (List<HojaRuta>)criteria.list();
		} catch (Exception e) {
			
		} finally {
			session.getTransaction().commit();
		}
		return hojaRutas;
	}
}

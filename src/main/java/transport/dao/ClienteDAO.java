package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.Cliente;

public class ClienteDAO {
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Cliente.class);
		List<Cliente> clientes = null;
		try {
			clientes = (List<Cliente>)criteria.list();
		} catch (Exception e) {
			
		} finally {
			session.getTransaction().commit();
		}
		return clientes;
	}

}

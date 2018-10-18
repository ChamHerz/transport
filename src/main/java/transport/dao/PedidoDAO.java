package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.Pedido;

public class PedidoDAO {
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getPedidos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Pedido.class);
		List<Pedido> pedidos = null;
		try {
			pedidos = (List<Pedido>)criteria.list();
		} catch (Exception e) {
			
		} finally {
			session.getTransaction().commit();
		}
		return pedidos;
	}

}

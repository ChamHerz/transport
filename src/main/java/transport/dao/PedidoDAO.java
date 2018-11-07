package transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import transport.main.HibernateUtil;
import transport.model.Pedido;

public class PedidoDAO {
	
	public Integer addPedido(Pedido pedido) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(pedido);
		session.getTransaction().commit();
		return pedido.getIdPedido();
	}
	
	public Pedido getPedido(int idPedido) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Pedido pedido = (Pedido) session.get(Pedido.class, idPedido);
		session.getTransaction().commit();
		return pedido;
	}
	
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

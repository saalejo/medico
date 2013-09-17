package agenda.db.dao.implementacion;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import agenda.db.dao.interfaz.EventoDao;
import agenda.db.dto.modelo.Evento;








public class EventoDaoImpl extends HibernateDaoSupport implements EventoDao{

	@Override
	public void guardar(Evento evento) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(evento);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando el evento", e);
		}
		
	}

	@Override
	public List<Evento> obtener() {
		
		Session sesion = null;
		sesion = getSession();		
		List<Evento> eventos = sesion.createCriteria(Evento.class)
				.list();		
		return eventos;
	}

	@Override
	public Evento obtener(int id) {
		
		Session sesion = null;
		sesion = getSession();		
		Evento evento = (Evento)sesion.createCriteria(Evento.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return evento;
		
	}

	@Override
	public void borrar(Evento evento) {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(evento);
			tx.commit();	
		}catch(HibernateException e){
			
		}
		
	}

	@Override
	public void actualizar(Evento evento) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(evento);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando el evento", e);
		}
		
	}
	
	
	

}

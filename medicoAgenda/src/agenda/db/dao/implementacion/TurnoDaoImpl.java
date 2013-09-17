package agenda.db.dao.implementacion;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import agenda.db.dao.interfaz.TurnoDao;
import agenda.db.dto.modelo.Festivo;
import agenda.db.dto.modelo.Turno;


public class TurnoDaoImpl extends HibernateDaoSupport implements TurnoDao{
	
	
	@Override
	public void guardar(Turno turno) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(turno);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando el turno", e);
		}		
	}

	@Override
	public List<Turno> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Turno> turnos = sesion.createCriteria(Turno.class)
				.list();		
		return turnos;
	}

	@Override
	public Turno obtener(int id) {
		Session sesion = null;
		sesion = getSession();		
		Turno turno = (Turno)sesion.createCriteria(Turno.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return turno;
	}

	@Override
	public void borrar(Turno turno) {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(turno);
			tx.commit();	
		}catch(HibernateException e){
			
		}
		
	}

	@Override
	public void actualizar(Turno turno) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(turno);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando el Turno", e);
		}
		
	}

}

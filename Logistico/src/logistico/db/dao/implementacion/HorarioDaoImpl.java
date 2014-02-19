package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.HorarioDao;
import logistico.db.dto.modelo.Barrio;
import logistico.db.dto.modelo.Horario;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz HorarioDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class HorarioDaoImpl extends HibernateDaoSupport  implements HorarioDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Horario> obtener() throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Horario> horarios = sesion.createCriteria(Horario.class)
					.list();		
			return horarios;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de horarios", e);
		}
	}

	@Override
	public void actualizar(Horario horario) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(horario);
			tx.commit();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando el horario", e);
		}	
	}
	
	@Override
	public void guardar(Horario horario) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(horario);
			tx.commit();
			sesion.close();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando el horario", e);
		}	
	}

	@Override
	public void borrar(Horario horario) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(horario);
			tx.commit();
			sesion.close();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando el horario", e);
		}	
		
	}
}

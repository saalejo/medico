package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.ConsultorioDao;
import logistico.db.dto.modelo.Consultorio;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz ConsultorioDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class ConsultorioDaoImpl extends HibernateDaoSupport  implements ConsultorioDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Consultorio> obtener() throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Consultorio> consultorios = sesion.createCriteria(Consultorio.class)
					.list();		
			return consultorios;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista los consultorio", e);
		}
	}

	@Override
	public void actualizar(Consultorio consultorio) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(consultorio);
			tx.commit();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando la configuracion", e);
		}	
	}
	
	@Override
	public void guardar(Consultorio consultorio) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(consultorio);
			tx.commit();
			sesion.close();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando la configuracion", e);
		}	
	}

	@Override
	public void borrar(Consultorio consultorio) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(consultorio);
			tx.commit();
			sesion.close();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando la configuracion", e);
		}	
		
	}
}

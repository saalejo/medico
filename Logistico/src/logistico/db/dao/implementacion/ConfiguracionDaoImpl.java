package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.ConfiguracionDao;
import logistico.db.dto.modelo.Barrio;
import logistico.db.dto.modelo.Configuracion;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz ConfiguracionDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class ConfiguracionDaoImpl extends HibernateDaoSupport  implements ConfiguracionDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Configuracion> obtenerPorModuloSistema(int moduloSistemaId) throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Configuracion> configuraciones = sesion.createCriteria(Barrio.class)
					.add(Restrictions.eq("moduloSistemaId", moduloSistemaId))
					.list();		
			return configuraciones;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de configuraciones por modulo sistema", e);
		}	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Configuracion> obtenerPorEspecialidad(int especialidadId) throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Configuracion> configuraciones = sesion.createCriteria(Configuracion.class)
					.list();		
			return configuraciones;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista los confituracoines por especialidad", e);
		}
	}

	@Override
	public void actualizar(Configuracion configuracion) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(configuracion);
			tx.commit();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando la configuracion", e);
		}	
	}
	
	@Override
	public void guardar(Configuracion configuracion) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(configuracion);
			tx.commit();
			sesion.close();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando la configuracion", e);
		}	
	}

	@Override
	public void borrar(Configuracion configuracion) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(configuracion);
			tx.commit();
			sesion.close();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando la configuracion", e);
		}	
		
	}
}

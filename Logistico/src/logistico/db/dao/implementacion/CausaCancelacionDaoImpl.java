package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.CausaCancelacionDao;
import logistico.db.dto.modelo.CausaCancelacion;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz CausaCancelacionDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class CausaCancelacionDaoImpl extends HibernateDaoSupport  implements CausaCancelacionDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CausaCancelacion> obtener(int moduloSistemaId) throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<CausaCancelacion> causaCancelaciones = sesion.createCriteria(CausaCancelacion.class)
					.add(Restrictions.eq("moduloSistemaId", moduloSistemaId))
					.list();		
			return causaCancelaciones;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de causas de cancelaciones por modulo", e);
		}	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CausaCancelacion> obtener() throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<CausaCancelacion> causaCancelaciones = sesion.createCriteria(CausaCancelacion.class)
					.list();		
			return causaCancelaciones;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de todas las causas de cancelaciones", e);
		}
	}

	@Override
	public void actualizar(CausaCancelacion causaCancelacion) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(causaCancelacion);
			tx.commit();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando la causa cancelacion", e);
		}	
	}
	
	@Override
	public void guardar(CausaCancelacion causaCancelacion) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(causaCancelacion);
			tx.commit();
			sesion.close();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando  la causa cancelacion", e);
		}	
	}

	@Override
	public void borrar(CausaCancelacion causaCancelacion) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(causaCancelacion);
			tx.commit();
			sesion.close();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando la causa cancelacion", e);
		}	
		
	}
}

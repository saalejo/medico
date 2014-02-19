package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.ModuloSistemaDao;
import logistico.db.dto.modelo.ModuloSistema;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz ModuloSistemaDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class ModuloSistemaDaoImpl extends HibernateDaoSupport  implements ModuloSistemaDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ModuloSistema> obtener() throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<ModuloSistema> moduloSistemas = sesion.createCriteria(ModuloSistema.class)
					.list();		
			return moduloSistemas;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de modulo sistema", e);
		}
	}

	@Override
	public void actualizar(ModuloSistema moduloSistema) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(moduloSistema);
			tx.commit();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando el modulo sistema", e);
		}	
	}
	
	@Override
	public void guardar(ModuloSistema moduloSistema) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(moduloSistema);
			tx.commit();
			sesion.close();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando el modulo sistema", e);
		}	
	}

	@Override
	public void borrar(ModuloSistema moduloSistema) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(moduloSistema);
			tx.commit();
			sesion.close();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando el modulo sistema", e);
		}	
		
	}
}

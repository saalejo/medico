package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.ProtocoloDao;
import logistico.db.dto.modelo.Protocolo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz ProfesionalDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class ProtocoloDaoImpl extends HibernateDaoSupport  implements ProtocoloDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Protocolo> obtener() throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Protocolo> protocolos = sesion.createCriteria(Protocolo.class)
					.list();		
			return protocolos;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de Protocolos", e);
		}
	}

	@Override
	public void actualizar(Protocolo protocolo) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(protocolo);
			tx.commit();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando el Protocolo", e);
		}	
	}
	
	@Override
	public void guardar(Protocolo protocolo) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(protocolo);
			tx.commit();
			sesion.close();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando el Protocolo", e);
		}	
	}

	@Override
	public void borrar(Protocolo protocolo) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(protocolo);
			tx.commit();
			sesion.close();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando el Protocolo", e);
		}	
		
	}
}

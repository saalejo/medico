package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.MunicipioDao;
import logistico.db.dto.modelo.Municipio;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz MunicipioDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class MunicipioDaoImpl extends HibernateDaoSupport  implements MunicipioDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Municipio> obtener(int departamentoId) throws Exception{
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Municipio> municipios = sesion.createCriteria(Municipio.class)
					.add(Restrictions.eq("departamentoId", departamentoId))
					.list();		
			return municipios;
		}catch(HibernateException e){
			throw new Exception(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Municipio> obtener() throws Exception{
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Municipio> municipios = sesion.createCriteria(Municipio.class)
					.list();		
			return municipios;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de municipios", e);
		}
	}
	
	@Override
	public void actualizar(Municipio municipio)  throws Exception{
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(municipio);		
			tx.commit();		
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando el municipio", e);
		}
	}

	@Override
	public void guardar(Municipio municipio) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(municipio);		
			tx.commit();		
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando el municipio", e);
		}	
	}

	@Override
	public void borrar(Municipio municipio) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();			
			sesion.delete(municipio);			
			tx.commit();			
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando el municipio", e);
		}	
	}
}

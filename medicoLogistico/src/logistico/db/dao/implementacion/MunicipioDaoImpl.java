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
	public List<Municipio> obtener(int departamentoId) {
		Session sesion = null;
		sesion = getSession();		
		List<Municipio> municipios = sesion.createCriteria(Municipio.class)
				.add(Restrictions.eq("departamentoId", departamentoId))
				.list();		
		return municipios;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Municipio> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Municipio> municipios = sesion.createCriteria(Municipio.class)
				.list();		
		return municipios;
	}
	
	@Override
	public void actualizar(Municipio municipio)  throws Exception{
			
	}

	@Override
	public void guardar(Municipio municipio) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(municipio);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Municipio municipio) throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(municipio);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}
}

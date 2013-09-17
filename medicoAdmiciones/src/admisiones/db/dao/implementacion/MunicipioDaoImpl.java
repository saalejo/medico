package admisiones.db.dao.implementacion;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import admisiones.db.dao.interfaz.MunicipioDao;
import admisiones.db.dto.modelo.Municipio;


public class MunicipioDaoImpl extends HibernateDaoSupport implements MunicipioDao {

	
	
	@Override
	public List<Municipio> obtener() throws Exception {
		Session sesion = null;
		
		try{
			List<Municipio> municipios = new ArrayList<Municipio>();
			sesion = getSession();
			municipios = sesion.createCriteria(Municipio.class)
					.list();			
			return municipios;
		}catch(HibernateException e){
			throw new Exception(e);
		}
		
	}

	@Override
	public Municipio obtener(int id) {
		Session sesion = null;
		sesion = getSession();		
		Municipio municipio = (Municipio)sesion.createCriteria(Municipio.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return municipio;
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
	public void borrar(Municipio municipio) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(municipio);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}

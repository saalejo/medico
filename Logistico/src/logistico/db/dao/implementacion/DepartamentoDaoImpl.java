package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.DepartamentoDao;
import logistico.db.dto.modelo.Departamento;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz DepartamentoDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class DepartamentoDaoImpl extends HibernateDaoSupport  implements DepartamentoDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> obtener() throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Departamento> departamentos = sesion.createCriteria(Departamento.class)
					.list();		
			return departamentos;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de departamentos", e);
		}	
	}
	
	@Override
	public void actualizar(Departamento departamento) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();	
			sesion.update(departamento);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando el departamento", e);
		}
	}

	@Override
	public void guardar(Departamento departamento) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();	
			sesion.save(departamento);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando el departamento", e);
		}	
	}

	@Override
	public void borrar(Departamento departamento) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(departamento);		
			tx.commit();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando el departamento", e);
		}		
	}
}

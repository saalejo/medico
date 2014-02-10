package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.ProfesionalEspecialidadDao;
import logistico.db.dto.modelo.ProfesionalEspecialidad;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz ProfesionalDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class ProfesionalEspecialidadDaoImpl extends HibernateDaoSupport  implements ProfesionalEspecialidadDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProfesionalEspecialidad> obtenerPorProfesional(int profesionalId) throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<ProfesionalEspecialidad> profesionalEspecialidades = sesion.createCriteria(ProfesionalEspecialidad.class)
					.list();		
			return profesionalEspecialidades;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de Profesional Especialidad por profesional", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfesionalEspecialidad> obtenerPorEspecialidad(int especialidadId) throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<ProfesionalEspecialidad> profesionalEspecialidades = sesion.createCriteria(ProfesionalEspecialidad.class)
					.list();		
			return profesionalEspecialidades;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de Profesional Especialidad por especialidad", e);
		}
	}
	
	@Override
	public void actualizar(ProfesionalEspecialidad profesionalEspecialidad) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(profesionalEspecialidad);
			tx.commit();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando el Profesional Especialidad", e);
		}	
	}
	
	@Override
	public void guardar(ProfesionalEspecialidad profesionalEspecialidad) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(profesionalEspecialidad);
			tx.commit();
			sesion.close();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando el Profesional Especialidad", e);
		}	
	}

	@Override
	public void borrar(ProfesionalEspecialidad profesionalEspecialidad) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(profesionalEspecialidad);
			tx.commit();
			sesion.close();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando el Profesional Especialidad", e);
		}	
		
	}
}

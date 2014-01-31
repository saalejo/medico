package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.DepartamentoDao;
import logistico.db.dto.modelo.Departamento;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class DepartamentoDaoImpl extends HibernateDaoSupport  implements DepartamentoDao{

	
	@Override
	public List<Departamento> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Departamento> departamentos = sesion.createCriteria(Departamento.class)
				.list();		
		return departamentos;
	}

	@Override
	public void guardar(Departamento departamento) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(departamento);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Departamento departamento) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(departamento);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}

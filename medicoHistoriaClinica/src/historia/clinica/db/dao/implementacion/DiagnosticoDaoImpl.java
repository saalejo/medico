package historia.clinica.db.dao.implementacion;


import historia.clinica.db.dao.interfaz.DiagnosticoDao;
import historia.clinica.db.dto.modelo.Diagnostico;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DiagnosticoDaoImpl extends HibernateDaoSupport  implements DiagnosticoDao{

	@Override
	public Diagnostico obtener(int id) {
		Session sesion = null;
		sesion = getSession();		
		Diagnostico diagnostico = (Diagnostico)sesion.createCriteria(Diagnostico.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return diagnostico;
	}
	
	@Override
	public List<Diagnostico> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Diagnostico> diagnosticoes = sesion.createCriteria(Diagnostico.class)
				.list();		
		return diagnosticoes;
	}

	@Override
	public void guardar(Diagnostico diagnostico) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(diagnostico);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}
	@Override
	public void actualizar(Diagnostico diagnostico) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.update(diagnostico);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Diagnostico diagnostico) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(diagnostico);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}
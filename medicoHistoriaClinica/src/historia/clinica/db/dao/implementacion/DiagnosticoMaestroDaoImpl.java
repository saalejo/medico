package historia.clinica.db.dao.implementacion;


import historia.clinica.db.dao.interfaz.DiagnosticoMaestroDao;
import historia.clinica.db.dto.modelo.DiagnosticoMaestro;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DiagnosticoMaestroDaoImpl extends HibernateDaoSupport  implements DiagnosticoMaestroDao{

	@Override
	public DiagnosticoMaestro obtener(int id) {
		Session sesion = null;
		sesion = getSession();		
		DiagnosticoMaestro diagnosticoMaestro = (DiagnosticoMaestro)sesion.createCriteria(DiagnosticoMaestro.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return diagnosticoMaestro;
	}
	
	@Override
	public List<DiagnosticoMaestro> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<DiagnosticoMaestro> diagnosticoMaestroes = sesion.createCriteria(DiagnosticoMaestro.class)
				.list();		
		return diagnosticoMaestroes;
	}

	@Override
	public void guardar(DiagnosticoMaestro diagnosticoMaestro) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(diagnosticoMaestro);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}
	@Override
	public void actualizar(DiagnosticoMaestro diagnosticoMaestro) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.update(diagnosticoMaestro);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(DiagnosticoMaestro diagnosticoMaestro) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(diagnosticoMaestro);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}
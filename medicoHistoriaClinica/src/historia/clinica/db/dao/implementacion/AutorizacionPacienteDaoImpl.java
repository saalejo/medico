package historia.clinica.db.dao.implementacion;

import historia.clinica.db.dao.interfaz.AutorizacionPacienteDao;
import historia.clinica.db.dto.modelo.AutorizacionPaciente;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class AutorizacionPacienteDaoImpl extends HibernateDaoSupport implements AutorizacionPacienteDao{
	
	
	@Override
	public AutorizacionPaciente guardar(AutorizacionPaciente autorizacionPaciente) {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(autorizacionPaciente);
			sesion.flush();
			tx.commit();
			sesion.close();
			return autorizacionPaciente;
		}catch(HibernateException e){
			e.printStackTrace();
			return null;
		}		
	}
	
	@Override
	public void actualizar(AutorizacionPaciente autorizacionPaciente) throws Exception {
		Session sesion = null;
		try{
			
			sesion = getSession();
			sesion.update(autorizacionPaciente);
			sesion.close();
			}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando la autorizacionPaciente", e);
		}		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AutorizacionPaciente> obtenerAutorizacionesPacientePorPaciente(int pacienteId) throws Exception {
		Session sesion = null;
		try{			
			List<AutorizacionPaciente> autorizacionesPaciente = new ArrayList<AutorizacionPaciente>();
			sesion = getSession();
			autorizacionesPaciente = sesion.createCriteria(AutorizacionPaciente.class)
					.add(Restrictions.eq("pacienteId", pacienteId))
					.list();			
			return autorizacionesPaciente;			
		}catch(HibernateException e){
			throw new Exception(e);
		}
	}

}

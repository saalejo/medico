package admisiones.db.dao.implementacion;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import admisiones.db.dao.interfaz.PacienteDao;
import admisiones.db.dto.modelo.Paciente;

public class PacienteDaoImpl extends HibernateDaoSupport  implements PacienteDao{

	@Override
	public Paciente obtener(String id) {
		Session sesion = null;
		sesion = getSession();		
		Paciente paciente = (Paciente)sesion.createCriteria(Paciente.class)
				.add(Restrictions.eq("identificacion", id))
				.uniqueResult();		
		return paciente;
	}

	@Override
	public void guardar(Paciente paciente) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(paciente);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}
}
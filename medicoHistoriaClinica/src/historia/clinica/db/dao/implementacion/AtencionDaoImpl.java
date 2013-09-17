package historia.clinica.db.dao.implementacion;

import historia.clinica.db.dao.interfaz.AtencionDao;
import historia.clinica.db.dto.modelo.Atencion;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.Update;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class AtencionDaoImpl extends HibernateDaoSupport implements AtencionDao{
	
	
	@Override
	public Atencion guardar(Atencion atencion) {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(atencion);
			sesion.flush();
			tx.commit();
			sesion.close();
			return atencion;
		}catch(HibernateException e){
			e.printStackTrace();
			return null;
		}		
	}
	
	@Override
	public void actualizar(Atencion atencion) throws Exception {
		Session sesion = null;
		try{
			
			sesion = getSession();
			sesion.update(atencion);
			sesion.close();
			}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando la atencion", e);
		}		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Atencion> obtenerAtencionesPorPaciente(int pacienteId) throws Exception {
		Session sesion = null;
		try{			
			List<Atencion> atenciones = new ArrayList<Atencion>();
			sesion = getSession();
			atenciones = sesion.createCriteria(Atencion.class)
					.add(Restrictions.eq("pacienteId", pacienteId))
					.list();			
			return atenciones;			
		}catch(HibernateException e){
			throw new Exception(e);
		}
	}

}

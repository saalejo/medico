package admisiones.db.dao.implementacion;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import admisiones.db.dao.interfaz.IngresoDao;
import admisiones.db.dto.modelo.Ingreso;


public class IngresoDaoImpl extends HibernateDaoSupport implements IngresoDao{
	
	
	@Override
	public Ingreso guardar(Ingreso ingreso) {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(ingreso);
			sesion.flush();
			tx.commit();
			sesion.close();
			return ingreso;
		}catch(HibernateException e){
			e.printStackTrace();
			return null;
		}		
	}
	
	@Override
	public void actualizar(Ingreso ingreso) throws Exception {
		Session sesion = null;
		try{			
			sesion = getSession();
			sesion.update(ingreso);
			sesion.close();
			}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando la ingreso", e);
		}		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ingreso> obtenerIngresosPorPaciente(int pacienteId) throws Exception {
		Session sesion = null;
		try{			
			List<Ingreso> ingreso = new ArrayList<Ingreso>();
			sesion = getSession();
			ingreso = sesion.createCriteria(Ingreso.class)
					.add(Restrictions.eq("pacienteId", pacienteId))
					.list();			
			return ingreso;			
		}catch(HibernateException e){
			throw new Exception(e);
		}
	}

}

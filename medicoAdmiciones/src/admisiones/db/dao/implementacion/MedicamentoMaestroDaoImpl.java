package admisiones.db.dao.implementacion;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import admisiones.db.dao.interfaz.MedicamentoMaestroDao;
import admisiones.db.dto.modelo.MedicamentoMaestro;

public class MedicamentoMaestroDaoImpl extends HibernateDaoSupport implements MedicamentoMaestroDao {

	
	
	@Override
	public List<MedicamentoMaestro> obtener() throws Exception {
		Session sesion = null;
		
		try{
			List<MedicamentoMaestro> medicamentos = new ArrayList<MedicamentoMaestro>();
			sesion = getSession();
			medicamentos = sesion.createCriteria(MedicamentoMaestro.class)
					.list();			
			return medicamentos;
		}catch(HibernateException e){
			throw new Exception(e);
		}
		
	}

	@Override
	public MedicamentoMaestro obtener(int id) {
		Session sesion = null;
		sesion = getSession();		
		MedicamentoMaestro medicamento = (MedicamentoMaestro)sesion.createCriteria(MedicamentoMaestro.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return medicamento;
	}
	@Override
	public MedicamentoMaestro obtener(String codigoMedicamento)throws Exception {
		Session sesion = null;
		sesion = getSession();		
		MedicamentoMaestro medicamento = (MedicamentoMaestro)sesion.createCriteria(MedicamentoMaestro.class)
				.add(Restrictions.eq("codigo", codigoMedicamento))
				.uniqueResult();		
		return medicamento;
	}

	@Override
	public void guardar(MedicamentoMaestro medicamento) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(medicamento);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(MedicamentoMaestro medicamento) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(medicamento);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}
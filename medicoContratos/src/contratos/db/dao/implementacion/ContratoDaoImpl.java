package contratos.db.dao.implementacion;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import contratos.db.dao.interfaz.ContratoDao;
import contratos.db.dto.modelo.AreaServicios;
import contratos.db.dto.modelo.Contrato;



public class ContratoDaoImpl extends HibernateDaoSupport  implements ContratoDao{

	
	@Override
	public List<Contrato> obtener(int entidadId) {
		Session sesion = null;
		sesion = getSession();		
		List<Contrato> contratos = sesion.createCriteria(Contrato.class)
				.add(Restrictions.eq("co_entidad_id", entidadId))
				.list();		
		return contratos;
	}

	@Override
	public void guardar(Contrato contrato) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(contrato);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Contrato contrato) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(contrato);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}

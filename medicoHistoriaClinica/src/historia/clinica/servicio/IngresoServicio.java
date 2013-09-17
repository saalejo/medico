package historia.clinica.servicio;

import historia.clinica.db.dao.interfaz.IngresoDao;
import historia.clinica.db.dto.modelo.Ingreso;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class IngresoServicio {

	@Autowired
	IngresoDao ingresoDao;

	public  List<Ingreso> obtener() {
		try {
			return ingresoDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	/**
	 * @return the ingresoDao
	 */
	public IngresoDao getIngresoDao() {
		return ingresoDao;
	}

	/**
	 * @param ingresoDao the ingresoDao to set
	 */
	public void setIngresoDao(IngresoDao ingresoDao) {
		this.ingresoDao = ingresoDao;
	}

	
	public Ingreso obtener(int usuarioId) {
		try {
			return ingresoDao.obtener(usuarioId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void guardar(String nombre,int duracion,String usuarioConectado) {
		try {
			Ingreso ingreso=new Ingreso();	
			ingresoDao.guardar(ingreso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nuevo(int pacienteId,String usuarioConectado) {
		Ingreso ingreso=new Ingreso();
		ingreso.setEstado("activo");
		ingreso.setFecha(new Date());
		ingreso.setPacienteId(pacienteId);
		ingreso.setUsuarioConectado(usuarioConectado);
		try {
			ingresoDao.guardar(ingreso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void borrar(int id) {
		Ingreso ingreso=new Ingreso();
		ingreso.setId(id);
		ingresoDao.borrar(ingreso);
		
	}

	public void cerrar(Ingreso ingreso) {
		ingreso.setEstado("cerrado");
		try {
			ingresoDao.actualizar(ingreso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void guardar(Ingreso ingreso) {
		try {
			ingresoDao.guardar(ingreso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void actualizar(Ingreso ingreso) {
		try {
			ingresoDao.actualizar(ingreso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	
}

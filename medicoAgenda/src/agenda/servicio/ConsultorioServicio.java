package agenda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import agenda.db.dao.interfaz.ConsultorioDao;
import agenda.db.dto.modelo.Consultorio;


public class ConsultorioServicio {

	@Autowired
	ConsultorioDao consultorioDao;
	
	

	public ConsultorioDao getConsultorioDao() {
		return consultorioDao;
	}

	public void setConsultorioDao(ConsultorioDao consultorioDao) {
		this.consultorioDao = consultorioDao;
	}


	public  List<Consultorio> obtener() {
		try {
			return consultorioDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
	public Consultorio obtener(int id) {
		try {
			return consultorioDao.obtener(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void guardar(int codigo, String nombre,String usuarioConectado) {
		try {
			Consultorio consultorio=new Consultorio();
			consultorio.setCodigo(codigo);
			consultorio.setNombre(nombre);
			consultorio.setUsuarioConectado(usuarioConectado);		
			consultorioDao.guardar(consultorio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizar(int id, int codigo, String nombre, String usuarioConectado) {
		try {
			Consultorio consultorio=new Consultorio();
			consultorio.setId(id);
			consultorio.setCodigo(codigo);
			consultorio.setNombre(nombre);
			consultorio.setUsuarioConectado(usuarioConectado);		
			consultorioDao.actualizar(consultorio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrar(int id) {
		Consultorio consultorio=new Consultorio();
		consultorio.setId(id);
		consultorioDao.borrar(consultorio);
		
	}

	

	
   }
  


package agenda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import agenda.db.dao.interfaz.CausaCancelacionDao;
import agenda.db.dto.modelo.CausaCancelacion;

public class CausaCancelacionServicio {

	@Autowired
	CausaCancelacionDao causaCancelacionDao;
	
	

	public CausaCancelacionDao getCausaCancelacionDao() {
		return causaCancelacionDao;
	}



	public void setCausaCancelacionDao(CausaCancelacionDao causaCancelacionDao) {
		this.causaCancelacionDao = causaCancelacionDao;
	}



	public  List<CausaCancelacion> obtener() {
		try {
			return causaCancelacionDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
	public CausaCancelacion obtener(int id) {
		try {
			return causaCancelacionDao.obtener(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void guardar(String nombre,String usuarioConectado) {
		try {
			CausaCancelacion causaCancelacion=new CausaCancelacion();
			causaCancelacion.setNombre(nombre);
			causaCancelacion.setUsuarioConectado(usuarioConectado);		
			causaCancelacionDao.guardar(causaCancelacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizar(int id, String nombre, String usuarioConectado) {
		try {
			CausaCancelacion causaCancelacion=new CausaCancelacion();
			causaCancelacion.setId(id);
			causaCancelacion.setNombre(nombre);
			causaCancelacion.setUsuarioConectado(usuarioConectado);		
			causaCancelacionDao.actualizar(causaCancelacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrar(int id) {
		CausaCancelacion causaCancelacion=new CausaCancelacion();
		causaCancelacion.setId(id);
		causaCancelacionDao.borrar(causaCancelacion);
		
	}

	
   }
  


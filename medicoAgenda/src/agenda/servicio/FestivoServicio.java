package agenda.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import agenda.db.dao.interfaz.FestivoDao;
import agenda.db.dto.modelo.Festivo;


public class FestivoServicio {

	@Autowired
	FestivoDao festivoDao;
	

	public FestivoDao getFestivoDao() {
		return festivoDao;
	}

	public void setFestivoDao(FestivoDao festivoDao) {
		this.festivoDao = festivoDao;
	}

	public  List<Festivo> obtener() {
		try {
			return festivoDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
	public Festivo obtener(int id) {
		try {
			return festivoDao.obtener(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void guardar(Date fecha, String motivo, String usuarioConectado) {
		try {
			Festivo festivo = new Festivo();
			festivo.setFecha(fecha);
			festivo.setMotivo(motivo);
			festivo.setUsuarioConectado(usuarioConectado);		
			festivoDao.guardar(festivo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizar(int id, Date fecha, String motivo, String usuarioConectado ) {
		try {
			Festivo festivo = new Festivo();
			festivo.setId(id);
			festivo.setFecha(fecha);
			festivo.setMotivo(motivo);
			festivo.setUsuarioConectado(usuarioConectado);				
			festivoDao.actualizar(festivo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrar(int id) {
		Festivo festivo=new Festivo();
		festivo.setId(id);
		festivoDao.borrar(festivo);
		
	}

	

	
   }
  


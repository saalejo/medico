package agenda.servicio;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import agenda.db.dao.interfaz.ConfiguracionDao;
import agenda.db.dto.modelo.Configuracion;





public class ConfiguracionServicio {

	@Autowired
	ConfiguracionDao configuracionDao;
	
	public ConfiguracionDao getConfiguracionDao() {
		return configuracionDao;
	}

	public void setConfiguracionDao(ConfiguracionDao configuracionDao) {
		this.configuracionDao = configuracionDao;
	}

	public  List<Configuracion> obtener() {
		try {
			return configuracionDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
	public Configuracion obtener(int id) {
		try {
			return configuracionDao.obtener(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public void actualizar(int id, Boolean sabado, Boolean domingo,
			Boolean festivo, String mensaje1, String mensaje2,
			Date horaInicial, Date horaFinal,
			String usuarioConectado) {
		try {
			Configuracion configuracion=new Configuracion();
			configuracion.setId(id);
			configuracion.setSabado(sabado);
			configuracion.setDomingo(domingo);
			configuracion.setFestivo(festivo);
			configuracion.setMensaje1(mensaje1);
			configuracion.setMensaje2(mensaje2);
			configuracion.setHoraInicial(horaInicial);
			configuracion.setHoraFinal(horaFinal);
			configuracion.setUsuarioConectado(usuarioConectado);		
			configuracionDao.actualizar(configuracion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	

	
   }
  


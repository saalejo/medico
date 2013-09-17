package agenda.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import agenda.db.dao.interfaz.EventoDao;
import agenda.db.dto.modelo.Evento;




public class EventoServicio {

	@Autowired
	EventoDao eventoDao;
	

	public EventoDao getEventoDao() {
		return eventoDao;
	}

	public void setEventoDao(EventoDao eventoDao) {
		this.eventoDao = eventoDao;
	}

	public  List<Evento> obtener() {
		try {
			return eventoDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
	public Evento obtener(int id) {
		try {
			return eventoDao.obtener(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void guardar(Date fecha, Date horaInicial, Date horaFinal,
			String motivo, Boolean todosDias, String usuarioConectado) {
		try {
			Evento evento=new Evento();
			evento.setFecha(fecha);
			evento.setHoraInicial(horaInicial);
			evento.setHoraFinal(horaFinal);
			evento.setMotivo(motivo);
			evento.setTodosDias(todosDias);
			evento.setUsuarioConectado(usuarioConectado);		
			eventoDao.guardar(evento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizar(int id, Date fecha, Date horaInicial, Date horaFinal,
			String motivo, Boolean todosDias, String usuarioConectado ) {
		try {
			Evento evento=new Evento();
			evento.setId(id);
			evento.setFecha(fecha);
			evento.setHoraInicial(horaInicial);
			evento.setHoraFinal(horaFinal);
			evento.setMotivo(motivo);
			evento.setTodosDias(todosDias);
			evento.setUsuarioConectado(usuarioConectado);		
			eventoDao.actualizar(evento);		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrar(int id) {
		Evento evento=new Evento();
		evento.setId(id);
		eventoDao.borrar(evento);
		
	}

	

	
   }
  


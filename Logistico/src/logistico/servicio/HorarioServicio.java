package logistico.servicio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import logistico.db.dao.interfaz.HorarioDao;
import logistico.db.dto.modelo.Horario;

import org.springframework.beans.factory.annotation.Autowired;

public class HorarioServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	HorarioDao horarioDao;
	
	/**
	 * @return the horarioDao
	 */
	public HorarioDao getHorarioDao() {
		return horarioDao;
	}

	/**
	 * @param horarioDao the horarioDao to set
	 */
	public void setHorarioDao(HorarioDao horarioDao) {
		this.horarioDao = horarioDao;
	}

	public List<Horario> obtener() throws Exception {
		return horarioDao.obtener();
	}	
	
	public void actualizar(int id, Date horaInicial, Date horaFinal, String dia, Boolean activo, int usuarioConectado) {
		Horario horario = new Horario(id, horaInicial, horaFinal, dia, activo, usuarioConectado);
		try {
			horarioDao.actualizar(horario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar(Date horaInicial, Date horaFinal, String dia, Boolean activo, int usuarioConectado) {
		Horario horario = new Horario(horaInicial, horaFinal, dia, activo, usuarioConectado);
		try {
			horarioDao.guardar(horario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void borrar(int id) {
		Horario horario = new Horario();
		try {
			horario.setId(id);
			horarioDao.borrar(horario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

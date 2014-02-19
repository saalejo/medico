package logistico.servicio;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.ConsultorioDao;
import logistico.db.dto.modelo.Consultorio;

import org.springframework.beans.factory.annotation.Autowired;

public class ConsultorioServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	ConsultorioDao consultorioDao;

	/**
	 * @return the consultorioDao
	 */
	public ConsultorioDao getConsultorioDao() {
		return consultorioDao;
	}

	/**
	 * @param consultorioDao the consultorioDao to set
	 */
	public void setConsultorioDao(ConsultorioDao consultorioDao) {
		this.consultorioDao = consultorioDao;
	}

	public List<Consultorio> obtener() throws Exception {
		return consultorioDao.obtener();
	}	
		
	public void actualizar(int id, String descripcion, int usuarioConectado) {
		Consultorio consultorio = new Consultorio(id, descripcion, usuarioConectado);
		try {
			consultorioDao.actualizar(consultorio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar(String descripcion, int usuarioConectado, int municipioId) {
		Consultorio consultorio = new Consultorio(descripcion, usuarioConectado);
		try {
			consultorioDao.guardar(consultorio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void borrar(int id) {
		Consultorio consultorio = new Consultorio();
		try {
			consultorio.setId(id);
			consultorioDao.borrar(consultorio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

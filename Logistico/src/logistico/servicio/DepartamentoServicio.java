package logistico.servicio;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.DepartamentoDao;
import logistico.db.dto.modelo.Departamento;

import org.springframework.beans.factory.annotation.Autowired;

public class DepartamentoServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	DepartamentoDao departamentoDao;
	
	
	/**
	 * @return the departamentoDao
	 */
	public DepartamentoDao getDepartamentoDao() {
		return departamentoDao;
	}

	/**
	 * @param departamentoDao the departamentoDao to set
	 */
	public void setDepartamentoDao(DepartamentoDao departamentoDao) {
		this.departamentoDao = departamentoDao;
	}


	public List<Departamento> obtener() throws Exception {
		return departamentoDao.obtener();
	}
	
	public void actualizar(int id, String descripcion, int usuarioConectado) {
		Departamento departamento = new Departamento(id, descripcion, usuarioConectado);
		try {
			departamentoDao.actualizar(departamento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar(String descripcion, int usuarioConectado) {
		Departamento departamento = new Departamento(descripcion, usuarioConectado);
		try {
			departamentoDao.guardar(departamento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void borrar(int id) {
		Departamento departamento = new Departamento();
		try {
			departamento.setId(id);
			departamentoDao.borrar(departamento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}

package admisiones.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import admisiones.db.dao.interfaz.MunicipioDao;
import admisiones.db.dto.modelo.Municipio;

public class MunicipioServicio {

	@Autowired
	MunicipioDao municipioDao;

	public  List<Municipio> obtener() {
		try {
			return municipioDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	/**
	 * @return the municipioDao
	 */
	public MunicipioDao getMunicipioDao() {
		return municipioDao;
	}

	/**
	 * @param municipioDao the municipioDao to set
	 */
	public void setMunicipioDao(MunicipioDao municipioDao) {
		this.municipioDao = municipioDao;
	}

	
	public Municipio obtener(int id) {
		try {
			return municipioDao.obtener(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void guardar(String nombre, String codigoMunicipio, String codigoDepartamento,
			String usuarioConectado) {
		Municipio municipio=new Municipio();
		municipio.setNombre(nombre);
		municipio.setCodigo(codigoMunicipio); 
		municipio.setCodigoDepartamento(codigoDepartamento);
		try {
			municipioDao.guardar(municipio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void borrar(int id) {
		Municipio municipio=new Municipio();
		municipio.setId(id);
		municipioDao.borrar(municipio);		
	}
	
	
}

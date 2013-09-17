package admisiones.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import admisiones.db.dao.interfaz.PrestadorDao;
import admisiones.db.dao.interfaz.ProfesionalDao;
import admisiones.db.dto.modelo.Prestador;
import admisiones.db.dto.modelo.Profesional;

public class PrestadorServicio {
	
	@Autowired
	PrestadorDao prestadorDao;

	public  List<Prestador> obtener() {
		try {
			return prestadorDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	/**
	 * @return the prestadorDao
	 */
	public PrestadorDao getPrestadorDao() {
		return prestadorDao;
	}

	/**
	 * @param prestadorDao the prestadorDao to set
	 */
	public void setPrestadorDao(PrestadorDao prestadorDao) {
		this.prestadorDao = prestadorDao;
	}	
	
	public void guardar(String identificacion,String nombre,String tipoIdentificacion,String razonSocial,int municipioId,String usuarioConectado) {
		try {
			Prestador prestador=new Prestador();
			prestador.setIdentificacion(identificacion);
			prestador.setNombre(nombre);
			prestador.setTipoIdentificacion(tipoIdentificacion);
			prestador.setRazonSocial(razonSocial);
			prestador.setMunicipioId(municipioId);
			prestador.setUsuarioConectado(usuarioConectado);
			prestadorDao.guardar(prestador);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrar(int id) {
		Prestador prestador=new Prestador();
		prestador.setId(id);
		prestadorDao.borrar(prestador);
		
	}
	
}

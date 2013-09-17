package agenda.db.dto.modelo;

import java.io.Serializable;
import java.util.Set;

public class CausaCancelacion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8076944128227910042L;
	int id;
	String nombre;
	String usuarioConectado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(String usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}

	
	
}

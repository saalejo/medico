package historia.clinica.db.dto.modelo;

import java.io.Serializable;
import java.util.Date;

public class Aplicacion implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
int id ;
Date fechaAplicacion;
String observacion;
int usuarioConectado;

int atencionProductoId;
AtencionProducto atencionProducto;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getFechaAplicacion() {
	return fechaAplicacion;
}
public void setFechaAplicacion(Date fechaAplicacion) {
	this.fechaAplicacion = fechaAplicacion;
}
public String getObservacion() {
	return observacion;
}
public void setObservacion(String observacion) {
	this.observacion = observacion;
}
public int getUsuarioConectado() {
	return usuarioConectado;
}
public void setUsuarioConectado(int usuarioConectado) {
	this.usuarioConectado = usuarioConectado;
}
public int getAtencionProductoId() {
	return atencionProductoId;
}
public void setAtencionProductoId(int atencionProductoId) {
	this.atencionProductoId = atencionProductoId;
}


}

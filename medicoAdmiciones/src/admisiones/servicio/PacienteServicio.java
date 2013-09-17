package admisiones.servicio;




import hcdigital.util.validaciones.TextoValidaciones;

import java.util.Date;

import admisiones.db.dao.interfaz.EntidadDao;
import admisiones.db.dao.interfaz.MunicipioDao;
import admisiones.db.dao.interfaz.PacienteDao;
import admisiones.db.dao.interfaz.ProfesionalDao;
import admisiones.db.dto.modelo.Paciente;
import admisiones.db.dto.modelo.Profesional;



public class PacienteServicio {
	
	private ProfesionalDao profesionalDao;
	private PacienteDao pacienteDao;
	private MunicipioDao municipioDao;
	private EntidadDao entidadDao;

	
	
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

	/**
	 * @return the profesionalDao
	 */
	public ProfesionalDao getProfesionalDao() {
		return profesionalDao;
	}

	/**
	 * @param profesionalDao the profesionalDao to set
	 */
	public void setProfesionalDao(ProfesionalDao profesionalDao) {
		this.profesionalDao = profesionalDao;
	}

	/**
	 * @return the pacienteDao
	 */
	public PacienteDao getPacienteDao() {
		return pacienteDao;
	}

	/**
	 * @param pacienteDao the pacienteDao to set
	 */
	public void setPacienteDao(PacienteDao pacienteDao) {
		this.pacienteDao = pacienteDao;
	}

	public Paciente guardar(
			String identificacion,
			String tipoDocumento,
			String primerNombre,
			String segundoNombre,
			String primerApellido,
			String segundoApellido,
			Date fechaNacimiento,
			String genero,
			String zona,
			int municipio,
			String primerTelefono,
			String segundoTelefono,
			String direccion,
			String antecedentesPatologicos,
			String  antecedentesQuirurgicos,
			String antecedentesAlergicos,
			String antecedentesHabitos,
			String antecedentesFamiliares,
			String mail,
			String  observaciones,
			String  estadoCivil,
			String lugarNacimiento,
			String  ocupacion,
			String  tipoUsuario,
			int entidad,
			String usuarioConectado) throws Exception{		
		
		//empezamos verificando que el usuario conectado tiene los permisos.
		Profesional profesionalConsultado = null;
		profesionalConsultado = profesionalDao.obtener(usuarioConectado);
		if(profesionalConsultado == null){
			throw new Exception("No tiene permisos, El profesional debe ser válido en el sistema");
		}		
		//hacemos las validaciones pertientes a los datos
		if(TextoValidaciones.esTextoVacio(identificacion))
			throw new Exception("La cedula no puede ser una cadena de caracteres nula o vacia");
		if(TextoValidaciones.esTextoVacio(tipoDocumento))
			throw new Exception("Los nombres no pueden ser una cadena de caracteres nulo o vacio");
		if(TextoValidaciones.esTextoVacio(primerNombre))
			throw new Exception("Los apellidos no pueden ser una cadena de caracteres nulo o vacio");
		if(TextoValidaciones.esTextoVacio(segundoNombre))
			throw new Exception("El correo no puede ser una cadena de caracteres nulo o vacio");
		if(TextoValidaciones.esTextoVacio(primerApellido))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");
		if(TextoValidaciones.esTextoVacio(segundoApellido))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");
		if(TextoValidaciones.esTextoVacio(fechaNacimiento.toString()))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");
		if(TextoValidaciones.esTextoVacio(genero))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");
		if(TextoValidaciones.esTextoVacio(zona))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");
		/*if(TextoValidaciones.esTextoVacio(municipio))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");*/
		if(TextoValidaciones.esTextoVacio(primerTelefono))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");
		if(TextoValidaciones.esTextoVacio(segundoTelefono))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");
		if(TextoValidaciones.esTextoVacio(direccion))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");		
		if(TextoValidaciones.esTextoVacio(estadoCivil))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");
		if(TextoValidaciones.esTextoVacio(lugarNacimiento))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");
		if(TextoValidaciones.esTextoVacio(ocupacion))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");
		if(TextoValidaciones.esTextoVacio(tipoUsuario))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");
		/*if(TextoValidaciones.esTextoVacio(entidad))
			throw new Exception("El paciente no puede ser una cadena de caracteres nulo o vacio");*/
		if(mail!=""){
			if(TextoValidaciones.esEmail(mail) )
				throw new Exception("Debe ser un correo electrónico valido");			
		}	
		//creamos el nuevo paciente.
		Paciente paciente = new Paciente();
		paciente.setIdentificacion(identificacion);
		paciente.setTipoDocumento(tipoDocumento);
		paciente.setPrimerNombre(primerNombre);
		paciente.setSegundoNombre(segundoNombre);
		paciente.setPrimerApellido(primerApellido);
		paciente.setSegundoApellido(segundoApellido);
		paciente.setFechaNacimiento(fechaNacimiento);
		paciente.setGenero(genero);
		paciente.setEstadoCivil(estadoCivil);
		paciente.setLugarNacimiento(lugarNacimiento);
		paciente.setZona(zona);		
		paciente.setPrimerTelefono(primerTelefono);
		paciente.setSegundoTelefono(segundoTelefono);
		paciente.setDireccion(direccion);
		paciente.setMail(mail);
		paciente.setOcupacion(ocupacion);
		paciente.setTipoUsuario(tipoUsuario);
		paciente.setMunicipioId(municipio);	
		paciente.setEntidadId(entidad);
		//lo hacemos persistente.
		pacienteDao.guardar(paciente);		
		return paciente;

	}

	public Paciente obtener(String id) {
		return pacienteDao.obtener(id);
	}

}

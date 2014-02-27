package historia.clinica.db.dto.modelo;

import java.io.Serializable;
import java.util.Date;

public class SignosVitales implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	Date fecha;
	Double frecuenciCardiaca;
	Double frecuenciaRespiratoria;
	Double temperatura;
	String via;    // via toma de temperatura 
	Double saturacionO2;
	Double presionSistolica;
	Double media;
	Double glasgow;    // campo calculado desde el formulario 
	Double ramsay;    // campo calculado desde el formulario 
	Double richmond; // campo calculado desde el formulario 
	String estadoNeurologico;
	Double pulso;
	Double pvc;
	Double talla;
	String estadoHidratacion;
	Double peso;
	Double glucometria;
	Double indiceMasaCorporal;
	Double escalaDolor;
	Double perimetroCefalico;
	Double perimetroAbdominal;
	Double riesgoCardiovascular;      // campo calculado desde el formulario 
	Double riesgoEnfermedadCronica;  // campo calculado desde el formulario 
	
	int atencionId;
	
	Atencion atencion;
	
	
	

}

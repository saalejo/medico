package historia.clinica.servicio;

import hcdigital.util.validaciones.TextoValidaciones;
import historia.clinica.db.dao.interfaz.AtencionDao;
import historia.clinica.db.dto.modelo.Atencion;
import historia.clinica.db.dto.modelo.CampoHistoria;
import historia.clinica.db.dto.modelo.Diagnostico;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Set;

import admisiones.db.dto.modelo.Paciente;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;


public class AtencionServicio {

	private AtencionDao atencionDao;

	public Atencion guardarAtencion(
			int ingresoId,
		Date fechaAtencion,
		String tipoConsulta,
		String observaciones,
		int pacienteId,
		int causaExternaId,
		int finalidadId,
		int municipioId,
		int profesionalId,
		Set<Diagnostico> diagnosticos,
		Set<CampoHistoria> camposHistoria) throws Exception {
				
				//hacemos las validaciones pertientes a los datos
				if(TextoValidaciones.esTextoVacio(tipoConsulta))
					throw new Exception("El tipoConsulta no puede ser una cadena de caracteres nulo o vacio");
				
				
				Atencion atencion=new Atencion();
				
				/*
				//creamos la nueva Atencion.
				
				atencion.setFechaAtencion(new Date());
				atencion.setHoraAtencion("hola");
				atencion.setAutorizacion("123456");
				atencion.setTipoConsulta("tipoConsulta");
				atencion.setMotivo("motivo");
				atencion.setEnfermedadActual("enfermedadActual");
				atencion.setRevisionSistemas("revisionSistemas");
				atencion.setInterpretacion("interpretacion");
				atencion.setExamenFisico("examenFisico");
				atencion.setObservaciones("observaciones");
				atencion.setAcompanante("acompanante");
				atencion.setTelefonoAcompanante("telefonoAcompanante");
				atencion.setParentezco("parentezco");
				atencion.setValCopago(new Float(12));
				atencion.setValConsulta(new Float(13));
				atencion.setPacienteId("pacienteId");
				atencion.setCausaExternaId(1);
				atencion.setFinalidadId(1);
				atencion.setMunicipioId(1);
				atencion.setProfesionalId(1);*/
				
				atencion.setIngresoId(ingresoId);
				atencion.setFechaAtencion(fechaAtencion);
				atencion.setTipoConsulta(tipoConsulta);
				atencion.setObservaciones(observaciones);
				atencion.setPacienteId(pacienteId);
				atencion.setCausaExternaId(causaExternaId);
				atencion.setFinalidadId(finalidadId);
				atencion.setMunicipioId(municipioId);
				atencion.setProfesionalId(profesionalId);
				atencion.setDiagnosticos(diagnosticos);	
				atencion.setCamposHistoria(camposHistoria);
				return atencionDao.guardar(atencion);
	}
	
	/**
	 * @return the atencionDao
	 */
	public AtencionDao getAtencionDao() {
		return atencionDao;
	}

	/**
	 * @param atencionDao the atencionDao to set
	 */
	public void setAtencionDao(AtencionDao atencionDao) {
		this.atencionDao = atencionDao;
	}

	public List<Atencion> obtener(int pacienteId) {
		try {
			return atencionDao.obtenerAtencionesPorPaciente(pacienteId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void actualizar(Atencion atencion) {
		try {
			atencionDao.actualizar(atencion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void guardar(Atencion atencion) {
		try {
			atencionDao.guardar(atencion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public ByteArrayInputStream obtenerHistoriaClinica(Paciente paciente) {
		List<Atencion> atenciones =obtener(paciente.getId());
		try{
			Document document = new Document();
			ByteArrayOutputStream ficheroPdf = new ByteArrayOutputStream();
			PdfWriter.getInstance(document,ficheroPdf).setInitialLeading(20);
			document.open();
			document.add(new Paragraph("Historia Clinica :",FontFactory.getFont("arial",22,Font.ITALIC,BaseColor.BLUE)));
			document.add(new Paragraph("Datos del Paciente"));
			document.add(new Paragraph("Nombre :"+paciente.getPrimerNombre()+" "+paciente.getPrimerApellido()));
			document.add(new Paragraph("Direccion :"+paciente.getDireccion()+"			Telefono :"+paciente.getPrimerTelefono()));
			document.add(new Paragraph("Entidad :"+paciente.getEntidad().getNombre()));
			for (Atencion atencion : atenciones) {
				document.add(new Paragraph("ID DEL INGRESO :"+atencion.getIngresoId()+"		ID DE LA ATENCION :"+atencion.getId(),FontFactory.getFont("arial",16,Font.ITALIC,BaseColor.BLACK)));
				document.add(new Paragraph("TIPO DE CONSULTA :"+atencion.getTipoConsulta()));
				document.add(new Paragraph("FECHA ATENCION :"+atencion.getFechaAtencion().toString()));
				document.add(new Paragraph("CAUSA EXTERNA :"+atencion.getCausaExterna().getDescripcion()));
				document.add(new Paragraph("FINALIDAD :"+atencion.getFinalidad().getFinalidad()));
				Set<CampoHistoria> camposHistoria=atencion.getCamposHistoria();
				String titulo="";
				for (CampoHistoria campoHistoria : camposHistoria) {					
					if(!titulo.equals(campoHistoria.getPadre())){
						titulo=campoHistoria.getPadre();
						document.add(new Paragraph(titulo,FontFactory.getFont("arial",18,Font.ITALIC,BaseColor.BLUE)));
					}
					document.add(new Paragraph(campoHistoria.getClave()+"     "+campoHistoria.getValor()+"     "+campoHistoria.getObservaciones()));
				}
				document.add(new Paragraph("DIAGNOSTICOS :"));
				Set<Diagnostico> diagnosticos = atencion.getDiagnosticos();
				for (Diagnostico diagnostico : diagnosticos) {					
					document.add(new Paragraph(diagnostico.getDiagnostico().getDescripcion()+"    "+diagnostico.getObservaciones() ));
				}
			}			
			document.close();	
			return new ByteArrayInputStream(ficheroPdf.toByteArray());
		}catch(DocumentException e){
			e.printStackTrace();
			return null;
		} 

		
	}
		

}

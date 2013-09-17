package hcdigital.controlador;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import admisiones.db.dto.modelo.Profesional;
import admisiones.servicio.ProfesionalServicio;
/**
 * Controlador del Login de la página.
 * 
 * @author Administración Team
 *
 */
public class LoginCtl extends GenericForwardComposer{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Campo de usuario
	 */
	private Textbox usuario;
	
	/**
	 * Campo de password
	 */
	private Textbox clave;
	

	/**
	 * Label de información de error
	 */
	private Label errorLabel;
	
	

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);		
	}
	
	
	/**
	 *  Evento Click del boton Acceder
	 */
	public void onClick$aceptar(){
		acceder();
	}
	
	/**
	 * Al presionar Enter en el campo de usuario
	 */
	public void onOK$usuario(){
		acceder();
	}
	
	/**
	 * Al presionar Enter en el campo de contraseña
	 */
	public void onOK$clave(){
		acceder();
	}
	
	/**
	 * Realiza el procedimiento de acceso en la aplicación
	 */
	public void acceder(){
		errorLabel.setValue(" ");
		errorLabel.setVisible(false);
		try{
			String user = usuario.getText();
			String pass = clave.getText();
			ProfesionalServicio profesionalServicio = (ProfesionalServicio) SpringUtil.getBean("profesionalServicio");
			Profesional profesional=profesionalServicio.obtenerPorUsuario(user);
			if(profesional!=null){
				if(profesional.getClave().equals(pass)){
					Sessions.getCurrent().setAttribute("profesional",profesional);
					Executions.getCurrent().sendRedirect("");
					
				}
				
			}
				errorLabel.setValue(Labels.getLabel("login.Error"));
				errorLabel.setVisible(true);
		}catch(Exception e){
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));	
			System.out.print(sw.toString());
		}
	}
	
}

package hcdigital.presentacion.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

public class Pintor extends GenericForwardComposer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String modulo="";
	String contenido="";
	
	Window popup;
	/**
	 * Carga contenido dinamicamente dentro de un contenedor tipo Window.
	 * 
	 * @param content Window donde cargar el contenido.
	 * @param zul URL del contenido (.ZUL)
	 * @throws IOException Archivo no localizado .ZUL
	 */
	
	
	
	public void refrescarmodulo(){
		
		if(this.modulo!=""){
			Window modulo=(Window)Sessions.getCurrent().getAttribute("moduloPosicion");
			java.io.InputStream zulInput = modulo.getClass().getClassLoader().getResourceAsStream(this.modulo) ;
			java.io.Reader zulReader = new java.io.InputStreamReader(zulInput) ;
			modulo.getChildren().clear();
			Component compModulo;
			try {
				compModulo = Executions.createComponentsDirectly(zulReader, "zul", null, null);
				modulo.appendChild(compModulo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.contenido!=""){
				Window contenido=(Window)Sessions.getCurrent().getAttribute("contenidoPosicion");
				zulInput = contenido.getClass().getClassLoader().getResourceAsStream(this.contenido) ;
				zulReader = new java.io.InputStreamReader(zulInput) ;
				contenido.getChildren().clear();
				Component compContenido;
				try {
					compContenido = Executions.createComponentsDirectly(zulReader, "zul", null, null);
					contenido.appendChild(compContenido);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}		
	}
	
	/**
	 * @return the modulo
	 */
	public String getModulo() {
		return modulo;
	}

	/**
	 * @param modulo the modulo to set
	 */
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public  void abrirVentana(String zul,String posicion,Map<String,Object> arg){		
		if(zul == null || zul.length() == 0)
			return;
		if(posicion==""){			
			java.io.InputStream zulInput = getClass().getClassLoader().getResourceAsStream(zul) ;
			java.io.Reader zulReader = new java.io.InputStreamReader(zulInput) ;
			try {
				popup = (Window)Executions.createComponentsDirectly(zulReader, "zul", null,arg);
				popup.setClosable(true);				
				popup.doModal();				
				Sessions.getCurrent().setAttribute("popup_window",popup);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SuspendNotAllowedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			Window contenido=null;
			if(posicion=="moduloPosicion"){
				contenido=(Window)Sessions.getCurrent().getAttribute("moduloPosicion");	
				this.modulo=zul;
			}else if(posicion=="contenidoPosicion"){
				contenido=(Window)Sessions.getCurrent().getAttribute("contenidoPosicion");
				this.contenido=zul;
			}
			java.io.InputStream zulInput = contenido.getClass().getClassLoader().getResourceAsStream(zul) ;
			java.io.Reader zulReader = new java.io.InputStreamReader(zulInput) ;
			contenido.getChildren().clear();
			Component comp;
			try {
				comp = Executions.createComponentsDirectly(zulReader, "zul", null, null);
				contenido.appendChild(comp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
	}
	public  void abrirVentana(String zul,Window ventana){		
		try {
			java.io.InputStream zulInput = getClass().getClassLoader().getResourceAsStream(zul) ;
			java.io.Reader zulReader = new java.io.InputStreamReader(zulInput) ;
			ventana.getChildren().clear();
			Component comp;
			comp = Executions.createComponentsDirectly(zulReader, "zul", null, null);
			ventana.appendChild(comp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Pintor() {
		super();
	}
	
	/**
	 * Oculta la ultima ventana emergente mostrada.
	 */
	public void cerrarVentana(){
		Window popup = (Window)Sessions.getCurrent().getAttribute("popup_window");
		if(popup != null){
			popup.onClose();
		}
	}
	
}
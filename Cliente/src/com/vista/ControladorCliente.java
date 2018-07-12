package com.vista;

import static com.Cliente.Cliente.nombreCliente;

import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import com.Cliente.EntradaSalida;
import com.cadena.ActualizarSalas;
import com.cadena.AgregarASala;
import com.cadena.ChainCliente;
import com.cadena.ClienteDejandoSala;
import com.cadena.ClienteSaliendo;
import com.cadena.CrearSala;
import com.cadena.ExisteSala;
import com.cadena.Invitacion;
import com.cadena.MensajeASala;
import com.cadena.NuevoClienteConectado;
import com.cadena.RefrescarCliente;
import com.mensajes.Mensaje;
import com.salas.Sala;

/**
 * PORqué tengo que meter esta clase en com.vista si es un controlador? solo
 * para tener acceso directo a los componentes GUI ??? otra forma ?
 * 
 * @author Maxi
 *
 */
public class ControladorCliente implements Runnable {
	
	private boolean corriendo=true;
	
	// Solo se usa para mostrar clientes en el lobby o cuando quiero agregar gente a
	// una conversacion.
	ArrayList<String> copiaClientesEnLobby;


	ArrayList<Sala> copiaSalasDisponibles;



	EntradaSalida entradaSalida;

	GUI_Lobby lobbyGui;

	ChainCliente manejador = null;

	public ControladorCliente(GUI_Lobby lobbyGui) {

		entradaSalida = EntradaSalida.getInstance();

		copiaClientesEnLobby = new ArrayList<>();
		copiaSalasDisponibles = new ArrayList<>();

		this.lobbyGui = lobbyGui;

		manejador = ensamblarChain();
	}

	public synchronized void manejarMensaje(Mensaje mensaje) {

		manejador.manejarPeticion(mensaje);
	}

	private ChainCliente ensamblarChain() {
		CrearSala crearSala = new CrearSala(copiaSalasDisponibles,lobbyGui);
		MensajeASala mensajeASala = new MensajeASala(copiaSalasDisponibles, this,lobbyGui);
		NuevoClienteConectado nuevoClienteConectado = new NuevoClienteConectado(lobbyGui, copiaClientesEnLobby);
		Invitacion invitacion = new Invitacion();
		AgregarASala agregarASala = new AgregarASala(copiaSalasDisponibles,lobbyGui);
		ClienteSaliendo clienteSaliendo= new ClienteSaliendo(copiaClientesEnLobby,copiaSalasDisponibles,lobbyGui );
		ClienteDejandoSala clienteDejandoSala = new ClienteDejandoSala(lobbyGui,copiaSalasDisponibles);
		ActualizarSalas actualizarSala = new ActualizarSalas(lobbyGui,copiaSalasDisponibles);
		RefrescarCliente refrescar = new RefrescarCliente(copiaSalasDisponibles);
		ExisteSala existeSala = new ExisteSala(copiaSalasDisponibles,lobbyGui);
		
		
		crearSala.enlazarSiguiente(mensajeASala);
		mensajeASala.enlazarSiguiente(nuevoClienteConectado);
		nuevoClienteConectado.enlazarSiguiente(invitacion);
		invitacion.enlazarSiguiente(actualizarSala);
		actualizarSala.enlazarSiguiente(refrescar);
		refrescar.enlazarSiguiente(existeSala);
		existeSala.enlazarSiguiente(clienteDejandoSala);
		clienteDejandoSala.enlazarSiguiente(agregarASala);
		agregarASala.enlazarSiguiente(clienteSaliendo);

		return crearSala;
	}

	@Override
	public void run() {
		try {
			while (corriendo) {
					Mensaje mensajeRecibido = entradaSalida.recibirMensaje();
					if(mensajeRecibido!=null){
						manejarMensaje(mensajeRecibido);
					}else{
						corriendo=false;
					}
					
			}
		} catch (Exception s) {
			s.printStackTrace();
			corriendo=false;
			}

	}

public synchronized void imprimirEnLobby(Mensaje mensaje) {
			StyledDocument styledDocument = lobbyGui.getChatLobby().getStyledDocument();
			StyleContext cont = StyleContext.getDefaultStyleContext();
	        AttributeSet atributoRojo = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.RED);
	        AttributeSet atributoAzul = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
	        AttributeSet attrBlack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
			
			try {
				String texto= mensaje.getInformacion().trim();
		        String linea[]=mensaje.getInformacion().split(" ");
		        if(linea!=null && linea.length>=1) {
		        	
		        styledDocument.insertString(styledDocument.getLength(),
		        							mensaje.getEmisor()+": ",
		        							atributoRojo);
		        
		        Pattern p = Pattern.compile("@[a-zA-Z0-9_.]+?(?![a-zA-Z0-9_.])");
		        
		        Matcher m = p.matcher(texto);
		        ArrayList<String> matches= new ArrayList<String>();
		        
		        while(m.find()) {
		        	matches.add(m.group());
		        }
		        
		        for(int i=0; i<linea.length;i++) {
		        	if(linea[i]!=null) {
		        		
		        		if(matches.contains(linea[i]) && copiaClientesEnLobby.contains(linea[i].substring(1, linea[i].length()))) {
		        			styledDocument.insertString(styledDocument.getLength(),linea[i]+" ", atributoAzul);
		        			
		        		}else {
		        			styledDocument.insertString(styledDocument.getLength(), linea[i]+" ", attrBlack);
		        		}
		        	}
		        }
		        styledDocument.insertString(styledDocument.getLength(), " \n", attrBlack);
		        }
			} catch (BadLocationException e) {

				e.printStackTrace();
			}

	}

	// no borrar


	// no borrar
	public synchronized void imprimirEnSala(Mensaje mensaje, GUI_Sala guiSala) {
		StyledDocument styledDocument=guiSala.getChatSala().getStyledDocument();
		StyleContext cont = StyleContext.getDefaultStyleContext();
        AttributeSet atributoRojo = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.RED);
        AttributeSet atributoAzul = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
        AttributeSet attrBlack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        
		try {
			String texto= mensaje.getInformacion().trim();
	        String linea[]=mensaje.getInformacion().split(" ");
	        if(linea!=null && linea.length>=1) {
		        styledDocument.insertString(styledDocument.getLength(),
											mensaje.getEmisor()+": ",
											atributoRojo);
	        Pattern p = Pattern.compile("@[a-zA-Z0-9_.]+?(?![a-zA-Z0-9_.])");
	        
	        Matcher m = p.matcher(texto);
	        ArrayList<String> matches= new ArrayList<String>();
	        
	        while(m.find()) {
	        	matches.add(m.group());
	        }
	        
	        for(int i=0; i<linea.length;i++) {
	        	if(linea[i]!=null) {
	        		
	        		if(matches.contains(linea[i]) && copiaClientesEnLobby.contains(linea[i].substring(1, linea[i].length()))) {
	        			styledDocument.insertString(styledDocument.getLength(),linea[i]+" ", atributoAzul);
	        			
	        		}else {
	        			styledDocument.insertString(styledDocument.getLength(), linea[i]+" ", attrBlack);
	        		}
	        	}
	        }
	        styledDocument.insertString(styledDocument.getLength(), " \n", attrBlack);
	        
	        }
		} catch (BadLocationException e) {

			e.printStackTrace();
		}
	}

	private boolean esParaEsteCliente(Mensaje mensaje) {
		String[] array = mensaje.getInformacion().split(" : ");
		return array[0].equals('\n' + nombreCliente);
	}

	public ArrayList<Sala> getCopiaSalasDisponibles() {
		return copiaSalasDisponibles;
	}

	public synchronized void agregarSala(Sala sala) {
		copiaSalasDisponibles.add(sala);
	}

	public synchronized void quitarSala(Sala sala) {

		copiaSalasDisponibles.remove(sala);

	}

	public EntradaSalida getEntradaSalida() {
		return entradaSalida;
	}
	
	public void setCorriendo(boolean valor){
		this.corriendo = valor;
	}
	
	@Deprecated
	public synchronized void imprimirEnLobby2(Mensaje mensaje) {
		StyledDocument styledDocument;

		if (!esParaEsteCliente(mensaje)) {
			styledDocument = lobbyGui.getChatLobby().getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
			try {
				styledDocument.insertString(styledDocument.getLength(), mensaje.getInformacion(), null);
				styledDocument.setParagraphAttributes(styledDocument.getLength() + 1, 1, center, false);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}

		} else {
			SimpleAttributeSet attribute = new SimpleAttributeSet();
			StyleConstants.setAlignment(attribute, StyleConstants.ALIGN_RIGHT);

			styledDocument = lobbyGui.getChatLobby().getStyledDocument();
			try {
				styledDocument.insertString(styledDocument.getLength(), mensaje.getInformacion(), null);
				styledDocument.setParagraphAttributes(styledDocument.getLength() + 1, 1, attribute, false);

			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Deprecated
	public synchronized void imprimirEnSala2(Mensaje mensaje, GUI_Sala guiSala) {
		StyledDocument styledDocument;
		StyleContext cont = StyleContext.getDefaultStyleContext();
        AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.RED);
        AttributeSet attrBlack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);

		if (!esParaEsteCliente(mensaje)) {
			styledDocument = guiSala.getChatSala().getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
			try {

		        String linea[]=mensaje.getInformacion().split(" ");
		        if(linea!=null && linea.length>=1) {
		        styledDocument.insertString(0,linea[0], attr);
		        StringBuilder sb= new StringBuilder();
		        for(int i=1; i<linea.length;i++) {
		        	if(linea[i]!=null)
		        	sb.append(linea[i]); 
		        }
		        
		        styledDocument.insertString(styledDocument.getLength(), sb.toString(), attrBlack);
				//styledDocument.insertString(styledDocument.getLength(), mensaje.getInformacion(), null);
				styledDocument.setParagraphAttributes(styledDocument.getLength() + 1, 1, center, false);
		        }
			} catch (BadLocationException e) {

				e.printStackTrace();
			}

		} else {
			SimpleAttributeSet attribute = new SimpleAttributeSet();
			StyleConstants.setAlignment(attribute, StyleConstants.ALIGN_RIGHT);

			styledDocument = guiSala.getChatSala().getStyledDocument();
			try {
				styledDocument.insertString(styledDocument.getLength(), mensaje.getInformacion(), null);
				styledDocument.setParagraphAttributes(styledDocument.getLength() + 1, 1, attribute, false);

			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}

	}
	
}

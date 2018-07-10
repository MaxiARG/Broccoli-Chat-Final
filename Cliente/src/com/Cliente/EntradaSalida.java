package com.Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;

import com.mensajes.Mensaje;
import com.utilitarios.HiloReconexion;
import com.vista.GUI_Login;


public class EntradaSalida {
	Socket socket;
	ObjectInputStream objectIn;
	ObjectOutputStream objectOut;
	static EntradaSalida entradasalida;
	private JFrame ventanaActual;
	
	private EntradaSalida() {
		entradasalida=this;
	}
	
	public static synchronized EntradaSalida getInstance() {
		if(entradasalida==null) {
			new EntradaSalida();
		}
		return entradasalida;
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
		try {
			objectOut = new ObjectOutputStream(socket.getOutputStream());
			objectIn = new ObjectInputStream(socket.getInputStream());
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void escribirMensaje(Mensaje mensaje) {
		try {
			objectOut.writeObject(mensaje);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	public void setJframeActual(JFrame jf) {
		if(jf!=null)
		ventanaActual=jf;
	}
	
	public Mensaje recibirMensaje() {
		Mensaje devuelve=null;
		try {
			devuelve= (Mensaje) objectIn.readObject();
		} catch (ClassNotFoundException | IOException e) {
			//Si se pierde la conexion por Socket Reset, abrir Login.
			GUI_Login g = new GUI_Login();
			g.setVisible(true);
			HiloReconexion hiloReconexion= new HiloReconexion(g);
			Thread tReconexion= new Thread(hiloReconexion,"Hilo_Reconexion");
			tReconexion.start();
			ventanaActual.dispose();
			//e.printStackTrace();
		}
		return devuelve;
	}
	public boolean entradaSalidaAbierta() {
		return (objectIn!=null && objectOut!=null && !socket.isClosed());
	}
	
	public void cerrarEntradaSalida() {
		try {
			socket.close();
			objectIn.close();
			objectOut.close();
			objectIn=null;
			objectOut=null;
	} catch (IOException e) {
		e.printStackTrace();
	} 
		}

	
}

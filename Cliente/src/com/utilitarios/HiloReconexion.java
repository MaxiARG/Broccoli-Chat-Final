package com.utilitarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Properties;

import com.vista.GUI_Login;

public class HiloReconexion implements Runnable{

	Socket socket;
	GUI_Login gui;
	boolean activado=true;
	private String IP_SERVIDOR;
	private String PUERTO_SERVIDOR;
	
	public HiloReconexion(GUI_Login gui) {
		super();
		this.gui=gui;
		leerConfiguracionServidor();
	}


	@Override
	public void run() {
		Socket nuevoSocket=null;
		while(activado) {
				try {
					leerConfiguracionServidor();
					nuevoSocket = new Socket(IP_SERVIDOR,Integer.parseInt(PUERTO_SERVIDOR));
					if(nuevoSocket!=null && nuevoSocket.isConnected()) {
						socket=nuevoSocket;
						gui.setEstado("");
						gui.setEstado("Estado: Servidor Online");
						activado=false;
						//********
						LoginHandler loginHandler= new LoginHandler(socket, gui);
						Thread tLoginHandler= new Thread(loginHandler);
						tLoginHandler.start();
						
					}else {
						Thread.sleep(2000); //Cada 2 segundos intenta conectarse nuevamente
					}
				} catch (NumberFormatException | IOException | InterruptedException e1) {
					try {
						Thread.sleep(2000);
						gui.setEstado("");
						gui.setEstado("Estado: Servidor No Alcanzable");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				} 	
		}
	}
	
	private void leerConfiguracionServidor() {
		Properties prop= new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("PropiedadesDelCliente");
			prop.load(fis);
			PUERTO_SERVIDOR=prop.getProperty("Puerto");
			IP_SERVIDOR=prop.getProperty("IP");
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public void terminarHilo() {activado=false;}
}

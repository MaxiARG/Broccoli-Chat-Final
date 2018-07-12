package com.salas;

import static com.Cliente.Cliente.nombreCliente;

import com.Cliente.EntradaSalida;
import com.mensajes.Comandos;
import com.mensajes.Mensaje;
import com.vista.GUI_Lobby;

public class HiloOutputLobby implements Runnable{

	GUI_Lobby lobbyGui;
	
	EntradaSalida entradaSalida;
	boolean sigueCorriendo;
	public HiloOutputLobby(GUI_Lobby lobby_Gui){
		
		this.lobbyGui=lobby_Gui;
		this.entradaSalida=EntradaSalida.getInstance();
	}
	
	@Override
	public void run() {
		sigueCorriendo = true;
		StringBuilder strBuilder;
			
		while(sigueCorriendo) {
		synchronized(this){
			try {
				
				wait();
			
				String textoAEnviar = lobbyGui.getChatTextBoxLobby().getText();
				if(!textoAEnviar.trim().equals("")) {
					strBuilder = new StringBuilder();
					strBuilder.append(textoAEnviar.trim());
				
					Mensaje msjAEnviar=new Mensaje(Comandos.MensajeASala,
												   strBuilder.toString(),
												   -1,
												   nombreCliente);
					
					entradaSalida.escribirMensaje(msjAEnviar);
					lobbyGui.getChatTextBoxLobby().setText("");
				}
					
			}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
			
		}
	
	public void mandarMensaje(){
		synchronized(this){
			notify();
		}
	}
	
	public void setSigueCorriendo(boolean valor){
		this.sigueCorriendo = valor;
	}
}

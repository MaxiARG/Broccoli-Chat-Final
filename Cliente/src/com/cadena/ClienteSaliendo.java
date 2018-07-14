package com.cadena;

import java.util.ArrayList;


import com.Cliente.EntradaSalida;
import com.mensajes.Comandos;
import com.mensajes.Mensaje;
import com.salas.Sala;
import com.vista.GUI_Lobby;

public class ClienteSaliendo extends ChainCliente {
	ArrayList<String> copiaClientesEnLobby;
	ArrayList<Sala> copiaSalasDisponibles;
	EntradaSalida entradaSalida;
	private GUI_Lobby lobbyGui;
	

	
	public ClienteSaliendo(ArrayList<String> copiaClientesEnLobby,
			ArrayList<Sala> copiaSalasDisponibles, GUI_Lobby guiLobby) {
		super();
		this.copiaClientesEnLobby = copiaClientesEnLobby;
		this.lobbyGui = guiLobby;
		this.copiaSalasDisponibles = copiaSalasDisponibles;

		this.entradaSalida = EntradaSalida.getInstance();
	}

	


	@Override
	public void manejarPeticion(Mensaje mensaje) {
		
			if(mensaje.getComando().equals(Comandos.ClienteSaliendo)) {
				String nombreClienteSaliente=mensaje.getInformacion();
				copiaClientesEnLobby.remove(nombreClienteSaliente);
				lobbyGui.quitarCliente(nombreClienteSaliente);
				
				buscarYEliminarClienteDeSalas(nombreClienteSaliente);
				
				
			}else {
				System.out.println("fin chain");
				}
	}
	private void buscarYEliminarClienteDeSalas(String nombreClienteSaliente) {
		
			for(int i = 0 , cantSalas = copiaSalasDisponibles.size() ; i < cantSalas;i++){
				Sala salaActual = copiaSalasDisponibles.get(i);
				salaActual.sacarCliente(nombreClienteSaliente);
				if(salaActual.getCantidadConectados()==0) {
					copiaSalasDisponibles.remove(i);
					lobbyGui.quitarSala(salaActual.getNombreSala());
				}
			}
	
			
	}

}

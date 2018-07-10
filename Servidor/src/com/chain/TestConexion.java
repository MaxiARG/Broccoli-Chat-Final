package com.chain;

import java.util.ArrayList;

import com.cliente.Cliente;
import com.mensajes.Comandos;
import com.mensajes.Mensaje;

public class TestConexion extends Chain {
	
	ArrayList<Cliente> clientesEnLobby;
	public TestConexion(ArrayList<Cliente> clientesEnLobby) {
		this.clientesEnLobby=clientesEnLobby;
	}

	@Override
	public void manejarPeticion(Mensaje mensaje) {
		if (mensaje.getComando().equals(Comandos.TestConexion)) {
				String emisor= mensaje.getEmisor();
				for(Cliente c : clientesEnLobby) {
					if(c.getNombre().equals(emisor)) {
						c.enviarMensaje(new Mensaje(Comandos.TestConexion,"1"));
					}
				}
		} else {
			System.out.println("Servidor: Ultimo eslabon. TestConexion. El comando era: "+mensaje.getComando());
		}
	}

}

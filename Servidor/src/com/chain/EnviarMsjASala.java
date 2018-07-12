package com.chain;

import java.util.ArrayList;

import com.cliente.Cliente;
import com.mensajes.Comandos;
import com.mensajes.Mensaje;
import com.sala.Sala;

import asistente.clase.Asistente;

public class EnviarMsjASala extends Chain {

	private ArrayList<Sala> salas;
	private String nombreAsistente;
	private Asistente asistente;

	public EnviarMsjASala(ArrayList<Sala> _salas) {
		salas = _salas;
		nombreAsistente = new String("jenkins");
		
	}

	@Override
	public void manejarPeticion(Mensaje mensaje) {
		if (mensaje.getComando().equals(Comandos.MensajeASala)) {
			asistente = new Asistente(mensaje.getEmisor(),nombreAsistente);
			mensaje.imprimirAConsola();
			String devuelve = asistente.escuchar(mensaje.getInformacion());
			
			boolean mensajeJenkins=(!devuelve.contains("Disculpa... no entiendo el pedido") && 
										!devuelve.contains("Te estás dirigiendo a mí"));

			if (mensajeJenkins) {
				for (Sala s : salas) {
					if (s.getSalaID().equals(mensaje.getSalaID()))
							for(Cliente c: s.getClientesEnSala()) {
								if(c.getNombre().equals(mensaje.getEmisor())) {
									Mensaje msjDeJenkins= new Mensaje(Comandos.MensajeASala,
																	  devuelve,
																	  mensaje.getSalaID(),
																	  nombreAsistente);
									c.enviarMensaje(msjDeJenkins);
								}
							}
				}
				
			} else {
				
				for (Sala s : salas) {
					if (s.getSalaID().equals(mensaje.getSalaID()))
						s.enviarMensaje(mensaje);

				}
			}
		} else {
			siguiente.manejarPeticion(mensaje);
		}
	}

}

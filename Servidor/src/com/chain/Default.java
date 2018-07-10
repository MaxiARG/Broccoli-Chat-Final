package com.chain;

import com.mensajes.Mensaje;

public class Default extends Chain{

	@Override
	public void manejarPeticion(Mensaje mensaje) {
		System.out.println("Servidor: Ultimo eslabon. Operacion no soportada");
		System.out.println("El comando era: "+mensaje.getComando());
	}

}

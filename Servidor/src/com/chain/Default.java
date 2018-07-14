package com.chain;

import com.logs.LoggerCliente;
import com.mensajes.Mensaje;

public class Default extends Chain{

	@Override
	public void manejarPeticion(Mensaje mensaje) {
		LoggerCliente.enviarLog("Servidor: Ultimo eslabon. Operacion no soportada");
	}

}

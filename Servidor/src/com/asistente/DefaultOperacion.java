package com.asistente;

public class DefaultOperacion implements Operacion{

	@Override
	public void siguiente(Operacion siguiente) {
		System.out.println("ATENCION, LLAMASTE A UNA CHAIN DEFAULT, NO HACE NADA, NO ENLAZA NADA.");
	}

	@Override
	public String calcular(Pedido pedido) {
		System.out.println("Servidor: Ultimo eslabon. Operacion no soportada");
		return null;
	}

}

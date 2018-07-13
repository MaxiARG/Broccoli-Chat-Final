package asistente.operacion;

import asistente.clase.Pedido;

public class Clima implements Operacion{
	private Operacion siguiente;


	@Override
	public String calcular(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;	
		
	}

}

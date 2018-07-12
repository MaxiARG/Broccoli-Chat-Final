package asistente.operacion;

import asistente.clase.Pedido;

public interface Operacion {
	public void siguiente(Operacion siguiente);
	public String calcular(Pedido pedido);
}

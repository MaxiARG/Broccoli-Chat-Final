package asistente.operacion;

import java.util.ArrayList;

import asistente.clase.Pedido;
import asistente.inet.BusquedaInet;
import asistente.inet.Internet;

public class Busqueda implements Operacion {

	private Operacion siguiente;

	@Override
	public String calcular(Pedido pedido) {
		String linea[]= pedido.getMensaje().split(" ");
		StringBuilder palabraClave=new StringBuilder();
		if(linea!=null && linea.length>=3 && linea[0].equals("@jenkins") && linea[1].equals("buscame:")) {
			for(int i=2; i<linea.length; i++) {
				palabraClave.append(linea[i]+" ");
			}
			BusquedaInet b = new BusquedaInet(palabraClave.toString(), Internet.BUSQUEDA);
			ArrayList<asistente.util.Busqueda> resultado = b.obtenerBusqueda(); 
			StringBuilder respuesta= new StringBuilder();
			respuesta.append(resultado.get(0).getExtracto()+" ");
			respuesta.append(resultado.get(0).getUrl());
			return respuesta.toString();
		}else {
			return siguiente.calcular(pedido);
		}
		//textAreaResultadoBusqueda.setText(resultado.get(0).getExtracto());
		//lblUrlInternet.setText(resultado.get(0).getUrl());
	}
	
	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;	
	}

}

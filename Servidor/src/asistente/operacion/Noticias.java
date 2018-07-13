package asistente.operacion;

import java.util.ArrayList;

import asistente.clase.Pedido;
import asistente.inet.BusquedaInet;
import asistente.inet.ClimaInet;
import asistente.inet.CotizacionInet;
import asistente.inet.Internet;
import asistente.inet.NoticiaInet;
import asistente.util.Clima;
import asistente.util.Cotizacion;
import asistente.util.Noticia;

public class Noticias implements Operacion {

	private Operacion siguiente;

	@Override
	public String calcular(Pedido pedido) {
		String linea[]= pedido.getMensaje().split(" ");
		StringBuilder palabraClave=new StringBuilder();
		
		if(linea!=null && linea.length>=3 && linea[0].equals("@jenkins") && pedido.getMensaje().contains("dame las noticias")) {
			
			ArrayList<Noticia> listaNoticias= new NoticiaInet(Internet.NOTICIA).obtenerNoticias();
			StringBuilder str= new StringBuilder();
			
			for (Noticia noticia : listaNoticias) {
				str.append(noticia.getTitulo()+"\n");
			}
				
			ClimaInet clima = new ClimaInet(Internet.CLIMA);
			Clima c = clima.obtenerClima();
			str.append("\n***  El Clima *** \n");
			str.append("Tiempo:"+c.getTiempo() + "\n" +
					"Temp:"+c.getTemperatura() + "\n" +
					"ST:"+c.getSensacionTermica() + "\n" +
					"Humedad:"+c.getHumedad() + "\n" +
					"Viento:"+c.getVientos() + "\n" +
					"Nubosidad:"+c.getNubosidad()+ "\n" );
			str.append("\n***   Cotizacion Del Dolar   *** \n");
			CotizacionInet cotiza = new CotizacionInet(Internet.COTIZACION);
			ArrayList<Cotizacion> listaCotizacion = new ArrayList<>();
			listaCotizacion = cotiza.obtenerCotizacion();
			for (Cotizacion cotizacion : listaCotizacion) {
				str.append("Compra: "+cotizacion.getCompra()+"\n"+"Venta: "+cotizacion.getVenta());
			}
			
			return str.toString();
		}else {
			return siguiente.calcular(pedido);
		}
	}
	
	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;	
	}

}

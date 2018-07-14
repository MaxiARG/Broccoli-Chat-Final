package asistente.operacion;


import asistente.clase.Pedido;
import asistente.inet.ClimaInet;
import asistente.inet.Internet;
import asistente.util.Clima;

public class PedirClima implements Operacion{
	private Operacion siguiente;

	@Override
	public String calcular(Pedido pedido) {
			
		if( pedido.getMensaje()!=null && pedido.getMensaje().equals("@jenkins dame el clima")) {
			
			StringBuilder str= new StringBuilder();
			
			ClimaInet clima = new ClimaInet(Internet.CLIMA);
			Clima c = clima.obtenerClima();
			str.append("\n***  Mi Amo y Señor *** \n");
			str.append("\n***  El Clima Es Como Sigue *** \n");
			str.append("Tiempo: "+c.getTiempo() + "\n" +
						"Temp: "+c.getTemperatura() + "\n" +
						"ST: "+c.getSensacionTermica() + "\n" +
						"Humedad: "+c.getHumedad() + "\n" +
						"Viento: "+c.getVientos() + "\n" +
						"Nubosidad: "+c.getNubosidad()+ "\n" );
			str.append("\n***  A sus Ordenes *** \n");
			
			return str.toString();
		}
		
		return siguiente.calcular(pedido);
		
	}

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;	
	}


}

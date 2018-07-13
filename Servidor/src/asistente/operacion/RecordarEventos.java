package asistente.operacion;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.modelo.CampoEvento;

import asistente.clase.Pedido;
import asistente.util.Fecha;

/** 
 * Resolvedor, Agenda nuevos eventos en el futuro y permite ver los proximos eventos pendientes.
 */
public class RecordarEventos implements Operacion {
	
	private Operacion siguiente;


	public RecordarEventos() {
	}
	
	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	public String calcular(Pedido pedido) {
		String regex_recordar = ".*(?:agrega|recorda|agenda).*:(.*) (\\d+)(?: de |\\/)([a-zA-Z]*|\\d+)(?: de |\\/)(\\d+)";
		Pattern pattern_recordar = Pattern.compile(regex_recordar, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher_recordar = pattern_recordar.matcher(pedido.getMensaje());
		while(matcher_recordar.find()) {
			if(matcher_recordar.matches()) {
				String desc = matcher_recordar.group(1).trim();
				Fecha fecha = null;
				try {
					fecha = new Fecha(matcher_recordar.group(2)+"/"+matcher_recordar.group(3)+"/"+matcher_recordar.group(4),"d'/'MMMMM'/'yyyy");
				} catch (ParseException e) {
					return siguiente.calcular(pedido);
				}
				
				Evento e = new Evento(fecha, desc,pedido.getNameUsuario());
				if(e.guardarEvento()) {
					return pedido.getNameUsuario() + " Evento agregado";
				} else {
					return pedido.getNameUsuario() + " No se pudo agregar el evento";
				}
					
			}
		}
		
		String regex_proximo = ".*proximo.*evento.*";
		Pattern pattern_proximo = Pattern.compile(regex_proximo, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher_proximo = pattern_proximo.matcher(pedido.getMensaje());
		while(matcher_proximo.find()) {
			if(matcher_proximo.matches()) {
				Evento e = new Evento();
				e.setUsuario(pedido.getNameUsuario());
				CampoEvento cEvento = e.proximoEvento();
				if(cEvento != null) {
					return pedido.getNameUsuario() + " El próximo evento es: " + cEvento.toString().trim() + " y faltan " + cEvento.getFecha().diferenciaDeDias() + " días";
				}
				else {
					return pedido.getNameUsuario() + " No tenés eventos";
				}
			}

		}
		
		return siguiente.calcular(pedido);
	}
}

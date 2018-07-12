package asistente.inet;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import asistente.util.Cotizacion;

public class CotizacionInet extends Internet{
	
	
	public CotizacionInet(int indice) {
		super(indice);
	}
	
	public boolean jsonValido() {
		String jSon = "{\"meta\":{\"effective_params\":{\"data_set\":\"OANDA\",\"base_currencies\":[\"USD\"],\"quote_currencies\":[\"ARS\"]},\"endpoint\":\"spot\",\"request_time\":\"2018-07-10T04:10:25+00:00\",\"skipped_currency_pairs\":[]},\"quotes\":[{\"base_currency\":\"USD\",\"quote_currency\":\"ARS\",\"bid\":\"27.9165\",\"ask\":\"27.9245\",\"midpoint\":\"27.9205\"}]}";
		JsonParser jParser = new JsonParser();
		JsonElement jElemento = jParser.parse(jSon);
		JsonArray jArray = jElemento.getAsJsonObject().get("quotes").getAsJsonArray();
		for (JsonElement jsonElement : jArray) {
			JsonObject objeto = jsonElement.getAsJsonObject();
			if(!objeto.get("base_currency").isJsonPrimitive() && objeto.get("bid").isJsonPrimitive() && objeto.get("ask").isJsonPrimitive()) {
				return false;
			}
		}
		return true;	
	}
	
	public ArrayList<Cotizacion> obtenerCotizacion() {
		String cadenaJson = obtenerJson();
		ArrayList<Cotizacion> lista = new ArrayList<Cotizacion>();
		if(cadenaJson != null) {
			JsonParser jParser = new JsonParser();
			JsonElement jElemento = jParser.parse(cadenaJson);
			JsonArray jArray = jElemento.getAsJsonObject().get("quotes").getAsJsonArray();
			for (JsonElement jsonElement : jArray) {
				JsonObject objeto = jsonElement.getAsJsonObject();
				Cotizacion cotizacion = new Cotizacion();
				if(objeto.get("base_currency").isJsonPrimitive() && objeto.get("bid").isJsonPrimitive() && objeto.get("ask").isJsonPrimitive()) {
					cotizacion.setMonedaDestino(objeto.get("base_currency").getAsString());
					cotizacion.setCompra(objeto.get("bid").getAsString());
					cotizacion.setVenta(objeto.get("ask").getAsString());
					lista.add(cotizacion);
				}
			}
		}
		return lista;
	}
}

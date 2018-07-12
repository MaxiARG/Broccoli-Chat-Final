package asistente.inet;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import asistente.util.Busqueda;

public class BusquedaInet extends Internet {
	private ArrayList<Busqueda> busqueda;
	
	public BusquedaInet(String palabraClave, int indice) {
		super(palabraClave, indice);
		this.busqueda = new ArrayList<Busqueda>();
	}
	
	private boolean existeBusqueda() {
		return !this.busqueda.isEmpty();
	}
	
	public ArrayList<Busqueda> obtenerBusqueda() {
		this.busqueda = obtenerBusquedaWikipedia();
		if(existeBusqueda()) {
			return this.busqueda;
		}
		else {
			this.busqueda.add(
					new Busqueda("No hay resultados en Wikipedia, prueba con el siguiente link",
							"https://www.google.com.ar/search?q=" + getPalabraClave() ));
			return this.busqueda;
		}
		
	}
	
	public boolean jsonValido() {
		String json = obtenerJson();
		if(json != null){
			JsonParser jParser = new JsonParser();
			JsonElement jElement = jParser.parse(json);
			
			if(!jElement.getAsJsonObject().getAsJsonObject("query").isJsonObject())
				return false;
			JsonObject campoQuery = jElement.getAsJsonObject().getAsJsonObject("query");
			
			if(!campoQuery.getAsJsonObject("searchinfo").get("totalhits").isJsonPrimitive())
				return false;
			int cantidadResultados = campoQuery.getAsJsonObject("searchinfo").get("totalhits").getAsInt();
			if(cantidadResultados > 0) {
				if(!jElement.getAsJsonObject().getAsJsonObject("query").get("search").isJsonArray())
					return false;
				JsonArray jArray = jElement.getAsJsonObject().getAsJsonObject("query").get("search").getAsJsonArray();
				if(!jArray.get(0).isJsonObject())
					return false;
				JsonObject objeto = jArray.get(0).getAsJsonObject();
				
				if(!objeto.get("snippet").isJsonPrimitive())
					return false;
			}
		}
		return true;
	}
	
	
	private ArrayList<Busqueda> obtenerBusquedaWikipedia() {
		String json = obtenerJson();
		if(json != null){
			JsonParser jParser = new JsonParser();
			JsonElement jElement = jParser.parse(json);
			//JsonArray jArray = jElement.getAsJsonObject().get("query").getAsJsonArray();
			JsonObject campoQuery = jElement.getAsJsonObject().getAsJsonObject("query");//.getAsJsonObject("searchInfo");
			int cantidadResultados = campoQuery.getAsJsonObject("searchinfo").get("totalhits").getAsInt();
			if(cantidadResultados > 0) {
				JsonArray jArray = jElement.getAsJsonObject().getAsJsonObject("query").get("search").getAsJsonArray();
				JsonObject objeto = jArray.get(0).getAsJsonObject();
				this.busqueda.add(
						new Busqueda(
								objeto.get("snippet").getAsString().replaceAll("\\<.*?>",""),"https://es.wikipedia.org/wiki/" + getPalabraClave()));
			}
		}
		return this.busqueda;
	}
}

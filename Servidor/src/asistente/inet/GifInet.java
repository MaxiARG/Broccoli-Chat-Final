package asistente.inet;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GifInet extends Internet{

	public GifInet(String palabraClave, int indice) {
		super(palabraClave, indice);
	}
	
	private boolean hayResultados(JsonElement jElement) {
		JsonObject hayResultado = jElement.getAsJsonObject().get("pagination").getAsJsonObject();
		return hayResultado.get("count").isJsonPrimitive() && hayResultado.get("count").getAsInt() > 0;
	}
	
	public boolean jsonValido() {
		String json = obtenerJson();
		if(json != null){
			JsonParser jParser = new JsonParser();
			JsonElement jElement = jParser.parse(json);
			if(hayResultados(jElement)) {
				JsonArray jArray = jElement.getAsJsonObject().get("data").getAsJsonArray() ;
				if(!jArray.isJsonArray())
					return false;
				for (int i = 0; i < jArray.size(); i++) {
					JsonObject primerGrupo = jArray.get(i).getAsJsonObject(); // primerGrupo.size() devuelve el total de grupos
					JsonObject grupoImages = primerGrupo.getAsJsonObject().get("images").getAsJsonObject();
					if(!grupoImages.isJsonObject())
						return false;
					JsonObject grupoTipoGif = grupoImages.get("fixed_height").getAsJsonObject();
					if(!grupoTipoGif.isJsonObject())
						return false;
					if(grupoTipoGif.get("url").isJsonPrimitive()) {
						String url = grupoTipoGif.get("url").getAsString();
						String noValido = "";
						if(url.equals("") == false) {
							// reemplazar cadena que se encuentra entre https// y .com por i.gihpy
							noValido = url.substring(url.indexOf("https://") + 8, url.indexOf(".com"));
							if(noValido.equals(""))
								return false;
						}
					}
					else {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public ArrayList<String> obtenerGif() {
		ArrayList<String> listaGifs = new ArrayList<>();
		String json = obtenerJson();
		if(json != null){
			JsonParser jParser = new JsonParser();
			JsonElement jElement = jParser.parse(json);
			if(hayResultados(jElement)) {
				JsonArray jArray = jElement.getAsJsonObject().get("data").getAsJsonArray() ;
				for (int i = 0; i < jArray.size(); i++) {
					JsonObject primerGrupo = jArray.get(i).getAsJsonObject(); // primerGrupo.size() devuelve el total de grupos
					JsonObject grupoImages = primerGrupo.getAsJsonObject().get("images").getAsJsonObject();
					JsonObject grupoTipoGif = grupoImages.get("fixed_height").getAsJsonObject();
					if(grupoTipoGif.get("url").isJsonPrimitive()) {
						String url = grupoTipoGif.get("url").getAsString();
						String noValido = "";
						if(url.equals("") == false) {
							// reemplazar cadena que se encuentra entre https// y .com por i.gihpy
							noValido = url.substring(url.indexOf("https://") + 8, url.indexOf(".com"));
							if(noValido.equals("") == false)
								listaGifs.add(url.replace(noValido, "i.giphy"));	
						}
					}
				}
			}
		}
		return listaGifs;
	}
}

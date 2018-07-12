package inet;

import java.util.ArrayList;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import util.Ciudad;
import util.Clima;

public class ClimaInet extends Internet {

	public ClimaInet(String buscarCiudad, final int indice) {
		super(buscarCiudad, indice);
	}
	
	public ClimaInet(final int indice) {
		super(indice);
	}
	
	public boolean jsonValido() {
		//String json = "[{\"LocalObservationDateTime\":\"2018-07-09T23:55:00-03:00\",\"EpochTime\":1531191300,\"WeatherText\":\"Algunas nubes\",\"WeatherIcon\":36,\"IsDayTime\":false,\"Temperature\":{\"Metric\":{\"Value\":6.4,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":43.0,\"Unit\":\"F\",\"UnitType\":18}},\"RealFeelTemperature\":{\"Metric\":{\"Value\":7.2,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":45.0,\"Unit\":\"F\",\"UnitType\":18}},\"RealFeelTemperatureShade\":{\"Metric\":{\"Value\":7.2,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":45.0,\"Unit\":\"F\",\"UnitType\":18}},\"RelativeHumidity\":90,\"DewPoint\":{\"Metric\":{\"Value\":4.9,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":41.0,\"Unit\":\"F\",\"UnitType\":18}},\"Wind\":{\"Direction\":{\"Degrees\":180,\"Localized\":\"S\",\"English\":\"S\"},\"Speed\":{\"Metric\":{\"Value\":3.6,\"Unit\":\"km/h\",\"UnitType\":7},\"Imperial\":{\"Value\":2.3,\"Unit\":\"mi/h\",\"UnitType\":9}}},\"WindGust\":{\"Speed\":{\"Metric\":{\"Value\":5.1,\"Unit\":\"km/h\",\"UnitType\":7},\"Imperial\":{\"Value\":3.2,\"Unit\":\"mi/h\",\"UnitType\":9}}},\"UVIndex\":0,\"UVIndexText\":\"Bajo\",\"Visibility\":{\"Metric\":{\"Value\":16.1,\"Unit\":\"km\",\"UnitType\":6},\"Imperial\":{\"Value\":10.0,\"Unit\":\"mi\",\"UnitType\":2}},\"ObstructionsToVisibility\":\"\",\"CloudCover\":61,\"Ceiling\":{\"Metric\":{\"Value\":9144.0,\"Unit\":\"m\",\"UnitType\":5},\"Imperial\":{\"Value\":30000.0,\"Unit\":\"ft\",\"UnitType\":0}},\"Pressure\":{\"Metric\":{\"Value\":1034.0,\"Unit\":\"mb\",\"UnitType\":14},\"Imperial\":{\"Value\":30.53,\"Unit\":\"inHg\",\"UnitType\":12}},\"PressureTendency\":{\"LocalizedText\":\"Constante\",\"Code\":\"S\"},\"Past24HourTemperatureDeparture\":{\"Metric\":{\"Value\":-0.9,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":-2.0,\"Unit\":\"F\",\"UnitType\":18}},\"ApparentTemperature\":{\"Metric\":{\"Value\":7.8,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":46.0,\"Unit\":\"F\",\"UnitType\":18}},\"WindChillTemperature\":{\"Metric\":{\"Value\":6.1,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":43.0,\"Unit\":\"F\",\"UnitType\":18}},\"WetBulbTemperature\":{\"Metric\":{\"Value\":5.7,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":42.0,\"Unit\":\"F\",\"UnitType\":18}},\"Precip1hr\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"PrecipitationSummary\":{\"Precipitation\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"PastHour\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"Past3Hours\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"Past6Hours\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"Past9Hours\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"Past12Hours\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"Past18Hours\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"Past24Hours\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}}},\"TemperatureSummary\":{\"Past6HourRange\":{\"Minimum\":{\"Metric\":{\"Value\":6.4,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":43.0,\"Unit\":\"F\",\"UnitType\":18}},\"Maximum\":{\"Metric\":{\"Value\":9.4,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":49.0,\"Unit\":\"F\",\"UnitType\":18}}},\"Past12HourRange\":{\"Minimum\":{\"Metric\":{\"Value\":6.4,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":43.0,\"Unit\":\"F\",\"UnitType\":18}},\"Maximum\":{\"Metric\":{\"Value\":11.8,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":53.0,\"Unit\":\"F\",\"UnitType\":18}}},\"Past24HourRange\":{\"Minimum\":{\"Metric\":{\"Value\":3.6,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":38.0,\"Unit\":\"F\",\"UnitType\":18}},\"Maximum\":{\"Metric\":{\"Value\":11.8,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":53.0,\"Unit\":\"F\",\"UnitType\":18}}}},\"MobileLink\":\"http://m.accuweather.com/es/ar/san-justo/7626/current-weather/7626\",\"Link\":\"http://www.accuweather.com/es/ar/san-justo/7626/current-weather/7626\"}]";
		String json = obtenerJson();
		JsonParser jParser = new JsonParser();
		JsonElement jElemento = jParser.parse(json);
		JsonObject objeto = jElemento.getAsJsonArray().get(0).getAsJsonObject();
		return (objeto.getAsJsonObject("Temperature").getAsJsonObject("Metric").get("Unit").isJsonPrimitive() &&
		objeto.getAsJsonObject("Wind").getAsJsonObject("Speed").getAsJsonObject("Metric").get("Unit").isJsonPrimitive() &&
		objeto.get("WeatherText").isJsonPrimitive() && objeto.get("RelativeHumidity").isJsonPrimitive() &&
		objeto.getAsJsonObject("Temperature").getAsJsonObject("Metric").get("Value").isJsonPrimitive() &&
		objeto.getAsJsonObject("RealFeelTemperature").getAsJsonObject("Metric").get("Value").isJsonPrimitive() &&
		objeto.getAsJsonObject("Wind").getAsJsonObject("Speed").getAsJsonObject("Metric").get("Value").isJsonPrimitive());
	}
	
	public Clima obtenerClima() {
		String json = obtenerJson();
		Clima clima = new Clima();
		char unidad = 0;
		String unidad_viento = "";
		if(!json.equals("")) {
			JsonParser jParser = new JsonParser();
			JsonElement jElemento = jParser.parse(json);
			JsonObject objeto = jElemento.getAsJsonArray().get(0).getAsJsonObject();
			if(objeto.getAsJsonObject("Temperature").getAsJsonObject("Metric").get("Unit").isJsonPrimitive())
				unidad = objeto.getAsJsonObject("Temperature").getAsJsonObject("Metric").get("Unit").getAsCharacter();
			if(objeto.getAsJsonObject("Wind").getAsJsonObject("Speed").getAsJsonObject("Metric").get("Unit").isJsonPrimitive())
				unidad_viento = objeto.getAsJsonObject("Wind").getAsJsonObject("Speed").getAsJsonObject("Metric").get("Unit").getAsString();
			if(objeto.get("WeatherText").isJsonPrimitive())
				clima.setTiempo("Tiempo: " + objeto.get("WeatherText").getAsString());
			if(objeto.get("RelativeHumidity").isJsonPrimitive())
				clima.setHumedad("Humedad: " + objeto.get("RelativeHumidity").getAsString() + "%");
			if(objeto.getAsJsonObject("Temperature").getAsJsonObject("Metric").get("Value").isJsonPrimitive())
				clima.setTemperatura("Temperatura: " + objeto.getAsJsonObject("Temperature").getAsJsonObject("Metric").get("Value").getAsDouble() + " º" + unidad);
			if(objeto.getAsJsonObject("RealFeelTemperature").getAsJsonObject("Metric").get("Value").isJsonPrimitive())
				clima.setSensacionTermica("Sensación termica: "+objeto.getAsJsonObject("RealFeelTemperature").getAsJsonObject("Metric").get("Value").getAsDouble() + " º" + unidad);
			if(objeto.getAsJsonObject("Wind").getAsJsonObject("Speed").getAsJsonObject("Metric").get("Value").isJsonPrimitive())
				clima.setVientos("Vientos: " + objeto.getAsJsonObject("Wind").getAsJsonObject("Speed").getAsJsonObject("Metric").get("Value").getAsDouble() 
						+ " " + unidad_viento);
			if(objeto.get("CloudCover").isJsonPrimitive())
				clima.setNubosidad("Nubosidad: " + objeto.get("CloudCover") + "%");
		}
		return clima;
	}
	
	public ArrayList<Ciudad> buscarCiudad(){
		String json = obtenerJson();
		ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>();
		if(!json.equals("")) {
			JsonParser jParser = new JsonParser();
			JsonElement jElemento = jParser.parse(json);
			for(int i = 0; i < jElemento.getAsJsonArray().size(); i++) {
				JsonObject objeto = jElemento.getAsJsonArray().get(i).getAsJsonObject();
				Ciudad ciudad = new Ciudad();
				if(objeto.get("Key").isJsonPrimitive()) 
					ciudad.setKeyLocation(objeto.get("Key").getAsString());
				if(objeto.get("LocalizedName").isJsonPrimitive()) 
					ciudad.setNombre(objeto.get("LocalizedName").getAsString());
				if(objeto.get("Region").getAsJsonObject().get("LocalizedName").isJsonPrimitive())
					ciudad.setRegion(objeto.get("Region").getAsJsonObject().get("LocalizedName").getAsString());
				if(objeto.get("Country").getAsJsonObject().get("LocalizedName").isJsonPrimitive())
					ciudad.setPais(objeto.get("Country").getAsJsonObject().get("LocalizedName").getAsString());
				if(objeto.get("AdministrativeArea").getAsJsonObject().get("LocalizedName").isJsonPrimitive())
					ciudad.setProvincia(objeto.get("AdministrativeArea").getAsJsonObject().get("LocalizedName").getAsString());
				listaCiudades.add(ciudad);
			}
		}
		return listaCiudades;
	}
	
}

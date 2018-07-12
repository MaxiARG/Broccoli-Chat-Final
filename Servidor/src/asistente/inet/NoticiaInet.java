package asistente.inet;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import asistente.util.Noticia;

public class NoticiaInet extends Internet {
	
	public NoticiaInet(final int indice) {
		super(indice);
	}
	
	public boolean jsonValido() {
		//String jSon = "{\"status\":\"ok\",\"totalResults\":10,\"articles\":[{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"Cinco opciones para una 'escapada' de aventuras en familia por Tucumán\",\"description\":\"En plena temporada de invierno, la provincia ofrece sitios emblemáticos y otros que son muy pocos visitados. Se trata de lugares a los que se puede acceder con los hijos adolescentes. Lo mejor es elegir un destino, preparar las mochilas, usar ropa cómoda y em…\",\"url\":\"https://www.lagaceta.com.ar/nota/776940/actualidad/cinco-opciones-para-escapada-aventuras-familia-tucuman.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/07/10/776940_201807091924310000001.jpg\",\"publishedAt\":\"2018-07-09T18:20:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"Mbappé no se entrenó con Francia, pero Deschamps dice que jugará ante Bélgica\",\"description\":\"También se movieron en forma diferenciada Benjamin Pavard y N'Golo Kanté.\",\"url\":\"https://www.lagaceta.com.ar/nota/776946/deportes/mbappe-no-se-entreno-francia-pero-deschamps-dice-jugara-ante-belgica.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/07/09/776946_20180709211958.jpg\",\"publishedAt\":\"2018-07-09T18:19:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"San Martín empezó la segunda etapa de su pretemporada en Perico\",\"description\":\"El plantel permanecerá hasta el sábado en el complejo Los Arcos y regresará a la provincia. Amistosos con Atlético y presentación en la Copa Argentina.\",\"url\":\"https://www.lagaceta.com.ar/nota/776945/deportes/san-martin-empezo-segunda-etapa-pretemporada-perico.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/07/09/776945_20180709204453.jpg\",\"publishedAt\":\"2018-07-09T17:47:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"Sebastián Beccacece: 'con Messi tuve una convivencia maravillosa'\",\"description\":\"Asumió en Defensa y Justicia. Negó peleas en Rusia aunque insinuó que su relación con Sampaoli no terminó bien.\",\"url\":\"https://www.lagaceta.com.ar/nota/776943/deportes/sebastian-beccacece-con-messi-tuve-convivencia-maravillosa.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/07/09/776943_20180709194935.jpg\",\"publishedAt\":\"2018-07-09T16:53:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"Un tour de compras que pasó por Tucumán llevaba casi 30 kilos de cocaína\",\"description\":\"El colectivo fue revisado por Gendarmería Nacional en Santiago del Estero, donde hallaron la droga oculta entre mantas polares.\",\"url\":\"https://www.lagaceta.com.ar/nota/776924/actualidad/tour-compras-paso-tucuman-llevaba-casi-30-kilos-cocaina.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/07/09/776924_20180709183437.jpg\",\"publishedAt\":\"2018-07-09T15:39:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"Tiró a una mujer de la moto para robarle, ella lo denunció y la Policía lo detuvo\",\"description\":\"Los uniformados que allanaron la vivienda del presunto asaltante secuestraron un revólver.\",\"url\":\"https://www.lagaceta.com.ar/nota/776923/actualidad/tiro-mujer-moto-para-robarle-ella-lo-denuncio-policia-lo-detuvo.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/07/09/776923_20180709175036.png\",\"publishedAt\":\"2018-07-09T14:50:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"En imágenes, un resumen de los festejos por el Día de la Independencia\",\"description\":\"En estos momentos se desarrolla el desfile central en el parque 9 de Julio.\",\"url\":\"https://www.lagaceta.com.ar/nota/776913/actualidad/imagenes-resumen-festejos-dia-independencia.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/07/09/776913_20180709153308.jpg\",\"publishedAt\":\"2018-07-09T12:34:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"Tapia y Angelici se reunieron con Sampaoli, que por ahora seguirá en la Selección Argentina\",\"description\":\"Los dirigentes no querían que siga, pero hablarán con otros dirigentes de la AFA para tomar una decisión final.\",\"url\":\"https://www.lagaceta.com.ar/nota/776899/deportes/tapia-angelici-se-reunieron-sampaoli-ahora-seguira-seleccion-argentina.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/07/09/776899_20180709120026.jpg\",\"publishedAt\":\"2018-07-09T11:55:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"Un derrame de agua con cenizas inundó varias casas en La Trinidad\",\"description\":\"Se habría roto un ducto de los piletones del ingenio azucarero.\",\"url\":\"https://www.lagaceta.com.ar/nota/776912/actualidad/derrame-agua-cenizas-inundo-varias-casas-trinidad.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/07/09/776912_20180709144454.jpg\",\"publishedAt\":\"2018-07-09T11:48:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"Manzur: 'el 9 de Julio es una fecha muy cara al sentimiento de los argentinos'\",\"description\":\"Junto con el presidente, Mauricio Macri, rindieron homenaje a los próceres de la independencia en el Museo del la Casa Histórica.\",\"url\":\"https://www.lagaceta.com.ar/nota/776902/actualidad/manzur-el-9-julio-fecha-muy-cara-al-sentimiento-argentinos.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/07/09/776902_20180709120722.jpg\",\"publishedAt\":\"2018-07-09T09:06:00Z\"}]}";
		String jSon = obtenerJson();
		JsonParser jParser = new JsonParser();
		JsonElement jElemento = jParser.parse(jSon);
		JsonArray jArray = jElemento.getAsJsonObject().get("articles").getAsJsonArray();
		for (JsonElement jsonElement : jArray) {
			JsonObject objeto = jsonElement.getAsJsonObject();
			if(
				(objeto.get("author").isJsonPrimitive() &&
				objeto.get("title").isJsonPrimitive() &&
				objeto.get("description").isJsonPrimitive() &&
				objeto.get("url").isJsonPrimitive() &&
				objeto.get("urlToImage").isJsonPrimitive() &&
				objeto.get("publishedAt").isJsonPrimitive()
				) == false) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Noticia> obtenerNoticias() {
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		String cadenaJson = obtenerJson();
		if(!cadenaJson.equals("")) {
			JsonParser jParser = new JsonParser();
			JsonElement jElemento = jParser.parse(cadenaJson);
			JsonArray jArray = jElemento.getAsJsonObject().get("articles").getAsJsonArray();
			for (JsonElement jsonElement : jArray) {
				JsonObject objeto = jsonElement.getAsJsonObject();
				Noticia noticia = new Noticia();
				if(objeto.get("author").isJsonPrimitive())
					noticia.setAutor(objeto.get("author").getAsString());
				if(objeto.get("title").isJsonPrimitive())
					noticia.setTitulo(objeto.get("title").getAsString());
				if(objeto.get("description").isJsonPrimitive())
					noticia.setDescripcion(objeto.get("description").getAsString());
				if(objeto.get("url").isJsonPrimitive())
					noticia.setUrl(objeto.get("url").getAsString());
				if(objeto.get("urlToImage").isJsonPrimitive())
					noticia.setImagen(objeto.get("urlToImage").getAsString());
				if(objeto.get("publishedAt").isJsonPrimitive())
					noticia.setFecha(objeto.get("publishedAt").getAsString());
				listaNoticias.add(noticia);
			}
		}
		return listaNoticias;
	}
	
}

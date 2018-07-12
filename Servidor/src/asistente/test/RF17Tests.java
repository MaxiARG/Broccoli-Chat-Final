package asistente.test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import asistente.inet.ClimaInet;
import asistente.inet.CotizacionInet;
import asistente.inet.Internet;
import asistente.inet.NoticiaInet;
import asistente.util.Clima;
import asistente.util.Cotizacion;
import asistente.util.Noticia;

public class RF17Tests {
	
	NoticiaInet noticia;
	ClimaInet clima;
	CotizacionInet cotiza;
	
	@Before
	public void setup() {
		noticia = new NoticiaInet(Internet.NOTICIA);
		clima = new ClimaInet(Internet.CLIMA);
		cotiza = new CotizacionInet(Internet.COTIZACION);
	}
	
	@Test
	public void conexionAPINoticiaInet() {
		Assert.assertEquals(true, noticia.existJson());
	}

	@Test
	public void jsonValidoNoticiaInet() {
		Assert.assertEquals(true, noticia.jsonValido());
	}
	
	@Test
	public void mockNoticiaInet() {
		NoticiaInet mockNoticia = mock(NoticiaInet.class);
		when(mockNoticia.obtenerJson()).thenReturn("{\"status\":\"ok\","
				+ "\"totalResults\":10,\"articles\":[{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},"
				+ "\"author\":\"La Gaceta\",\"title\":\"Sampaoli, Tapia, Messi y Mascherano se reunieron y juraron unirse para salir adelante\","
				+ "\"description\":\"El equipo tiene altas chances, tras la victoria de Nigeria, frente a Islandia.\","
				+ "\"url\":\"https://www.lagaceta.com.ar/nota/775041/mundial-rusia-2018/sampaoli-tapia-messi-mascherano-se-reunieron-juraron-unirse-para-salir-adelante.html\","
				+ "\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/06/22/106781_20180622212503.jpg\","
				+ "\"publishedAt\":\"2018-06-22T19:01:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},"
				+ "\"author\":\"La Gaceta\",\"title\":\"Ricardo Echegaray fue suspendido sin goce de sueldo en la Aduana\","
				+ "\"description\":\"La decisión tomada por AFIP obedece a los procesamientos que recibió el funcionario en distintas causas judiciales.\","
				+ "\"url\":\"https://www.lagaceta.com.ar/nota/775037/actualidad/ricardo-echegaray-fue-suspendido-sin-goce-sueldo-aduana.html\","
				+ "\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/06/22/106780_20180622210856.jpg\","
				+ "\"publishedAt\":\"2018-06-22T18:43:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},"
				+ "\"author\":\"La Gaceta\",\"title\":\"A solas: Macri recibió a la diputada que se destacó durante el debate por el aborto\",\"description\":\"Silvia Lospennato estuvo reunida con el Presidente en la quinta de Olivos. La legalización del aborto fue el tema principal del encuentro.\",\"url\":\"https://www.lagaceta.com.ar/nota/775032/actualidad/a-solas-macri-recibio-diputada-se-destaco-durante-debate-aborto.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/06/22/775032_20180622212130.jpg\",\"publishedAt\":\"2018-06-22T18:21:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"El adiós de 'Rafa' García: se despidió de los hinchas decanos con un video\",\"description\":\"'Me han hecho sentir muy feliz', dijo el zaguero que jugará el segundo semestre del año en Nacional de Uruguay.\",\"url\":\"https://www.lagaceta.com.ar/nota/775022/deportes/adios-rafa-garcia-se-despidio-hinchas-decanos-video.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/06/22/775022_20180622203713.jpg\",\"publishedAt\":\"2018-06-22T17:41:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"Los memes: Nigeria le ganó a Islandia, Argentina se esperanza y el humor afloró\",\"description\":\"Los goles africanos fueron festejados en las redes sociales con las mejores bromas.\",\"url\":\"https://www.lagaceta.com.ar/nota/775021/mundial-rusia-2018/memes-nigeria-le-gano-islandia-argentina-se-esperanza-humor-afloro.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/06/22/106756_20180622162727.jpg\",\"publishedAt\":\"2018-06-22T17:25:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"Los hinchas argentinos que agredieron a un croata fueron expulsados del Mundial\",\"description\":\"Luego de la viralización del video en que se ve la golpiza que recibe el hincha europeo, autoridades rusas detuvieron a los responsables de la violencia.\",\"url\":\"https://www.lagaceta.com.ar/nota/775013/mundial-rusia-2018/hinchas-argentinos-agredieron-croata-fueron-expulsados-mundial.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/06/22/106762_20180622171537.jpg\",\"publishedAt\":\"2018-06-22T17:20:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"Caballero, fuera del once; Sampaoli duda con el sustituto\",\"description\":\"El arquero de River tiene más chances que 'Willy' de atajar contra Nigeria, el martes.\",\"url\":\"https://www.lagaceta.com.ar/nota/775012/mundial-rusia-2018/caballero-fuera-once-sampaoli-duda-sustituto.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/06/22/775012_20180622201454.jpg\",\"publishedAt\":\"2018-06-22T17:14:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"Alberto Lebbos y familiares de otras víctimas se reunieron con el presidente Macri\",\"description\":\"'Gran reunión de trabajo para reforzar la protección y derechos a víctimas de delitos', expresó el padre de Paulina.\",\"url\":\"https://www.lagaceta.com.ar/nota/775008/actualidad/alberto-lebbos-familiares-otras-victimas-se-reunieron-presidente.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/06/22/775008_20180622193644.jpg\",\"publishedAt\":\"2018-06-22T16:33:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"¡Otro más! Se viralizó un tercer video de un argentino burlándose de una joven rusa\",\"description\":\"Nuevamente, un hincha argentino le pide a una mujer que repita una obscenidad.\",\"url\":\"https://www.lagaceta.com.ar/nota/774989/mundial-rusia-2018/otro-mas-se-viralizo-tercer-video-argentino-burlandose-joven-rusa.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/06/22/774989_20180622185508.png\",\"publishedAt\":\"2018-06-22T16:00:00Z\"},{\"source\":{\"id\":\"la-gaceta\",\"name\":\"La Gaceta\"},\"author\":\"La Gaceta\",\"title\":\"'No me resulta difícil hacerle goles a Argentina', anticipó el goleador de Nigeria\",\"description\":\"Musa, autor del doblete ante Islandia, habló del partido clave que definirá quién avanza a octavos de final del mundial.\",\"url\":\"https://www.lagaceta.com.ar/nota/774975/deportes/no-me-resulta-dificil-hacerle-goles-argentina-anticipo-goleador-nigeria.html\",\"urlToImage\":\"https://img.lagaceta.com.ar/fotos/notas/2018/06/22/774975_20180622161600.jpg\",\"publishedAt\":\"2018-06-22T13:21:00Z\"}]}"
				);
		when(mockNoticia.obtenerNoticias()).thenCallRealMethod();
		ArrayList<Noticia> listaNoticias = new ArrayList<>();
		listaNoticias = mockNoticia.obtenerNoticias();
		Assert.assertEquals(false, listaNoticias.isEmpty());
	}
	
	@Test
	public void conexionAPIClimaInet() {
		Assert.assertEquals(true, clima.existJson());
	}
	
	@Test
	public void jsonValidoClimaInet() {
		Assert.assertEquals(true, clima.jsonValido());
	}
	
	@Test
	public void mockClimaInet() {
		ClimaInet mockClima = mock(ClimaInet.class);
		when(mockClima.obtenerJson()).thenReturn("[{\"LocalObservationDateTime\":\"2018-07-10T00:55:00-03:00\",\"EpochTime\""
				+ ":1531194900,\"WeatherText\":\"Parcialmente nublado\",\"WeatherIcon\":35,\"IsDayTime\":false,\"Temperature\":"
				+ "{\"Metric\":{\"Value\":5.0,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":41.0,\"Unit\":\"F\",\"UnitType"
				+ "\":18}},\"RealFeelTemperature\":{\"Metric\":{\"Value\":5.7,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\""
				+ ":42.0,\"Unit\":\"F\",\"UnitType\":18}},\"RealFeelTemperatureShade\":{\"Metric\":{\"Value\":5.7,\"Unit\":"
				+ "\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":42.0,\"Unit\":\"F\",\"UnitType\":18}},\"RelativeHumidity\":88,"
				+ "\"DewPoint\":{\"Metric\":{\"Value\":3.1,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":38.0,\"Unit\":"
				+ "\"F\",\"UnitType\":18}},\"Wind\":{\"Direction\":{\"Degrees\":135,\"Localized\":\"SE\",\"English\":\"SE\"},\"Speed"
				+ "\":{\"Metric\":{\"Value\":4.3,\"Unit\":\"km/h\",\"UnitType\":7},\"Imperial\":{\"Value\":2.7,\"Unit\":\"mi/h\","
				+ "\"UnitType\":9}}},\"WindGust\":{\"Speed\":{\"Metric\":{\"Value\":5.1,\"Unit\":\"km/h\",\"UnitType\":7},"
				+ "\"Imperial\":{\"Value\":3.2,\"Unit\":\"mi/h\",\"UnitType\":9}}},\"UVIndex\":0,\"UVIndexText\":\"Bajo\","
				+ "\"Visibility\":{\"Metric\":{\"Value\":16.1,\"Unit\":\"km\",\"UnitType\":6},\"Imperial\":{\"Value\":10.0,"
				+ "\"Unit\":\"mi\",\"UnitType\":2}},\"ObstructionsToVisibility\":\"\",\"CloudCover\":37,\"Ceiling\":{\"Metric"
				+ "\":{\"Value\":9144.0,\"Unit\":\"m\",\"UnitType\":5},\"Imperial\":{\"Value\":30000.0,\"Unit\":\"ft\",\"UnitType"
				+ "\":0}},\"Pressure\":{\"Metric\":{\"Value\":1034.0,\"Unit\":\"mb\",\"UnitType\":14},\"Imperial\":{\"Value\":30.53,"
				+ "\"Unit\":\"inHg\",\"UnitType\":12}},\"PressureTendency\":{\"LocalizedText\":\"Constante\",\"Code\":\"S\"},"
				+ "\"Past24HourTemperatureDeparture\":{\"Metric\":{\"Value\":-3.6,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\""
				+ ":{\"Value\":-6.0,\"Unit\":\"F\",\"UnitType\":18}},\"ApparentTemperature\":{\"Metric\":{\"Value\":6.7,\"Unit\""
				+ ":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":44.0,\"Unit\":\"F\",\"UnitType\":18}},\"WindChillTemperature\""
				+ ":{\"Metric\":{\"Value\":3.9,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":39.0,\"Unit\":\"F\",\""
				+ "UnitType\":18}},\"WetBulbTemperature\":{\"Metric\":{\"Value\":4.2,\"Unit\":\"C\",\"UnitType\":17},\"Imperial"
				+ "\":{\"Value\":40.0,\"Unit\":\"F\",\"UnitType\":18}},\"Precip1hr\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\""
				+ ",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"PrecipitationSummary\":"
				+ "{\"Precipitation\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\""
				+ ":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"PastHour\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\""
				+ ":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"Past3Hours\":{\"Metric\":{\"Value\":"
				+ "0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},"
				+ "\"Past6Hours\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,"
				+ "\"Unit\":\"in\",\"UnitType\":1}},\"Past9Hours\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3}"
				+ ",\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"Past12Hours\":{\"Metric\":{\"Value\":0.0,"
				+ "\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}},\"Past18Hours"
				+ "\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":{\"Value\":0.0,\"Unit\":\"in\","
				+ "\"UnitType\":1}},\"Past24Hours\":{\"Metric\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Imperial\":"
				+ "{\"Value\":0.0,\"Unit\":\"in\",\"UnitType\":1}}},\"TemperatureSummary\":{\"Past6HourRange\":{\"Minimum\":"
				+ "{\"Metric\":{\"Value\":5.0,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":41.0,\"Unit\":\"F\","
				+ "\"UnitType\":18}},\"Maximum\":{\"Metric\":{\"Value\":8.1,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":"
				+ "{\"Value\":47.0,\"Unit\":\"F\",\"UnitType\":18}}},\"Past12HourRange\":{\"Minimum\":{\"Metric\":{\"Value"
				+ "\":5.0,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":41.0,\"Unit\":\"F\",\"UnitType\":18}},"
				+ "\"Maximum\":{\"Metric\":{\"Value\":11.8,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":53.0,"
				+ "\"Unit\":\"F\",\"UnitType\":18}}},\"Past24HourRange\":{\"Minimum\":{\"Metric\":{\"Value\":3.6,\"Unit\""
				+ ":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":38.0,\"Unit\":\"F\",\"UnitType\":18}},\"Maximum\":"
				+ "{\"Metric\":{\"Value\":11.8,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":53.0,\"Unit\":"
				+ "\"F\",\"UnitType\":18}}}},\"MobileLink\":\"http://m.accuweather.com/es/ar/san-justo/7626/current-weather/7626\","
				+ "\"Link\":\"http://www.accuweather.com/es/ar/san-justo/7626/current-weather/7626\"}]");

		when(mockClima.obtenerClima()).thenCallRealMethod();
		Clima climaActual = new Clima();
		climaActual = mockClima.obtenerClima();
		Assert.assertEquals(true, !(
				climaActual.getTiempo().equals("") &&
				climaActual.getTemperatura().equals("") &&
				climaActual.getSensacionTermica().equals("") &&
				climaActual.getHumedad().equals("") &&
				climaActual.getVientos().equals("") &&
				climaActual.getNubosidad().equals(""))
				);
	}
	
	@Test
	public void conexionAPICotizaInet() {
		Assert.assertEquals(true, cotiza.existJson());
	}
	
	@Test
	public void jsonValidoCotizaInet() {
		Assert.assertEquals(true, cotiza.jsonValido());
	}
	
	@Test
	public void mockCotizaInet() {
		CotizacionInet mockCotiza = mock(CotizacionInet.class);
		when(mockCotiza.obtenerJson()).thenReturn("{\"meta\":{\"effective_params\":{\"data_set\":\"OANDA\","
				+ "\"base_currencies\":[\"USD\"],\"quote_currencies\":[\"ARS\"]},\"endpoint\":\"spot\",\"request_time\":"
				+ "\"2018-07-10T04:19:24+00:00\",\"skipped_currency_pairs\":[]},\"quotes\":[{\"base_currency\":\"USD\","
				+ "\"quote_currency\":\"ARS\",\"bid\":\"27.9155\",\"ask\":\"27.9240\",\"midpoint\":\"27.9198\"}]}");
		when(mockCotiza.obtenerCotizacion()).thenCallRealMethod();
		ArrayList<Cotizacion> cotizacion = new ArrayList<Cotizacion>();
		cotizacion = mockCotiza.obtenerCotizacion();
		Assert.assertEquals(true, !cotizacion.isEmpty());
	}
}

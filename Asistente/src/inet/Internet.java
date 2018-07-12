package inet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public abstract class Internet {
	private static final String KEY_API_NOTICIAS = "60a89893e3e942729f371604d3579614";
	private static final String KEY_API_CLIMA = "GMhtXHk1MjwYARF58CMA5rFtCrPqCGFI"; //""nGg0fXyka1yuneJpzO7Hdi02CNTEGtgZ";
	private static final String KEY_API_COTIZACION = "Q6jmxBc25BQI35Ude7RgoZaw";
	private static final String KEY_API_GIF = "NMLD71FGce89A8KVyHRKtglfDZILxPaF";
	
	private String key_locale = "7894";
	private String palabraClave = "";
	private int indice;
	private String url;
	private String json;
	
	public static final int NOTICIA = 0;
	public static final int CLIMA = 1;
	public static final int BUSCAR_CIUDAD = 2;
	public static final int COTIZACION = 3;
	public static final int GIF = 4;
	public static final int NINEGAG = 5;
	public static final int BUSQUEDA = 6;
	
	public Internet(final int indice) {
		super();
		System.setProperty("java.net.useSystemProxies", "true");
		this.indice = indice;
		this.url = getUrl();
	}
	
	public Internet(String palabraClave, int indice) {
		super();
		System.setProperty("java.net.useSystemProxies", "true");
		this.palabraClave = palabraClave;
		this.indice = indice;
		
		if(indice == GIF || indice == BUSQUEDA) {
			if(this.palabraClave.equals(""))
				this.palabraClave = "messi";
			else
				this.palabraClave = palabraClave.replaceAll(" ", "_");
		}
		else if(indice == BUSCAR_CIUDAD) {
			this.palabraClave = palabraClave.replaceAll(" ", "+");
		}
		
		this.url = getUrl();
	}
	
	private String getUrl() {
		String [] urls = {
				"https://newsapi.org/v2/top-headlines?sources=la-gaceta&apiKey=" + KEY_API_NOTICIAS,
				"http://dataservice.accuweather.com/currentconditions/v1/" + this.key_locale + "?apikey=" + KEY_API_CLIMA + "&language=es&details=true",
				"http://dataservice.accuweather.com/locations/v1/cities/search?apikey=" + KEY_API_CLIMA + "&q=" + this.palabraClave + "&language=es&details=true",
				"https://web-services.oanda.com/rates/api/v2/rates/spot.json?api_key=" + KEY_API_COTIZACION + "&base=USD&quote=ARS",
				"https://api.giphy.com/v1/gifs/search?api_key=" + KEY_API_GIF + "&q=" + this.palabraClave + "&limit=25&offset=0&rating=G&lang=en",
				"https://9gag.com/search?query=" + this.palabraClave,
				"https://es.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=" + this.palabraClave + "&utf8=8"
		};
		return urls[this.indice];
	}

	public String obtenerJson() {
		this.json = "";
		try {
			URL http = new URL(this.url);
			try {
				InputStream is = http.openStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"),8);
				String line = "";
				StringBuilder str = new StringBuilder("");
				while((line = br.readLine()) != null)
					str.append(line);
				this.json = str.toString();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al leer InputStream\n" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
				//e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "Error, el sitio al que quiere acceder no está disponible\n" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
			//e.printStackTrace();
		}
		return json;
	}

	public void setKey_locale(String key_locale) {
		this.key_locale = key_locale;
		this.url = getUrl();
	}
	
	public boolean existJson() {
		return (!obtenerJson().equals(""));
	}
	
	protected String getPalabraClave() {
		return this.palabraClave;
	}
}

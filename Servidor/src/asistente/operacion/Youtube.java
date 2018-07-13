package asistente.operacion;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import asistente.clase.Pedido;

public class Youtube implements Operacion {

	int last;
	ArrayList<String> lista = new ArrayList<String>();
	String subStringDir;
	private Operacion siguiente;

	@Override
	public String calcular(Pedido pedido) {
		String msg = pedido.getMensaje();
		boolean comando = msg != null && msg.contains("@jenkins") && msg.contains("mostrame videos de:");
		if (comando) {
			msg = msg.replace("@jenkins", "");
			msg = msg.replace("mostrame videos de:", " ");
			msg = msg.trim();
			if (msg != null && msg.length() >= 1) {
				return obtenerEnlace(msg);
			}
		}
		return siguiente.calcular(pedido);
	}

	public String obtenerEnlace(String busqueda) {
		String acumuladorDeTexto = "";
		String direccion = "https://www.youtube.com/results?search_query=" + busqueda.replace(" ", "+");
		try {
			System.setProperty("java.net.useSystemProxies", "true"); // sin esto no anda en la facu
			URL url = new URL(direccion);
			InputStream is = url.openStream();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
				String line;
				while ((line = br.readLine()) != null) {
					last = line.indexOf("data-context-item-id=");
					if (last != -1) {
						acumuladorDeTexto = line.substring(line.indexOf("data-context-item-id=") + 22,
								line.indexOf("data-visibility") - 2);
						//"&yout&
						return "https://www.youtube.com/embed/" + acumuladorDeTexto;
					}

				}

			}
		} catch (Exception e) {
			return "&not&";
		}
		return "&not&";
	}

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;
	}

}

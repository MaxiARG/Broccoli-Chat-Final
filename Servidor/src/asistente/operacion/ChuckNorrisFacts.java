package asistente.operacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dataAccess.DAChuck;
import com.modelo.ChuckNorris;

import asistente.clase.Pedido;

public class ChuckNorrisFacts implements Operacion{

	private Operacion siguiente;
	
//	private String[] v_ChuckNorrisFacts;
	private int contador_v_ChuckNorrisFacts = 0;
	private int contadorChuck = 0;
	private List<ChuckNorris> chuckNorrisFacts;
	
	public ChuckNorrisFacts() {
		/*v_ChuckNorrisFacts = new String[100];
		
		File txt_CNF = new File("ChuckNorrisFacts_txt/ChuckNorrisFacts.txt");
		FileReader r_CNF;
		try {
			r_CNF = new FileReader(txt_CNF);
			BufferedReader b_CNF = new BufferedReader(r_CNF);
			
			String linea = b_CNF.readLine();
			while (linea != null) {
				v_ChuckNorrisFacts[contador_v_ChuckNorrisFacts++] = linea;
				linea = b_CNF.readLine();
			}
			b_CNF.close();
			r_CNF.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		DAChuck daChuck = new DAChuck();
		chuckNorrisFacts = daChuck.obtenerFrases();
		contador_v_ChuckNorrisFacts = chuckNorrisFacts.size();
	}
	
	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}


	@Override
	public String calcular(Pedido pedido) {
		
		String regex = ".*(?:dime|deci|cuent|conta).*(?:chuck|norris).*";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				//String fact = v_ChuckNorrisFacts[contadorChuck++ % contador_v_ChuckNorrisFacts];
				String fact = chuckNorrisFacts.get(contadorChuck++ % contador_v_ChuckNorrisFacts).getFrase();
				return "" + pedido.getNameUsuario() + ", " + fact;
			}
		}
		return siguiente.calcular(pedido);
	}
	
	
}

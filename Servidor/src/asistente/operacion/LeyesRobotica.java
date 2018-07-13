package asistente.operacion;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import asistente.clase.Pedido;

import com.dataAccess.DARobotica;
import com.modelo.Robotica;

public class LeyesRobotica implements Operacion{

	private Operacion siguiente;
	private List<Robotica> listaLeyes;
	public LeyesRobotica(){
		DARobotica daRobotica = new DARobotica();
		listaLeyes = daRobotica.obtenerTodasLasFrase();
	}
	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}


	@Override
	public String calcular(Pedido pedido) {
		
	    String regex = ".* (las 3 leyes|las tres leyes|las leyes|la \\w*) .*(?:de la robotica|ley de la robotica).*";
	    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
	    Matcher matcher = pattern.matcher(pedido.getMensaje());
	    while(matcher.find()) {
	    	if(matcher.matches()) {
	    		
	    		if(matcher.group(1).contains("las 3 leyes") || matcher.group(1).contains("las tres leyes") || matcher.group(1).contains("las leyes") ) {
	    		/*return pedido.getNameUsuario() + ", las tres leyes de la robótica son: \n" +
					"1- Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.\n" + 
					"2- Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.\n" + 
					"3- Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley";
	    		*/return pedido.getNameUsuario() + ", las tres leyes de la robótica son: \n" +
				"1- "+listaLeyes.get(0).getFrase()+"\n" + 
				"2- "+listaLeyes.get(1).getFrase()+"\n" + 
				"3- "+listaLeyes.get(2).getFrase();
    		
	    		}

	    		if(matcher.group(1).contains("la 1") || matcher.group(1).contains("la primer")) {
		    		/*return pedido.getNameUsuario() + ", la primera ley de la robótica es: \n" + 
    				"Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.";*/
	    			return pedido.getNameUsuario() + ", la primera ley de la robótica es: \n" + 
    				listaLeyes.get(0).getFrase();
	    		}

	    		if(matcher.group(1).contains("la 2") || matcher.group(1).contains("la segun")) {
		    		/*return pedido.getNameUsuario() + ", la segundea ley de la robótica es: \n" + 
    				"Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.";*/
	    			return pedido.getNameUsuario() + ", la segunda ley de la robótica es: \n" + 
    				listaLeyes.get(1).getFrase();
	    		}

	    		if(matcher.group(1).contains("la 3") || matcher.group(1).contains("la terc")) {
		    		/*return pedido.getNameUsuario() + ", la tercera ley de la robótica es: \n" + 
    				"Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley";*/
	    			return pedido.getNameUsuario() + ", la tercera ley de la robótica es: \n" + 
    				listaLeyes.get(2).getFrase();
	    		}

	    		return pedido.getNameUsuario() + ", las leyes de la robótica son tres.";
	    	}
	    }
	    
	    return siguiente.calcular(pedido);
	}

}

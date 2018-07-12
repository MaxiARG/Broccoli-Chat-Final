package com.asistente;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Saludar implements Operacion{

	private Operacion siguiente;
	
	@Override
	public String calcular(Pedido pedido) {
		String asist  = pedido.getNameAsistente(); 
		String asistCap = asist.substring(0,1).toUpperCase() + asist.substring(1).toLowerCase();
		//String regex = ".*(?:hola|buen dia|buenos dias|buenas|que tal|tardes|noches|hey).*";
		String regex = "@("+asist+"|"+asistCap+").*(?:hola|buen dia|buenos dias|buenas|buenas tardes|que tal|tardes|noches|buenas noches|hey).*";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				return "¡Hola, " + pedido.getNameUsuario() + "!";
			}
		}
		return siguiente.calcular(pedido);
	}
	

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}



}

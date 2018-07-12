package com.mensajes;

import java.io.Serializable;

public class Mensaje implements Serializable {
	
	private static final long serialVersionUID = 2928832563874494113L;
	private String comando;
	private String informacion;
	private Integer salaID;
	private String emisor;
	
	//#1
	public Mensaje(String _comando,String _informacion,Integer salaID, String emisor) {
		comando = _comando;
		informacion = _informacion;
		this.salaID=salaID;
		this.emisor=emisor;
	}
	
	//#2
	public Mensaje(String comando, String informacion) {
		this.comando = comando;
		this.informacion = informacion;
		
	}
	
	//#3
	public Mensaje(String comando, Integer salaID) {
		this.comando=comando;
		this.salaID=salaID;
	}
	
	//#4
	public Mensaje(String _comando,String _informacion,String emisor) {
		comando = _comando;
		informacion = _informacion;
		this.salaID=-1;
		this.emisor=emisor;
	}
	
	public String getComando() {
		return comando;
	}
	
		
	public String getInformacion() {
		return informacion;
	}
	
	public void imprimirAConsola() {
		
		System.out.println("Comando:"+comando+"|inform:"+informacion+"|SalaID:"+salaID+"|Emisor:"+emisor);
	}
	
	
	
	@Override
	public String toString() {
			return this.informacion;
	}

	public Integer getSalaID() {
		return salaID;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	
	
}

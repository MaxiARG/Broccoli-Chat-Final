package com.mensajes;

import static com.Cliente.Cliente.nombreCliente;

import java.io.Serializable;



public class Mensaje implements Serializable {
	
	private static final long serialVersionUID = 2928832563874494113L;
	String comando;
	String informacion; // es el dato siendo enviado. En principio, solo texto.
	Integer salaID;
	String emisor;
	//#1
	public Mensaje(String _comando,String _informacion, Integer salaID) {
		comando = _comando;
		informacion = _informacion;
		this.salaID=salaID;
	}
	//#2
	public Mensaje(String _comando,String _informacion, Integer salaID, String emisor) {
		comando = _comando;
		informacion = _informacion;
		this.salaID=salaID;
		this.emisor=emisor;
	}
	//#3
	public Mensaje(String comando, String informacion) {
		this.comando = comando;
		this.informacion = informacion;
		this.salaID=-1;
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
	
	public synchronized Integer getSalaID() {
		return salaID;
	}
	
	public void imprimirAConsola() {
		System.out.println("Comando:"+comando+"|inform:"+informacion+"|SalaID:"+salaID+"|Emisor:"+emisor);
	}
	
	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	
	@Override
	public String toString() {
			return this.informacion;
	}
	
	
}

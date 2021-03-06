package com.sala;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import com.cliente.Cliente;
import com.mensajes.Mensaje;
/**
 * Una sala de chat entre almenos 1 clientes. Puede ser publica o privada.
 * La sala se identifica por un nombre o HashTag.
 * @author Maxi
 *
 */
public class Sala {
	
	ArrayList<Cliente> clientesEnSala;
	String nombre; //se lo puede usar como hashTag.
	boolean esPrivada=false; //Todas las salas son publicas por defecto
	private static final AtomicInteger salaIDGenerator = new AtomicInteger(100);
	private Integer salaID;
	private boolean conversacion=false;
	private int cantUsuariosEnConver;
	
	public Sala(String _nombreSala, boolean _esPrivada) {
		nombre=_nombreSala;
		esPrivada= _esPrivada;
		clientesEnSala = new ArrayList<Cliente>();
		salaID = salaIDGenerator.getAndIncrement();
	}
	public Sala(String nombre) {
		this.nombre = nombre;
		clientesEnSala = new ArrayList<Cliente>();
		this.salaID = -1;
		
	}

	public void meterCliente(Cliente cli) {
		if (clientesEnSala.contains(cli))
			return; // INFORMAR DE USUARIO REPETIDO EN SALA?
		clientesEnSala.add(cli);
	}
	
	public int sacarCliente(Cliente cli) {
		if (!clientesEnSala.contains(cli))
			return 0;
		clientesEnSala.remove(cli);
		return 1;
	}
	
	public void sacarCliente(String cliente){
		for(int i  = 0, sizeClientes = clientesEnSala.size(); i<sizeClientes ;i++){
			Cliente clienteActual =  clientesEnSala.get(i);
			if(clienteActual.getNombre().equals(cliente)){
				clientesEnSala.remove(i);
				break;
			}
		}
	}
	
	public void enviarMensaje(Mensaje mensaje) {
		for(Cliente c:clientesEnSala) {
			c.enviarMensaje(mensaje);
		}
	}
	
	public void setConversacion(boolean valor){
		cantUsuariosEnConver=1;
		this.conversacion = valor;
	}
	
	public boolean isConversacion(){
		return this.conversacion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public String getNombre() {
		return nombre;
	}

	public boolean esPrivada() {
		return esPrivada;
	}

	public Integer getSalaID() {
		return salaID;
	}

	public ArrayList<Cliente> getClientesEnSala() {
		return clientesEnSala;
	}
	public boolean isEsPrivada() {
		return esPrivada;
	}
	public void setEsPrivada(boolean esPrivada) {
		this.esPrivada = esPrivada;
	}
	public int getCantUsuariosEnConver() {
		return cantUsuariosEnConver;
	}
	public void setCantUsuariosEnConver(int valor) {
		if(valor==-1){
			cantUsuariosEnConver-=1;
		}else{
			if(!(cantUsuariosEnConver>=2))
				cantUsuariosEnConver+=1;
		}
		
	}
	
}

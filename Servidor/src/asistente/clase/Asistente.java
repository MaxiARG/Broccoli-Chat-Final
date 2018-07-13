package asistente.clase;

import asistente.database.HSQL;
import asistente.operacion.Interpretacion;

public class Asistente{
	
	private static  String USUARIO = "delucas";
	
	private String nameAsistente;
	private String nameUsuario = "@"+USUARIO;
	private Interpretacion interpretacion;
	private HSQL db;
	
	public Asistente(String nameAsistente) {
		this.nameAsistente = "@"+nameAsistente;
		interpretacion = new Interpretacion();
		this.db = new HSQL();
	}
	
	public Asistente(String nombreCliente, String nameAsistente) {
		this.nameAsistente = "@"+nameAsistente;
		USUARIO=nombreCliente;
		interpretacion = new Interpretacion();
		this.db = new HSQL();
	}
	
	public String escuchar(String mensaje) {
		Pedido pedido = new Pedido(mensaje, nameUsuario, nameAsistente, db);
		return interpretacion.calcular(pedido);
	}
	
	public void setCliente(String nombreCliente){
		USUARIO = nombreCliente;
		this.nameUsuario = "@"+USUARIO;
	}
	
}

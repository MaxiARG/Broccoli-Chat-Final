package asistente.operacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.dataAccess.DAEvento;
import com.modelo.CampoEvento;

import asistente.util.Fecha;

public class Evento implements Comparable<Evento> {
	private int id;
	private String descripcion;
	private Fecha fecha;
	private String usuario;
	private List<CampoEvento> eventos;
	
	public Evento() { }
	
	
	public Evento(Fecha fecha, String descripcion, String usuario) {
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.setUsuario(usuario);
	}
	
	/*public Evento(int id, Fecha fecha, String descripcion)
	{
		this(fecha,descripcion);
		this.id=id;
	}*/
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public void setFecha(Fecha fecha)
	{
		this.fecha=fecha;
	}
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion=descripcion;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getDescripcion()
	{
		return this.descripcion;
	}
	
	public Fecha getFecha()
	{
		return this.fecha;
	}
	
	//@SuppressWarnings({ "deprecation", "finally" })
	public CampoEvento proximoEvento()
	{
		/*ArrayList<Evento> eventos = new ArrayList<Evento>();

		Scanner sc;
		try {
			sc = new Scanner(new File("eventos.dat"));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				int dia = Integer.parseInt(linea.substring(0, linea.indexOf("/")));
				linea = linea.substring(linea.indexOf("/") + 1);
				int mes = Integer.parseInt(linea.substring(0, linea.indexOf("/")));
				linea = linea.substring(linea.indexOf("/") + 1);
				int año = Integer.parseInt(linea.substring(0, 4));
				linea = linea.substring(5);
				int hora = Integer.parseInt(linea.substring(0, linea.indexOf(":")));
				linea = linea.substring(linea.indexOf(":") + 1);
				int min = Integer.parseInt(linea.substring(0, linea.indexOf(":")));
				linea = linea.substring(linea.indexOf(":") + 1);
				int seg = Integer.parseInt(linea.substring(0, 2).trim());
				linea = linea.substring(2);
				String desc = linea;
				eventos.add(new Evento(
							new Fecha(año,mes,dia,hora,min,seg, 'a'),
							desc
						));
			}

			Collections.sort(eventos);
			
			sc.close();
									
			return eventos.get(0);
		} catch (FileNotFoundException e) {
			return null;
		}*/
		DAEvento daEvento = new DAEvento();
		eventos = daEvento.obtenerEventos(getUsuario());
		Collections.sort(eventos);
		if(!eventos.isEmpty())
		return eventos.get(0);
		return null;
	}
	
	public boolean guardarEvento()
	{
	/*	File path_event = new File("eventos.dat");
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(path_event, true);
            pw = new PrintWriter(fichero);
            
            System.out.println(this.toString());
            String linea=toString();
            
            pw.println(linea);

        } catch (Exception e) {
        	return false;
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
        	   return false;
           }
        }*/
		DAEvento daEvento = new DAEvento();
		CampoEvento nuevoCampo = new CampoEvento();
		nuevoCampo.setDescripcion(descripcion);
		nuevoCampo.setFecha(fecha);
		nuevoCampo.setFechaString(fecha.fechaToString("DD/MM/AAAA") + " " +this.fecha.hora("HH:MM:SS"));
		nuevoCampo.setUsuario(getUsuario());
		daEvento.agregarEvento(nuevoCampo);
		return true;

	}
	@Override
	public String toString()
	{
	
		return this.fecha.fechaToString("DD/MM/AAAA") + " "+ this.fecha.hora("HH:MM:SS") + " " + this.descripcion;
	}

	@Override
	public int compareTo(Evento o) {
		return this.fecha.compareTo(o.fecha);
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
package com.modelo;

import java.text.ParseException;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import asistente.util.Fecha;

public class CampoEvento implements Comparable<CampoEvento>{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@TableGenerator(name="sqlite", table="sqlite_sequence",
    pkColumnName="name", valueColumnName="seq",
    pkColumnValue="sqliteTestTable")
	
	private int id;
	
	private Fecha fecha;
	private String descripcion;
	private String fechaString;
	private String usuario;
	
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

	@Override
	public int compareTo(CampoEvento o) {
		return fecha.compareTo(o.fecha);
	}

	public String getFechaString() {
		return fechaString;
	}

	public void setFechaString(String fechaString) {
		try {
			fecha = new Fecha(fechaString,"dd/MM/yyyy HH:mm:ss");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.fechaString = fechaString;
	}
	@Override
	public String toString()
	{
	
		return this.fecha.fechaToString("DD/MM/AAAA") + " "+ this.fecha.hora("HH:MM:SS") + " " + this.descripcion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}

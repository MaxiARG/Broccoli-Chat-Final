package com.db;


/**
 * El Usuario es con lo que cada persona se registra. Nombre y Password. No sabe nada de Sockets. <b>Solo se usa para Login</b>.
 * Este Usuario luego se convierte en Cliente del chat.
 * @author Maxi
 *
 */
public class Usuario {
	
	int ID;
	
	String nombre;
	
	String password;
	
	public Usuario() {}

	
	public Usuario(int _ID, String usuario, String password) {
		ID=_ID;
		this.nombre = usuario;
		this.password = password;
	}

	public Usuario(String usuario, String password) {
		this.nombre = usuario;
		this.password = password;
		ID=-1;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Usuario other = (Usuario) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Usuario [ID=" + ID + ", usuario=" + nombre + ", password=" + password + "]";
	}

}

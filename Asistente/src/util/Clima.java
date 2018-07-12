package util;

public class Clima {
	private String tiempo;
	private String temperatura;
	private String sensacionTermica;
	private String humedad;
	private String vientos;
	private String nubosidad;

	public Clima() {
		
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getSensacionTermica() {
		return sensacionTermica;
	}

	public void setSensacionTermica(String sensacionTermica) {
		this.sensacionTermica = sensacionTermica;
	}

	public String getHumedad() {
		return humedad;
	}

	public void setHumedad(String humedad) {
		this.humedad = humedad;
	}

	public String getVientos() {
		return vientos;
	}

	public void setVientos(String vientos) {
		this.vientos = vientos;
	}

	public String getNubosidad() {
		return nubosidad;
	}

	public void setNubosidad(String nubosidad) {
		this.nubosidad = nubosidad;
	}

	@Override
	public String toString() {
		return "Clima [tiempo=" + tiempo + ", temperatura=" + temperatura + ", sensacionTermica=" + sensacionTermica
				+ ", humedad=" + humedad + ", vientos=" + vientos + ", nubosidad=" + nubosidad + "]";
	}
	
	
}

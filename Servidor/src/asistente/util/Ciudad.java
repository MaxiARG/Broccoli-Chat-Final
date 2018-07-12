package asistente.util;

public class Ciudad {
	private String keyLocation;
	private String nombre;
	private String region;
	private String pais;
	private String provincia;
	
	public Ciudad() {
		
	}
	public String getKeyLocation() {
		return keyLocation;
	}
	public void setKeyLocation(String keyLocation) {
		this.keyLocation = keyLocation;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Override
	public String toString() {
		return "Ciudad [keyLocation=" + keyLocation + ", nombre=" + nombre + ", region=" + region + ", pais=" + pais
				+ ", provincia=" + provincia + "]";
	}
	
}

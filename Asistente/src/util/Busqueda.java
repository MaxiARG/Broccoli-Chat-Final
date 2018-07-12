package util;

public class Busqueda {
	private String extracto;
	private String url;
	public Busqueda(String extracto, String url) {
		this.extracto = extracto;
		this.url = url;
	}
	public String getExtracto() {
		return extracto;
	}
	public void setExtracto(String extracto) {
		this.extracto = extracto;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Busqueda [extracto=" + extracto + ", url=" + url + "]";
	}
	
}

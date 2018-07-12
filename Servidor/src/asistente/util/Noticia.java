package asistente.util;

public class Noticia {
	private String autor;
	private String titulo;
	private String descripcion;
	private String url;
	private String imagen;
	private String fecha;
	
	public Noticia() {
		super();
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Noticia [autor=" + autor + ", titulo=" + titulo + ", descripcion=" + descripcion + ", url=" + url
				+ ", imagen=" + imagen + ", fecha=" + fecha + "]";
	}
	
	
}

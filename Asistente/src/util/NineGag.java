package util;

public class NineGag {
	private String [] categorias = {"messi","football",
			"simpsons","starwars","cars","funny",
			"congratulations","angry","cold","susto","thanks","what it is"};
	
	private String categoria;
	private String url;
	
	public NineGag(String url) {
		this.url = url;
	}
	
	public NineGag() {
		int num = ( (int)(Math.random( )*this.categorias.length));
		this.categoria = this.categorias[num];
	}
	
	public String getCategoria() {
		return this.categoria;
	}

	public String getUrlImg() {
		return categoria;
	}

	public void setUrlImg(String urlImg) {
		this.categoria = urlImg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "NineGag [url=" + url + "]";
	}
	
}

package asistente.util;

public class Cotizacion {
	private String monedaDestino;
	private String compra;
	private String venta;
	
	public Cotizacion() {
		
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public String getCompra() {
		return compra;
	}

	public void setCompra(String compra) {
		this.compra = compra;
	}

	public String getVenta() {
		return venta;
	}

	public void setVenta(String venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Cotizacion [monedaDestino=" + monedaDestino + ", compra=" + compra + ", venta=" + venta + "]";
	}
	
	
}

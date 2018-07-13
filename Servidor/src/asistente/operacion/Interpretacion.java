package asistente.operacion;

import asistente.clase.Pedido;

public class Interpretacion implements Operacion{

	private Operacion siguiente;

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;	
	}

	@Override
	public String calcular(Pedido pedido) {	
		return siguiente.calcular(pedido);
	}
	
	public Interpretacion() {
		
		Operacion NoDirigidoAsistente = new NoDirigidoAsistente();
		Operacion Saludar = new Saludar(); //1
		Operacion Agradecer = new Agradecer(); //2
		Operacion FechaActual = new FechaActual();
		Operacion FechaNoActual = new FechaNoActual();
		Operacion Calculo = new Calculo();
		Operacion Juego = new Juego();
		Operacion Convertir = new Convertir();
		Operacion LeyesRobotica = new LeyesRobotica();
		Operacion ChuckNorrisFacts = new ChuckNorrisFacts();
		Operacion Deuda = new Deuda();
		Operacion RecordarEventos = new RecordarEventos(); //Punto 16
		Operacion Busqueda = new Busqueda(); //20
		Operacion Noticias= new Noticias(); //17
		Operacion Default = new Default();
		
		this.siguiente(NoDirigidoAsistente);
		NoDirigidoAsistente.siguiente(Saludar);
		Saludar.siguiente(Agradecer);
		Agradecer.siguiente(FechaActual);
		FechaActual.siguiente(FechaNoActual);		
		FechaNoActual.siguiente(Calculo);
		Calculo.siguiente(Juego);
		Juego.siguiente(Convertir);
		Convertir.siguiente(LeyesRobotica);
		LeyesRobotica.siguiente(ChuckNorrisFacts);
		ChuckNorrisFacts.siguiente(Deuda);
		Deuda.siguiente(RecordarEventos);
		RecordarEventos.siguiente(Busqueda);
		Busqueda.siguiente(Noticias);
		Noticias.siguiente(Default);
		
		

		
	}

}

package test;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import inet.BusquedaInet;
import inet.Internet;
import util.Busqueda;

public class RF20Tests {

	BusquedaInet busquedaInet;
	
	@Before
	public void setup() {
		busquedaInet = new BusquedaInet("", Internet.BUSQUEDA);
	}
	
	@Test
	public void conexionAPIBusquedaInet() {
		Assert.assertEquals(true, busquedaInet.existJson());
	}
	
	@Test
	public void jsonValidoBusquedaInet() {
		Assert.assertEquals(true, busquedaInet.jsonValido());
	}
	
	@Test
	public void hayResultados() {
		ArrayList<Busqueda> listaBusquedaInet = new ArrayList<>();
		listaBusquedaInet = busquedaInet.obtenerBusqueda();
		Assert.assertEquals(true, !listaBusquedaInet.isEmpty());
	}

}

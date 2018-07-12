package asistente.test;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import asistente.inet.Internet;
import asistente.inet.NineGagInet;
import asistente.util.NineGag;


public class RF18Tests {
	NineGag nine;
	NineGagInet nineInet;
	NineGagInet nineInetTestLista;
	
	@Before
	public void setup() {
		nine = new NineGag();
		nineInet = new NineGagInet(nine.getCategoria(), Internet.NINEGAG);
		nineInetTestLista = new NineGagInet("messi", Internet.NINEGAG);
	}
	
	@Test
	public void conexionAPINineInet() {
		Assert.assertEquals(true, nineInet.existJson());
	}
	
	@Test
	public void jsonValidoNineInet() {
		Assert.assertEquals(true, nineInet.jsonValido());
	}
	
	@Test
	public void hayDirecciones() {
		ArrayList<NineGag> listaImgsNine = new ArrayList<>();
		listaImgsNine = nineInetTestLista.obtenerImgNineGag();
		Assert.assertEquals(true, !listaImgsNine.isEmpty());
	}
}

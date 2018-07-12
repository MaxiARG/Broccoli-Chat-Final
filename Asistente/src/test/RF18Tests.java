package test;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import inet.Internet;
import inet.NineGagInet;
import util.NineGag;


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

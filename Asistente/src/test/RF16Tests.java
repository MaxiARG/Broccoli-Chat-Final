package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clase.Asistente;

public class RF16Tests {

	public final static String USUARIO = "delucas";

	Asistente jenkins;

	@Before
	public void setup() {
		jenkins = new Asistente("jenkins");
	}

	@Test
	public void PruebaEvento() {
		// El archivo donde agenda los eventos es eventos.dat
		
		Assert.assertEquals(
				"@delucas Evento agregado",
				jenkins.escuchar("@jenkins agenda este evento: Entrega de TP 12 de noviembre de 2018 ")
			);
		
		Assert.assertEquals(
				"@delucas Evento agregado",
				jenkins.escuchar("@jenkins agenda este evento: Parcial de base de datos 12 de mayo de 2019 ")
			);
		
		Assert.assertEquals(
				"@delucas Evento agregado",
				jenkins.escuchar("@jenkins agenda este evento: Cumpleaños de Marcos 21 de julio de 2018 ")
			);
	
		Assert.assertEquals(
					"@delucas El próximo evento es: 21/7/2018 0:0:0 cumpleaños de marcos y faltan 28 días",
					jenkins.escuchar("@jenkins cual es mi proximo evento?")
				);
	}

}

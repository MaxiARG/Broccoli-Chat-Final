package asistente.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import asistente.clase.Asistente;
public class RF021Tests {
    
public final static String USUARIO = "delucas"; 
    
    Asistente jenkins;
    
    @Before
    public void setup() {
      jenkins = new Asistente("delucas", "jenkins");
    }
    
    @Test
    public void youTubeRick() {
      String[] mensajes = {
          "@jenkins mostrame videos de: Rick Astley"
      };
      for (String mensaje : mensajes) {
        Assert.assertEquals(
            "https://www.youtube.com/embed/dQw4w9WgXcQ",
            jenkins.escuchar(mensaje)
        );
      }
    }
    
    @Test
    public void youTubeLuismi() {
      String[] mensajes = {
          "@jenkins mostrame videos de: Luis Miguel"
      };
      for (String mensaje : mensajes) {
        Assert.assertEquals(
            "https://www.youtube.com/embed/lzZwyOy-uSU",
            jenkins.escuchar(mensaje)
        );
      }
    }
    
    @Test
    public void youTubeMessi() {
      String[] mensajes = {
          "@jenkins mostrame videos de: Messi"
      };
      for (String mensaje : mensajes) {
        Assert.assertEquals(
            "https://www.youtube.com/embed/bsYHDTfzLZ8",
            jenkins.escuchar(mensaje)
        );
      }
    }
}

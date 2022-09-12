package arco1;

import org.junit.Assert;
import org.junit.Test;

public class Prueba {

    @Test
    public void pruebaGol() {
	String r = PateandoAlArco.arco(2, 3);
	Assert.assertEquals("GOL", r);
    }
    
    @Test
    public void pruebaPalo() {
	String r = PateandoAlArco.arco(0, 100);
	Assert.assertEquals("PALO", r);
    }
    
    @Test
    public void pruebaAfuera() {
	String r = PateandoAlArco.arco(1000, 1000);
	Assert.assertEquals("AFUERA", r);
    }
}

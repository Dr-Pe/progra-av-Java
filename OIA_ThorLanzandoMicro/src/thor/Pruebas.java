package thor;

import org.junit.Test;
import org.junit.Assert;

public class Pruebas {

    @Test
    public void pruebaPersonaje() {
	
	Personaje thor = new Personaje(14, 4);
	Objeto silla = new Objeto(5);
	Objeto microondas = new Objeto(11);
	
	Assert.assertEquals(11.2, thor.calcularDistancia(silla), 0.001);
	Assert.assertEquals(5.09, thor.calcularDistancia(microondas), 0.001);
    }
    
    @Test
    public void pruebaThor() {
	
	int r = Lanzamiento.thor("test_files/thor.in");
	Assert.assertEquals(4, r);
    }
}

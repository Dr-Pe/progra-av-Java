package thor;

import org.junit.Test;
import org.junit.Assert;

public class Pruebas {

    @Test
    public void pruebaLanzamiento() {
	
	Personaje thor = new Personaje(14, 4);
	Objeto silla = new Objeto(5);
	Objeto microondas = new Objeto(11);
	
	Assert.assertEquals(11.2, Lanzamiento.calcularDistancia(thor, silla), 0.001);
	Assert.assertEquals(5.09, Lanzamiento.calcularDistancia(thor, microondas), 0.001);
    }
    
    @Test
    public void pruebaThor() {
	
	int r = Lanzamiento.thor("test_files/thor.in");
	Assert.assertEquals(4, r);
    }
}

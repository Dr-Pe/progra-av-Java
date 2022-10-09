package ejercicio2;

import org.junit.Assert;
import org.junit.Test;

public class PruebasJunit {

    private int[] arr;

    @Test
    public void siEsPermutacion() {
	arr = new int[] { 1, 3, 0, 4, 2 };

	Assert.assertTrue(ArreglosEnteros.esPermutacion(arr));
    }

    @Test
    public void noEsPermutacionPorRepitencias() {
	arr = new int[] { 1, 1, 0, 4, 2 };

	Assert.assertFalse(ArreglosEnteros.esPermutacion(arr));
    }

    @Test
    public void noEsPermutacionPorFueraDeLimite() {
	arr = new int[] { 1, 3, 0, 8, 2 };

	Assert.assertFalse(ArreglosEnteros.esPermutacion(arr));
    }

}

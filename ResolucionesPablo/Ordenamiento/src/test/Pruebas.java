package test;

import org.junit.Assert;
import org.junit.Test;
import algoritmos.OrdenEnteros;

public class Pruebas {

    public static void main(String[] args) {

	int arr[] = new int[] { 2, 2, 1, 4, 3, 3, 5 };
	OrdenEnteros.quicksort(arr);

	for(int i = 0; i < arr.length; i++)
	    System.out.println(arr[i]);

    }

    @Test
    public void pruebaQuicksortSimple() {

	int arr[] = new int[] { 2, 1, 4, 3, 5 };
	Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5 },
				OrdenEnteros.quicksort(arr));
    }

    @Test
    public void pruebaQuicksortRepetidos() {

	int arr[] = new int[] { 2, 2, 1, 4, 3, 3, 5 };
	Assert.assertArrayEquals(new int[] { 1, 2, 2, 3, 3, 4, 5 },
				OrdenEnteros.quicksort(arr));
    }

    @Test
    public void pruebaQuicksortVacio() {

	int arr[] = new int[] { };
	Assert.assertArrayEquals(new int[] { }, OrdenEnteros.quicksort(arr));
    }

}

package test;

import org.junit.Assert;
import org.junit.Test;
import algoritmos.OrdenEnteros;

public class Pruebas {

    private static final int[] ARRAY_SIMPLE = new int[] { 2, 1, 4, 3, 5 };
    private static final int[] ARRAY_SIMPLE_ORD = new int[] { 1, 2, 3, 4, 5 };
    private static final int[] ARRAY_REP = new int[] { 2, 2, 1, 4, 3, 3, 5 };
    private static final int[] ARRAY_REP_ORD = new int[] { 1, 2, 2, 3, 3, 4, 5 };


    public static void main(String[] args) {

	int arr[] = ARRAY_SIMPLE;
	OrdenEnteros.mergesort(arr);

	for(int i = 0; i < arr.length; i++)
	    System.out.println(arr[i]);

    }
    
    /*
     * Mergesort
     */
    
    @Test
    public void pruebaMergesortSimple() {

	int arr[] = ARRAY_SIMPLE;
	Assert.assertArrayEquals(ARRAY_SIMPLE_ORD, OrdenEnteros.mergesort(arr));
    }

    @Test
    public void pruebaMergesortRepetidos() {

	int arr[] = ARRAY_REP;
	Assert.assertArrayEquals(ARRAY_REP_ORD, OrdenEnteros.mergesort(arr));
    }

    @Test
    public void pruebaMergesortVacio() {

	int arr[] = new int[] {};
	Assert.assertArrayEquals(new int[] {}, OrdenEnteros.mergesort(arr));
    }
    
    /*
     * Quicksort
     */

    @Test
    public void pruebaQuicksortSimple() {

	int arr[] = ARRAY_SIMPLE;
	Assert.assertArrayEquals(ARRAY_SIMPLE_ORD, OrdenEnteros.quicksort(arr));
    }

    @Test
    public void pruebaQuicksortRepetidos() {

	int arr[] = ARRAY_REP;
	Assert.assertArrayEquals(ARRAY_REP_ORD, OrdenEnteros.quicksort(arr));
    }

    @Test
    public void pruebaQuicksortVacio() {

	int arr[] = new int[] {};
	Assert.assertArrayEquals(new int[] {}, OrdenEnteros.quicksort(arr));
    }
    
    /*
     * Insertionsort
     */
    
    @Test
    public void pruebaInsertionsortSimple() {

	int arr[] = ARRAY_SIMPLE;
	Assert.assertArrayEquals(ARRAY_SIMPLE_ORD, OrdenEnteros.insertionsort(arr));
    }

    @Test
    public void pruebaInsertionsortRepetidos() {

	int arr[] = ARRAY_REP;
	Assert.assertArrayEquals(ARRAY_REP_ORD, OrdenEnteros.insertionsort(arr));
    }

    @Test
    public void pruebaInsertionsortVacio() {

	int arr[] = new int[] {};
	Assert.assertArrayEquals(new int[] {}, OrdenEnteros.insertionsort(arr));
    }

}

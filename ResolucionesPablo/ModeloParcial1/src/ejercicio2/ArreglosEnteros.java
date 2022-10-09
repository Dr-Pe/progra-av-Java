package ejercicio2;

import java.util.HashSet;
import java.util.Set;

public class ArreglosEnteros {

    public static void main(String[] args) {

	int[] arr = new int[] { 1, 3, 0, 4, 2 };

	System.out.println(esPermutacion(arr));
    }

    public static boolean esPermutacion(int[] arr) {
	/*
	 * Complejidad de O(n), ya que itera una sola vez sobre el array ejecutando
	 * instrucciones O(1) - incluso el set.add() es de complejidad constante, ya que
	 * es un HashSet.
	 */

	Set<Integer> set = new HashSet<Integer>();

	for(int i : arr) {
	    if(i < 0 || i > arr.length - 1)
		return false;
	    else if(!set.add(i))
		return false;
	}

	return true;
    }

}

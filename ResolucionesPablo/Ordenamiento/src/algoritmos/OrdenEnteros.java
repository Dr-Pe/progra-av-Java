package algoritmos;

public class OrdenEnteros {

    public static int[] mergesort(int[] arr) {
	return arr;
    }
    
    public static int[] quicksort(int[] arr) {
	// Wrapper con la implementacion de quicksort qeu devuelve el array ya ordenado
	// (a pesar de ordenar en el lugar) para permitir concatenacion de funciones.
	// Quicksort no es estable.

	quicksortInterno(arr, 0, arr.length - 1);
	return arr;
    }

    private static void quicksortInterno(int[] arr, int ini, int fin) {
	// Algoritmo de quicksort con ultimo elemento como pivot

	if(ini >= fin)
	    return;

	int pi = particionar(arr, ini, fin);
	quicksortInterno(arr, ini, pi - 1);
	quicksortInterno(arr, pi + 1, fin);
    }

    private static int particionar(int[] arr, int ini, int fin) {
	// Utilidad de particion para quicksort con ultimo elemento como pivot

	int pivot = arr[fin];
	int iMenor = ini - 1;

	for(int j = ini; j < fin; j++) {
	    if(arr[j] < pivot)
		iMenor++;
	}
	intercambiar(arr, iMenor + 1, fin);

	return iMenor + 1;
    }

    public static int[] insertionsort(int[] arr) {
	// Algoritmo de insertion-sort

	for(int i = 1; i < arr.length; i++) {
	    int j = i - 1;
	    while(j > 0 && arr[j] < arr[j - 1]) {
		intercambiar(arr, j, j - 1);
		j--;
	    }
	}

	return arr;
    }

    private static void intercambiar(int[] arr, int idxA, int idxB) {
	// Utilidad para intercambiar dos elementos A y B en un array

	int aux = arr[idxA];
	arr[idxA] = arr[idxB];
	arr[idxB] = aux;
    }

}

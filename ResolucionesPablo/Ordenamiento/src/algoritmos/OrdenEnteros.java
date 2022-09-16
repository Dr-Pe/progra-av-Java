package algoritmos;

public class OrdenEnteros {

    public static int[] mergesort(int[] arr) {
	// Wrapper con la implementacion de merge-sort

	mergesortInterno(arr, 0, arr.length - 1);

	return arr;
    }

    private static void mergesortInterno(int[] arr, int ini, int fin) {
	// Algoritmo recursivo de merge-sort
	
	if(ini >= fin)
	    return;

	int mid = (ini + fin) / 2;
	mergesortInterno(arr, ini, mid);
	mergesortInterno(arr, mid + 1, fin);
	fusionar(arr, ini, mid, fin);
    }

    private static void fusionar(int[] arr, int ini, int mid, int fin) {
	// Utilidad para merge sort que fusiona dos sub-arrays de arr de manera ordenada
	
	int[] izq = new int[mid - ini + 1];
	int[] der = new int[fin - mid];

	for(int i = 0; i < izq.length; i++)
	    izq[i] = arr[ini + i];
	for(int i = 0; i < der.length; i++)
	    der[i] = arr[mid + i + 1];

	int i = ini;
	int j = 0;
	int z = 0;

	while(j < izq.length && z < der.length) {
	    if(izq[j] < der[z]) {
		arr[i] = izq[j];
		j++;
	    } else {
		arr[i] = der[z];
		z++;
	    }
	    i++;
	}

	while(j < izq.length) {
	    arr[i] = izq[j];
	    j++;
	    i++;
	}

	while(z < der.length) {
	    arr[i] = der[z];
	    z++;
	    i++;
	}

    }

    public static int[] quicksort(int[] arr) {
	// Wrapper con la implementacion de quicksort que devuelve el array ya ordenado
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

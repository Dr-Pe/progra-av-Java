package tipeo;

public class EjercicioErroresDeTipeo {

    public static void main(String[] args) {

	int r = procesador("Texto Estamos pintando!", "ostanT!Em inpados");
	System.out.println(r);

    }

    public static int procesador(String texto, String prueba) {
	int intercambios = 0;

	char[] arrayTexto = texto.toCharArray();
	char[] arrayPrueba = prueba.toCharArray();

	for(int i = 0; i < prueba.length(); i++) {
	    int j = i;
	    while(j < prueba.length() && arrayTexto[j] > arrayPrueba[j]) {
		intercambiar(arrayPrueba, j, j + 1);
		intercambios++;
		j++;
	    }
	}
	System.out.println(arrayPrueba);
	return intercambios;
    }

    private static void intercambiar(char[] array, int idxA, int idxB) {
	char aux = array[idxA];
	array[idxA] = array[idxB];
	array[idxB] = aux;
    }

}

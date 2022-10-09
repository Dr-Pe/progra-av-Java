package oia_erroresDeTipeo;

public class Dactilografo {

	public int revisar(String original, String test) {
		char[] texto = original.toCharArray();
		char[] prueba = test.toCharArray();

		int intercambios = 0;

		// O(n^2)
		// mejor caso O(n)
		for (int i = 0; i < texto.length; i++) {
			if (texto[i] != prueba[i]) {
				for (int j = i + 1; j < texto.length; j++) {
					if (texto[i] == prueba[j]) {
						intercambios += intercambiarEntre(prueba, i, j);
						j = texto.length;
					}
				}
			}

		}
		return intercambios;
	}

	public int intercambiarEntre(char[] prueba, int idx1, int idx2) {

		int intercambios = 0;
		while (idx2 > idx1) {
			intercambiar(prueba, idx2 - 1, idx2);
			intercambios++;
			idx2--;
		}

		return intercambios;
	}

	public void intercambiar(char[] prueba, int idx1, int idx2) {
		char aux = prueba[idx1];
		prueba[idx1] = prueba[idx2];
		prueba[idx2] = aux;

	}
}
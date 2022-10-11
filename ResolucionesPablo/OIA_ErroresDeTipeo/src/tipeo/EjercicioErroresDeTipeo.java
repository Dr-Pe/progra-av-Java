package tipeo;

public class EjercicioErroresDeTipeo {

    public static void main(String[] args) {

	int r = procesador("Estamos pintando!", "ostant!Em inpados");
	System.out.println(r);

    }

    public static Integer procesador(String texto, String prueba) {
	int intercambios = 0;

	Cadena cadTexto = new Cadena(texto);
	Cadena cadPrueba = new Cadena(prueba);

	for(int i = 0; i < prueba.length(); i++) {
	    char c = cadTexto.get(i);	       // Letra a acomodar
	    Integer idxC = cadPrueba.indice(c, i); // Posicion de esa letra en el array desordenado (a partir de idx = i)
	    if(idxC == null)
		return null;
	    while(idxC > 0 && idxC != i) {
		cadPrueba.intercambiar(idxC, idxC - 1);
		intercambios++;
		idxC--;
	    }
	}
	//	System.out.println(cadPrueba);
	return intercambios;
    }

}

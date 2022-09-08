/*
 * El package se llama robotito_v1 porque quizá luego implemente una v2 donde Direccion se haga cargo del reapuntado
 */

package robotito_v1;

public class Main {

    public static void main(String[] args) {

	String input = "HAHAAHHAHH";
	int r = caminoAlSur(input);
	System.out.println(r);
    }

    private static int caminoAlSur(String instrucciones) {

	Robot bot = new Robot();
	char[] caracteres = instrucciones.toCharArray();

	for(int i = 0; i < instrucciones.length(); i++) {
	    int nuevaDir = (caracteres[i] == 'H') ? bot.moverHorario()
				    : bot.moverAntihorario();
	    if(nuevaDir == Direccion.SUR)
		return i + 1;
	}
	// "else"
	return -1;
    }

}

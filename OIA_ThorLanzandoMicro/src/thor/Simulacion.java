package thor;

public class Simulacion {

    public static void main(String args[]) {
	Lanzamiento thor = new Lanzamiento();

	thor.leer(args[0]);
	thor.resolver();
	thor.escribir();
    }

}
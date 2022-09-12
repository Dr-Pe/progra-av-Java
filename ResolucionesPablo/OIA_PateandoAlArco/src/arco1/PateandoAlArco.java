package arco1;

import geom.Punto;
import geom.Rectangulo;

public class PateandoAlArco {

    private static final int ANCHO = 732;
    private static final int ALTO = 232;

    
    public static String arco(int x, int y) {
	
	Punto tiro = new Punto(x, y);
	Rectangulo arco = new Rectangulo(ANCHO, ALTO);
	
	if(arco.contieneA(tiro))
	    return "GOL";
	else if(arco.contieneAInclusivo(tiro))
	    return "PALO";
	else
	    return "AFUERA";
    }
}

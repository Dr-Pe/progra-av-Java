package thor;

import java.util.ArrayList;
import java.util.List;

public class Lanzamiento {

    public static int thor(String path) {
	// Recibe la direccion del archivo .in y devuelve la cantidad de lanzamientos
	// exitosos. Complejidad O(n**2)

	Archivo thorIn = new Archivo(path);
	List<Personaje> pjs = new ArrayList<Personaje>();
	List<Objeto> objs = new ArrayList<Objeto>();

	float d = thorIn.cargarArchivo(pjs, objs);
	int cantExitos = 0;

	// Función principal
	for(Personaje pj:pjs) {
	    for(Objeto obj:objs) {
		if(calcularDistancia(pj, obj) >= d)
		    cantExitos++;
	    }
	}

	return cantExitos;
    }

    public static float calcularDistancia(Personaje p, Objeto o) {
	// Calcula distancia a la que el Personaje p puede lanzar el Objeto o

	return (p.getAltura() * p.getFuerza()) / o.getPeso();
    }

}

package thor;

import java.util.ArrayList;
import java.util.List;

public class Lanzamiento {

	private List<Personaje> pjs;
	private List<Objeto> objs;
	private float distancia;
	private int exitos;

	public Lanzamiento() {
		pjs = new ArrayList<Personaje>();
		objs = new ArrayList<Objeto>();
		exitos=0;
	}

	@Deprecated
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
			if(pj.calcularDistancia(obj) >= d)
		    	cantExitos++;
	    }
	}

	return cantExitos;
    }

	public void leer(String path) {
		Archivo thorIn = new Archivo(path);
		this.distancia = thorIn.cargarArchivo(this.pjs, this.objs);
	}

	public void resolver() {
		// O(n**2)

		for(Personaje pj : pjs) {
			if(pj.calcularDistancia(new Objeto(1)) >= distancia) {
				for(Objeto obj : objs) {
					if(pj.calcularDistancia(obj) >= distancia)
						cantExitos++;
				}
			}
		}
	}

	public void escribir() {
		System.out.println(this.exitos + "exitos");
	}

}

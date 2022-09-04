package clases;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import geom.Casilla;
import geom.Constantes;

public class Sanador extends Luchador {

    private final int COSTE_DIST = 5; // Coste de sanacion a distancia 2 (o mas?)
    private final int COSTE_MELEE = 3; // Coste de sanacion a distancia 1
    private final int DEFAULT_MAX_PTOS_SANACION = 10;

    private int maxPuntosPorSanacion; // Cantidad de PS maximos que puede sanar el
				      // sanador x hechizo

    
    public Sanador(int vida, int magia, Casilla posicion) {
	super(vida, magia, posicion);
	this.maxPuntosPorSanacion = DEFAULT_MAX_PTOS_SANACION;
    }
    
    public Sanador(int vida, int magia, int maxPuntosPorSanacion, Casilla posicion) {
	super(vida, magia, posicion);
	this.maxPuntosPorSanacion = maxPuntosPorSanacion;
    }

    public int sanar(Luchador otro) {
	// Sana, si es posible, al otro Luchador, y retorna los ptos sanados
	
	int coste = this.distanciaA(otro) == Constantes.MELEE ? COSTE_MELEE : COSTE_DIST;
	if (this.magia >= coste) {
	    int sanado = Math.min(otro.getVidaPerdida(), this.maxPuntosPorSanacion);
	    otro.vida += sanado;
	    this.magia -= coste;
	    return sanado;
	}
	return 0;
    }
    
    public double eficienciaAlSanar(Luchador otro) {
	// Retorna la eficiencia de sanar a "otro", es decir, el resultado de sanado/coste
	
	double coste = this.distanciaA(otro) == Constantes.MELEE ? COSTE_MELEE : COSTE_DIST;
	double aSanar = Math.min(otro.getVidaPerdida(), this.maxPuntosPorSanacion);
	return aSanar/coste;
    }

    public int sanarEquipo(Luchador[] equipo) {
	// Sana la mayor cantidad posible de puntos de vida en el equipo

	int ptosSanados = 0;
	List<Luchador> lequipo = Arrays.asList(equipo);
	
	// Problema: No tengo en cuenta que se puede sanar + de una vez a c/Luchador
	Collections.sort(lequipo, (l1, l2) -> {
	    double ef1 = this.eficienciaAlSanar(l1);
	    double ef2 = this.eficienciaAlSanar(l2);
	    double dif = ef2 - ef1;
	    return (dif > 0) ? 1 : ((dif == 0) ? 0 : -1);
	});
	
	for(Luchador l : lequipo) {
	    ptosSanados += this.sanar(l);
	    if(this.magia == 0)
		break;
	}

	return ptosSanados;
    }

}

package clases;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

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
	if(this.magia >= coste) {
	    int sanado = Math.min(otro.getVidaPerdida(), this.maxPuntosPorSanacion);
	    otro.vida += sanado;
	    this.magia -= coste;
	    return sanado;
	}
	return 0;
    }

    public double eficienciaAlSanar(Luchador otro) {
	/*
	 * Retorna la eficiencia de sanar a "otro", es decir, el resultado de
	 * sanado/coste
	 */

	double coste = this.distanciaA(otro) == Constantes.MELEE ? COSTE_MELEE
				: COSTE_DIST;
	double aSanar = Math.min(otro.getVidaPerdida(), this.maxPuntosPorSanacion);
	return aSanar / coste;
    }
    
    public int sanarEquipo(Luchador[] equipo) {
	return 0;
    }

//    public int sanarEquipo(Luchador[] equipo) {
//	// Sana la mayor cantidad posible de puntos de vida en el equipo
//
//	int ptosSanados = 0;
//	List<Luchador> lequipo = Arrays.asList(equipo);
//	Map<Luchador, Float> equipoEficiencia = new HashMap<Luchador, Float>();
//
//	Collections.sort(lequipo, (l1, l2) -> {
//	    double ef1 = this.eficienciaAlSanar(l1);
//	    double ef2 = this.eficienciaAlSanar(l2);
//	    equipoEficiencia.put(l1, (float) ef1);
//	    equipoEficiencia.put(l2, (float) ef2);
//	    double dif = ef2 - ef1;
//	    return (dif > 0) ? 1 : ((dif == 0) ? 0 : -1);
//	});
//
//	for(int i = 0; i < lequipo.size() - 1; i++) {
//	    while(equipoEficiencia.get(lequipo.get(i)) > equipoEficiencia
//				    .get(lequipo.get(i + 1))) {
//		ptosSanados += this.sanar(lequipo.get(i));
//		equipoEficiencia.put(lequipo.get(i),
//					(float) this.eficienciaAlSanar(lequipo.get(i)));
//	    }
//
//	    if(this.magia == 0)
//		break;
//	}
//
//	return ptosSanados;
//    }

}

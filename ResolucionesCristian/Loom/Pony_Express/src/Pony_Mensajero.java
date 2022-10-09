public class Pony_Mensajero {
	
	public static int jinetes(int[] estaciones) {
		int cantJinetes = 1;
		int millasT = 0;
		for (int i : estaciones) {

			if (i + millasT > 100) {
				cantJinetes++;
				millasT = i;
			} else
				millasT += i;

		}
		return cantJinetes;
	}

}
/* si 51+51 >100 -> corto, no puede, llamo otro jinete
 * mi millasT pasa a ser lo que vale el recorrido (cambio jinete)
 * hasta la proxima estacion, caso contrario mi jinete puede avanzar, por lo tanto sumo al millas total
 */
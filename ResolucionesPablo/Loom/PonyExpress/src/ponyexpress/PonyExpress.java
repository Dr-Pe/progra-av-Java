package ponyexpress;

public class PonyExpress {

    public static void main(String[] args) {
	System.out.println(jinetes(new int[] { 33, 8, 16, 47, 30, 30, 46 }));
    }

    public static int jinetes(int[] estaciones) {
	int cantJinetes = 0;
	int i = 0;
	
	while(i < estaciones.length) {
	    Jinete jinete = new Jinete();
	    cantJinetes++;
	    while(i < estaciones.length && jinete.puedeViajar(estaciones[i])) {
		jinete.viaja(estaciones[i]);
		i++;
	    }
	}

	return cantJinetes;
    }
}

package ejercicios;

import grafos.GrafoDirigido;
import grafos.GrafoMST;
import grafos.GrafoNoDirigido;

public class Main {

    public static void main(String[] args) {

	Integer[][] mat = new Integer[][] { { null, 7, 3, null }, { null, null, null, 2 },
		{ null, 2, null, 8 }, { null, null, null, null } };

	@SuppressWarnings("unused")
	GrafoDirigido GD = new GrafoDirigido(mat);
	GrafoNoDirigido GND = new GrafoNoDirigido(mat);

	GrafoMST MST = new GrafoMST(GND);

	System.out.println(MST);

    }
}

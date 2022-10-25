package grafos;

public class Main {

    public static void main(String[] args) {

	Integer[][] mat = new Integer[][] { { null, 7, 3, null }, { null, null, null, 2 },
		{ null, 2, null, 8 }, { null, null, null, null } };
	GrafoDirigido GD = new GrafoDirigido(mat);
	GrafoNoDirigido GND = new GrafoNoDirigido(mat);

	System.out.println(GD);
	System.out.println(GND);
    }
}

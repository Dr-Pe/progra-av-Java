package arco;

public class Partido {

	private final static int PALO_MAX_X = 732;
	private final static int PALO_MAX_Y = 232;

	public static void registrarPartido_nivel1(String registro) {
		Archivo file = new Archivo(registro);

		Tiro[] tiros = file.leerArchivo();

		for (int i = 0; i < tiros.length; i++) {
			tiros[i].setEstado(Partido.arco(tiros[i]));
		}

		file.guardarArchivo(tiros);

	}

	public static void registrarPartido_nivel2(String registro) {
		Archivo file = new Archivo(registro);

		Tiro[] tiros = file.leerArchivo();

		String[] resultados = new String[tiros.length];
		resultados = Partido.palogol(tiros);

		for (int i = 0; i < tiros.length; i++) {
			tiros[i].setEstado(resultados[i]);
		}

		file.guardarArchivo(tiros);
	}

	public static String arco(Tiro tiro) {
		int x = tiro.getX();
		int y = tiro.getY();

		if (x > 0 && x < PALO_MAX_X && y < PALO_MAX_Y && y > 0)
			return "GOL";
		else if (((x == 0 || x == PALO_MAX_X) && (y < PALO_MAX_Y)) || ((y == 0 || y == PALO_MAX_Y) && x < PALO_MAX_X))
			return "PALO";
		else
			return "AFUERA";

	}

	public static String[] palogol(Tiro[] tiro) {
		String[] resultados = new String[tiro.length];

		for (int i = 0; i < tiro.length; i++) {
			resultados[i] = new String(Partido.arco(tiro[i]));
		}

		return resultados;
	}

}

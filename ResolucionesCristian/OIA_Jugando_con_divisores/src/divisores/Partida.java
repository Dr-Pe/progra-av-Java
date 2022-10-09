package divisores;

import java.util.ArrayList;

// agus maximo S, gaston toma minimo S
// menor divisor, mayor divisor

public class Partida {

	public static void jugarPartida(String name) {
		Partida juego = new Partida();

		Archivo datosPartida = new Archivo(name);

		int[] puntajes = new int[2];

		int N = datosPartida.leerArchivo();
		puntajes = juego.divisores(N);
		Jugador Gaston = new Jugador(puntajes[0]);
		Jugador Agustin = new Jugador(puntajes[1]);

		datosPartida.guardarArchivo(Gaston.getPuntuacion(), Agustin.getPuntuacion());

	}

	public int[] divisores(int n) {
		int[] vecPuntos = new int[2];

		vecPuntos[0] = Partida.divisoresRec(n, false);// si arranca Gaston
		vecPuntos[1] = Partida.divisoresRec(n, true);// si arranca Agustin

		return vecPuntos;
	}

	public static int divisoresRec(int n, boolean estado) {
		if (n == 1) {
			return 1;
		}

		int max = 0;
		int min = 1000001;
		int S = n;

		boolean turnoAgustin = estado;
		boolean turnoGaston = !estado;

		ArrayList<Integer> valoresDeJuego = Partida.valoresCandidatos(n);

		min = valoresDeJuego.get(0);
		max = valoresDeJuego.get(1);

		// recursiva aca con valor min y max
		if (turnoGaston)
			S += Partida.divisoresRec(min, true);
		else if (turnoAgustin)
			S += Partida.divisoresRec(max, false);

		return S;
	}

	// no es necesario el arrayList pero queria probar que onda

	// verifica si el numero del pizarron es primo, y si es posible jugar
	private static ArrayList<Integer> valoresCandidatos(int n) {
		ArrayList<Integer> valoresJuego = new ArrayList<Integer>();
		int min = 10000001;
		int max = 0;
		for (int i = 2; i <= n; i++) {
			if (Partida.esPrimo(i) && n % i == 0) {
				int candidato = n / i;
				if (candidato < min)
					min = candidato;
				if (candidato > max)
					max = candidato;

			}
		}
		valoresJuego.add(min);
		valoresJuego.add(max);

		return valoresJuego;
	}

	private static boolean esPrimo(int n) {

		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;

	}
}

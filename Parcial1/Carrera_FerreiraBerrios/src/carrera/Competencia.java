package carrera;

import java.util.ArrayList;
import java.util.List;

public class Competencia {

	private String nombre;
	private List<Corredor> corredores;
	private List<Categoria> categorias;
	private List<Integer> idGanadores;

	public Competencia(String nombre) {
		this.nombre = nombre;
		this.corredores = new ArrayList<Corredor>();
		this.categorias = new ArrayList<Categoria>();
		this.idGanadores = new ArrayList<Integer>();
	}
	
	public void competir() {
		leer();
		resolver();
		escribir();
	}

	private void resolver() {
		for (Integer id : idGanadores) {
			Corredor cor = corredores.get(id - 1);
			for (int i = 0; i < categorias.size(); i++) {
				if (categorias.get(i).add(cor))
					break;
			}

		}
	}

	private void leer() {
		Archivo in = new Archivo("casos_de_prueba/in/" + this.nombre + ".in");
		in.leer(corredores, categorias, idGanadores);
	}
	
	private void escribir() {
		Archivo out = new Archivo("casos_de_prueba/out_obtenido/" + this.nombre + ".out");
		out.escribir(categorias);
	}

}

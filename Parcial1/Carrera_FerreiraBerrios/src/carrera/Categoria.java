package carrera;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private int id;
	private int edadMin;
	private int edadMax;
	private char sexo;
	private List<Corredor> podio;

	public Categoria(int id, int min, int max, char sexo) {
		this.id = id;
		this.edadMin = min;
		this.edadMax = max;
		this.sexo = sexo;
		this.podio = new ArrayList<Corredor>();
	}

	public boolean add(Corredor c) {
		if (!c.esCategoria(edadMin, edadMax, sexo))
			return false;
		return this.podio.add(c);
	}

	@Override
	public String toString() {
		String r = this.id + "";
		int i;
		for(i = 0; i<podio.size() && i<3; i++)
			r += " " + podio.get(i).getId();
		while(i < 3) {
			r += " 0";
			i++;
		}
		return r;
	}

}

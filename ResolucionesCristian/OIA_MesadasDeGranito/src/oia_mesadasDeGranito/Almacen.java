package oia_mesadasDeGranito;

import java.util.ArrayList;

public class Almacen {
	Archivo registro;
	Mesada[] mesadas;
	ArrayList<Pila> pilas;
	
	public Almacen() {
		this.registro = null;
		this.mesadas = null;
		pilas = new ArrayList<Pila>();
	}

	public void leer(String name) {
		registro = new Archivo(name);
		mesadas = registro.leerArchivo();
	}

	public void resolver() {
		pilas.add(new Pila(mesadas[0]));
		for (int i = 1; i < mesadas.length; i++) {
			int j = 0;
			boolean apilado = false;
			while (j < pilas.size() && apilado == false) {
				int condicion1 = pilas.get(j).getTope().sonApilables(mesadas[i]);
				if (condicion1 == 1) {// entra abajo del maximo
					int condicion2 = pilas.get(j).getBase().sonApilables(mesadas[i]);
					if (condicion2 == 1) {// es menor que el minimo
						pilas.get(j).cambiarBase(mesadas[i]);
						apilado = true;
					} else if (condicion2 == -1) {// entra en medio de max y min
						apilado = true;
					}
				} else if (condicion1 == -1) {// es mayor que el maximo
					pilas.get(j).cambiarTope(mesadas[i]);
					apilado = true;
				}
				j++;
			}

			if (!apilado)
				pilas.add(new Pila(mesadas[i]));

		}
	}

	public void escribir() {
		registro.guardarArchivo(this.pilas.size());
	}
}

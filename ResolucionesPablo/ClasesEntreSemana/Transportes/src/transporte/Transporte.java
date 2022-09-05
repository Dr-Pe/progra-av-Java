package transporte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Transporte {

	protected List<Paquete> paquetes;
	protected Set<String> destinos;

	public Transporte() {
		this.paquetes = new ArrayList<Paquete>();
		this.destinos = new HashSet<String>();
	}

	public abstract boolean validarPaquete(Paquete paquete);
	
	public boolean agregarPaquete(Paquete paquete) {
		if(this.validarPaquete(paquete) == false)
			return false;
		// else
		this.paquetes.add(paquete);
		this.destinos.add(paquete.getDestino());
		return true;
	}

	protected double getPesoCargado() {
		double pesoTotal = 0;
		for (Paquete paq : this.paquetes) {
			pesoTotal += paq.getPeso();
		}
		return pesoTotal;
	}

	protected double getVolumenCargado() {
		double volumenTotal = 0;
		for (Paquete paq : this.paquetes) {
			volumenTotal += paq.getVolumen();
		}
		return volumenTotal;
	}

}

package transporte;

public class Moto extends Transporte {

	private final static int CANT_MAX_PAQU = 3;
	private final static int PESO_MAX_TOTAL_PAQU = 50;
	private final static int VOL_MAX_TOTAL_PAQU = 1;

	public Moto() {
		super();
	}

	@Override
	public boolean validarPaquete(Paquete paquete) {
		if (this.paquetes.size() >= CANT_MAX_PAQU)
			return false;
		if (this.getPesoCargado() + paquete.getPeso() > PESO_MAX_TOTAL_PAQU
				|| this.getVolumenCargado() + paquete.getVolumen() > VOL_MAX_TOTAL_PAQU)
			return false;
		if (!this.destinos.isEmpty() && !this.destinos.contains(paquete.getDestino()))
			return false;
		else
			return true;
	}

}

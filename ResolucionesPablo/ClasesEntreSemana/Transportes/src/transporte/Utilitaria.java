package transporte;

public class Utilitaria extends Transporte {

	private final static int PESO_MAX_PAQU = 700;
	private final static int VOL_MAX_PAQU = 3;
	private final static int MAX_CANT_CIUDADES = 3;

	public Utilitaria() {
		super();
	}

	@Override
	public boolean validarPaquete(Paquete paquete) {
		if (this.getPesoCargado() + paquete.getPeso() > PESO_MAX_PAQU
				|| this.getVolumenCargado() + paquete.getVolumen() > VOL_MAX_PAQU)
			return false;
		if (this.destinos.size() >= MAX_CANT_CIUDADES)
			return false;
		else
			return true;
	}

}

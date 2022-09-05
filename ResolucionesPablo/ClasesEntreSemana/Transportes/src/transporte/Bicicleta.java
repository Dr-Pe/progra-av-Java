package transporte;

public class Bicicleta extends Transporte {

	private final static int CANT_MAX_PAQU = 1;
	private final static int PESO_MAX_PAQU = 10;
	private final static int VOL_MAX_PAQU = 1;

	public Bicicleta() {
		super();
	}

	@Override
	public boolean validarPaquete(Paquete paquete) {
		if (this.paquetes.size() > CANT_MAX_PAQU || paquete.getPeso() > PESO_MAX_PAQU
				|| paquete.getVolumen() > VOL_MAX_PAQU)
			return false;
		else
			return true;
	}
	
}

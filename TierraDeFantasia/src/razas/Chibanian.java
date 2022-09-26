package razas;


public class Chibanian extends Raza {

    private static final int VIDA_MAXIMA = 95;
    private static final int DANIO_BASICO = 13;
    private static final int RANGO_MIN = 19, RANGO_MAX = 49;
    private static final int DANIO_POTENCIADO = DANIO_BASICO * 3;
    private int turnosDanioPotenciado = 0;

    public Chibanian() {
	super(VIDA_MAXIMA, DANIO_BASICO, RANGO_MIN, RANGO_MAX);
    }

    @Override
    public void atacar(Raza otro, int distancia) {



	if(this.estaEnRango(distancia)) {
	    otro.recibirDanio(this.danioBasico * 2);
	}

	if(this.turnosDanioPotenciado > 0) {
	    this.turnosDanioPotenciado--;
	    if(this.turnosDanioPotenciado == 0) {
		this.danioBasico = this.getDanioBasico();
	    }
	}

	this.turno++;
    }



    @Override
    public void descansar() {

	this.danioBasico = Chibanian.DANIO_POTENCIADO;
	this.turno++;
    }



    @Override
    public void recibirDanio(int danio) {
	this.danioBasico -= danio;
	this.vida += Math.ceil(this.vida * 1.05);

	if(this.vida > Chibanian.VIDA_MAXIMA) {
	    this.vida = Chibanian.VIDA_MAXIMA;
	}

    }

    public boolean estaEnRango(int distancia) {

	return distancia >= Chibanian.RANGO_MIN && distancia <= Chibanian.RANGO_MAX;
    }

    public int getDanioBasico() {
	return this.danioBasico;
    }
}

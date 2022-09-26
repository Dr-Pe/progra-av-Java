package razas;

public class Nazeahog extends Raza {

    private static final int VIDA_MAXIMA = 55;
    private static final int RANGOMIN = 0;
    private static final int RANGOMAX = 6;
    private static final int DANIO_BASICO = 86;
    private int vidaAct;
    private int turnosEnojado;
    private int turnosAtacando;

    public Nazeahog() {
	super(VIDA_MAXIMA, DANIO_BASICO, RANGOMIN, RANGOMAX);
	this.vidaAct = VIDA_MAXIMA;
	this.turnosAtacando = 0;
    }

    @Override
    public void atacar(Raza otro, int distancia) {
	if(this.puedeAtacar(distancia)) {
	    otro.recibirDanio(this.hacerDaño());
	}

    }

    private int hacerDaño() {
	this.sumarTurno();
	this.turnosAtacando += 1;
	int danioSupuesto = (this.turnosAtacando % 2.0 == 0) ? this.danioBasico * 4
				: this.danioBasico;
	return this.estaEnojado() ? danioSupuesto * 2 : danioSupuesto;
    }

    @Override
    public void descansar() {
	this.sumarTurno();
    }

    @Override
    public void recibirDanio(int danio) {
	this.sumarTurno();
	this.vidaAct -= danio;
	this.enojarse();

    }

    private void enojarse() {
	this.turnosEnojado = 2;
    }

    public boolean estaEnojado() {
	return this.turnosEnojado > 0;
    }

    private void sumarTurno() {
	this.turno += 1;
	this.turnosEnojado -= this.estaEnojado() ? 1 : 0;
    }

    public int getVidaAct() {
	return vidaAct;
    }


}

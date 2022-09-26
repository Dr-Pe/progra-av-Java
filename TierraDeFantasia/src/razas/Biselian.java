package razas;

public class Biselian extends Raza {

    public static final int VIDA_MAXIMA_DEFECTO = 57;
    public static final int DANIO_BASICO = 114;
    public static final int RANGO_MINIMO = 0;
    public static final int RANGO_MAXIMO = 2;

    private int vidaMaxima;
    private boolean puedeAtacar;

    public Biselian() {
	super(VIDA_MAXIMA_DEFECTO, DANIO_BASICO, RANGO_MINIMO, RANGO_MAXIMO);
	this.vidaMaxima = VIDA_MAXIMA_DEFECTO;
	this.puedeAtacar = true;
    }

    @Override
    public void atacar(Raza otro, int distancia) {
	if(!this.puedeAtacar(distancia))
	    return;
	otro.recibirDanio(this.danioBasico);
	if(this.vida + this.vida * 0.03 <= vidaMaxima)
	    this.vida += Math.ceil(this.vida * 0.03);
	turno++;
    }

    @Override
    public void descansar() {
	this.vidaMaxima += 33;
	this.vida += 33;
	this.puedeAtacar = false;
    }

    @Override
    public void recibirDanio(int daño) {
	this.vida -= daño;
	this.puedeAtacar = true;
    }

    @Override
    protected boolean puedeAtacar(int distancia) {
	return super.puedeAtacar(distancia) && this.puedeAtacar;
    }

    public int getVidaMaxima() {
	return this.vidaMaxima;
    }

}

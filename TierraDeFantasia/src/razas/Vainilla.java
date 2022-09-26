package razas;

public class Vainilla extends Raza {

    public static final int VIDA_MAXIMA = 100;
    public static final int DANIO_BASICO = 5;
    public static final int RANGO_MINIMO = 0; // Modificarlo no tendría sentido, pero en
					      // ese caso modificar this.puedeAtacar()
					      // tambien
    public static final int RANGO_MAXIMO = 100;

    public Vainilla() {
	super(VIDA_MAXIMA, DANIO_BASICO, RANGO_MINIMO, RANGO_MAXIMO);
    }

    @Override
    public void atacar(Raza otro, int distancia) {
	if(!this.puedeAtacar(distancia))
	    return;
	otro.recibirDanio(this.danioBasico);
	this.turno++;
    }

    @Override
    public void descansar() {
	this.turno++;
    }

    @Override
    public void recibirDanio(int daño) {
	this.vida -= daño;
    }

}

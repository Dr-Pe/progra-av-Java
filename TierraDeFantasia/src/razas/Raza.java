package razas;

public abstract class Raza {

    protected int danioBasico;
    protected int rangoMinimo;
    protected int rangoMaximo;
    protected int vida;
    protected int turno;

    public Raza(int vida, int danioBasico, int rangoMinimo, int rangoMaximo) {
	this.vida = vida;
	this.danioBasico = danioBasico;
	this.rangoMinimo = rangoMinimo;
	this.rangoMaximo = rangoMaximo;
	this.turno = 0;
    }

    public abstract void atacar(Raza otro, int distancia);

    public abstract void descansar();

    public abstract void recibirDanio(int daño);

    protected boolean puedeAtacar(int distancia) {
	return distancia >= this.rangoMinimo && distancia <= this.rangoMaximo;
    }

    public int getVida() {
	return this.vida;
    }

}

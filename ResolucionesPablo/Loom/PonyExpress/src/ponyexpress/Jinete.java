package ponyexpress;

public class Jinete {

    private final static int CANT_MAX_MILLAS = 100;

    private int millasViajadas;

    public Jinete() {
	this.millasViajadas = 0;
    }

    public boolean puedeViajar(int millas) {
	if(this.millasViajadas + millas >= CANT_MAX_MILLAS)
	    return false;
	else
	    return true;
    }

    public void viaja(int millas) {
	this.millasViajadas += millas;
    }

}

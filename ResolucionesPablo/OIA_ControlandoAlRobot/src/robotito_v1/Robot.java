package robotito_v1;

public class Robot {

    private int direccion;

    public Robot() {
	this.direccion = Direccion.NORTE;
    }

    public int moverHorario() {
	if(this.direccion < Direccion.OESTE)
	    this.direccion += 1;
	else
	    this.direccion = Direccion.NORTE;
	return this.direccion;
    }

    public int moverAntihorario() {
	if(this.direccion > Direccion.NORTE)
	    this.direccion -= 1;
	else
	    this.direccion = Direccion.OESTE;
	return this.direccion;
    }

}

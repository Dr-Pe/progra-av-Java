package figuras;

public class Rectangulo extends Figura {

    private double a;
    private double b;

    public Rectangulo(String color, double ladoA, double ladoB) {
	super(color);
	this.a = ladoA;
	this.b = ladoB;
    }

    @Override
    public double area() {
	return a * b;
    }

}

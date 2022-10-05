package figuras;

public class Circulo extends Figura {

    private double r;

    public Circulo(String color, double radio) {
	super(color);
	this.r = radio;
    }

    @Override
    public double area() {
	return Math.PI * r * r;
    }

}

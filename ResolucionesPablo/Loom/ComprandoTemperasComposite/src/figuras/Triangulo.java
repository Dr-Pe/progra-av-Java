package figuras;

public class Triangulo extends Figura {

    private double b;
    private double h;

    public Triangulo(String color, double base, double altura) {
	super(color);
	this.b = base;
	this.h = altura;
    }

    @Override
    public double area() {
	return b * h / 2;
    }

}

package figuras;

public abstract class Figura {

    private String color;

    protected Figura(String color) {
	this.color = color;
    }

    public abstract double area();

    public String getColor() {
	return this.color;
    }

}

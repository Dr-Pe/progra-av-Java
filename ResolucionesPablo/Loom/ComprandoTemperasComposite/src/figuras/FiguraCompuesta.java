package figuras;

import java.util.Arrays;
import java.util.List;

public class FiguraCompuesta extends Figura {

    private List<Figura> figuras;

    public FiguraCompuesta(Figura[] figuras) {
	super(figuras[0].getColor());
	this.figuras = Arrays.asList(figuras);
    }

    public boolean add(Figura fig) {
	return this.figuras.add(fig);
    }

    @Override
    public double area() {
	double total = 0;
	for(Figura fig : figuras)
	    total += fig.area();
	return total;
    }

}

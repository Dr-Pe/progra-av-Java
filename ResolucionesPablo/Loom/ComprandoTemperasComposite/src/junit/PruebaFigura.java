package junit;

import org.junit.Assert;
import org.junit.Test;

import figuras.Circulo;
import figuras.Figura;
import figuras.FiguraCompuesta;
import figuras.Rectangulo;
import figuras.Triangulo;

public class PruebaFigura {
    /*
     * Estas pruebas ignoran los potes de tempera y solo se centran en el calculo de area
     */

    private final String COLOR = "Rojo";

    @Test
    public void areaUnaFigura() {
	Figura c = new Circulo(COLOR, 1);
	Figura r = new Rectangulo(COLOR, 2, 3);
	Figura t = new Triangulo(COLOR, 2, 3);

	Assert.assertEquals(Math.PI * 1 * 1, c.area(), 0.0001);
	Assert.assertEquals(2 * 3, r.area(), 0.0001);
	Assert.assertEquals(2 * 3 / 2, t.area(), 0.0001);
    }

    @Test
    public void areaFiguraCompuesta() {
	Figura comp = new FiguraCompuesta(new Figura[] { new Circulo(COLOR, 1),
		new Rectangulo(COLOR, 2, 3), new Triangulo(COLOR, 2, 3) });

	double areaTotal = Math.PI + 2 * 3 + 2 * 3 / 2;

	Assert.assertEquals(areaTotal, comp.area(), 0.0001);
    }

}

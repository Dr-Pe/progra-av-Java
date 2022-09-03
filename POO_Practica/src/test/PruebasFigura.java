package test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.Test;

import geom.Punto;
import geom.Rectangulo;

public class PruebasFigura {

	@Test
	public void pruebaRectangulosDistintos() {
		// Arrange
		final int precision = 10;
		Rectangulo r1 = new Rectangulo(new Punto(), 1, 1);
		Rectangulo r2 = new Rectangulo(new Punto(2,3), 1, 2);
		
		// Act
		double a1 = r1.area();
		double a2 = r2.area();
		boolean req = r1.equals(r2);
		
		// Assert
		Assert.assertEquals(1, a1, precision);
		Assert.assertEquals(2, a2, precision);
		Assert.assertFalse(req);
	}
	
}

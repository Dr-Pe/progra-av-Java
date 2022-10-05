package junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import reinas.Reina;
import reinas.Tablero;

public class PruebaReinasN8 {

    private Tablero t;
    private Reina r1;

    @Before
    public void inicializarTableroYReinaUno() {
	this.t = new Tablero(8);
	this.r1 = new Reina(2, 2, 1);
	this.t.add(r1);
    }

    @Test
    public void dosReinasMismaFila() {
	/*
	 * .in | .out
	 * 8 2 | 1 2
	 * 2 2 | 1 1
	 * 2 6 |
	 */

	Reina r2 = new Reina(2, 6, 2);
	t.add(r2);

	t.calcularConflictos();

	Assert.assertArrayEquals(new int[] { 2 }, r1.getConflictos());
	Assert.assertArrayEquals(new int[] { 1 }, r2.getConflictos());
    }

    @Test
    public void dosReinasMismaColumna() {
	/*
	 * .in | .out
	 * 8 2 | 1 2
	 * 2 2 | 1 1
	 * 4 2 |
	 */

	Reina r2 = new Reina(4, 2, 2);
	t.add(r2);

	t.calcularConflictos();

	Assert.assertArrayEquals(new int[] { 2 }, r1.getConflictos());
	Assert.assertArrayEquals(new int[] { 1 }, r2.getConflictos());
    }

    @Test
    public void dosReinasMismaDiagonal() {
	/*
	 * .in | .out
	 * 8 2 | 1 2
	 * 2 2 | 1 1
	 * 6 6 |
	 */

	Reina r2 = new Reina(6, 6, 2);
	t.add(r2);

	t.calcularConflictos();

	Assert.assertArrayEquals(new int[] { 2 }, r1.getConflictos());
	Assert.assertArrayEquals(new int[] { 1 }, r2.getConflictos());
    }

    @Test
    public void dosReinasMismaDiagonalNoPrincipal() {
	Reina rA = new Reina(2, 3, 2);
	t.add(rA);
	Reina rB = new Reina(3, 4, 3);
	t.add(rB);

	t.calcularConflictos();

	Assert.assertArrayEquals(new int[] { 1, 3 }, rA.getConflictos());
	Assert.assertArrayEquals(new int[] { 2 }, rB.getConflictos());
    }

    @Test
    public void dosReinasMismaDiagonalInversaNoPrincipal() {
	Reina rA = new Reina(2, 6, 2);
	t.add(rA);
	Reina rB = new Reina(3, 5, 3);
	t.add(rB);

	t.calcularConflictos();

	Assert.assertArrayEquals(new int[] { 1, 3 }, rA.getConflictos());
	Assert.assertArrayEquals(new int[] { 2 }, rB.getConflictos());
    }

    @Test
    public void tresReinasMismaFila() {
	Reina r2 = new Reina(2, 6, 2);
	t.add(r2);
	Reina r3 = new Reina(2, 8, 3);
	t.add(r3);

	t.calcularConflictos();

	Assert.assertArrayEquals(new int[] { 2 }, r1.getConflictos());
	Assert.assertArrayEquals(new int[] { 1, 3 }, r2.getConflictos());
	Assert.assertArrayEquals(new int[] { 2 }, r3.getConflictos());
    }

    @Test
    public void tresReinasMismaColumna() {
	Reina r2 = new Reina(4, 2, 2);
	t.add(r2);
	Reina r3 = new Reina(8, 2, 3);
	t.add(r3);

	t.calcularConflictos();

	Assert.assertArrayEquals(new int[] { 2 }, r1.getConflictos());
	Assert.assertArrayEquals(new int[] { 1, 3 }, r2.getConflictos());
	Assert.assertArrayEquals(new int[] { 2 }, r3.getConflictos());
    }

    @Test
    public void tresReinasMismaDiagonal() {
	Reina r2 = new Reina(4, 4, 2);
	t.add(r2);
	Reina r3 = new Reina(8, 8, 3);
	t.add(r3);

	t.calcularConflictos();

	Assert.assertArrayEquals(new int[] { 2 }, r1.getConflictos());
	Assert.assertArrayEquals(new int[] { 1, 3 }, r2.getConflictos());
	Assert.assertArrayEquals(new int[] { 2 }, r3.getConflictos());
    }

}

package junit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import grafos.GrafoMST;
import grafos.GrafoNoDirigido;

public class PruebasGrafoNoDirigido {

    private GrafoNoDirigido GND1 = new GrafoNoDirigido(new Integer[][] {
	    { null, 7, 3, null }, { null, null, null, 2 }, { null, 2, null, 8 },
	    { null, null, null, null } });

    /*
     * GND1:
     * 
     * (0)-3-(2)
     * (0)-7-(1)
     * (1)-2-(3)
     * (2)-2-(1)
     * (2)-8-(3)
     */

    @Test
    public void pesoGND1() {
	Integer p0 = GND1.peso(0, 0); // 0
	Integer p1 = GND1.peso(0, 1); // 7
	Integer p2 = GND1.peso(2, 1); // 2
	Integer p3 = GND1.peso(1, 2); // 2, no es bidireccional

	Assert.assertEquals(Integer.valueOf(0), p0);
	Assert.assertEquals(Integer.valueOf(7), p1);
	Assert.assertEquals(Integer.valueOf(2), p2);
	Assert.assertEquals(Integer.valueOf(2), p3);
    }

    @Test
    public void sucesoresGND1() {
	List<Integer> s0 = GND1.sucesores(0);
	List<Integer> s1 = GND1.sucesores(1);
	List<Integer> s2 = GND1.sucesores(2);
	List<Integer> s3 = GND1.sucesores(3);

	Assert.assertEquals(Integer.valueOf(1), s0.get(0));
	Assert.assertEquals(Integer.valueOf(2), s0.get(1));

	Assert.assertEquals(Integer.valueOf(0), s1.get(0));
	Assert.assertEquals(Integer.valueOf(2), s1.get(1));
	Assert.assertEquals(Integer.valueOf(3), s1.get(2));

	Assert.assertEquals(Integer.valueOf(0), s2.get(0));
	Assert.assertEquals(Integer.valueOf(1), s2.get(1));
	Assert.assertEquals(Integer.valueOf(3), s2.get(2));

	Assert.assertEquals(Integer.valueOf(1), s3.get(0));
	Assert.assertEquals(Integer.valueOf(2), s3.get(1));
    }

    @Test
    public void igualdadGND1() {
	GrafoNoDirigido GND1Prima = new GrafoNoDirigido(4);

	GND1Prima.agregarArista(0, 1, 7);
	GND1Prima.agregarArista(0, 2, 3);
	GND1Prima.agregarArista(1, 2, 2);
	GND1Prima.agregarArista(1, 3, 2);
	GND1Prima.agregarArista(2, 3, 8);

	Assert.assertTrue(GND1Prima.equals(GND1));
    }

    @Test
    public void dijkstraGND1() {
	Integer[][] r0 = GND1.dijkstra(0);
	Integer[][] r2 = GND1.dijkstra(2);

	Assert.assertArrayEquals(new Integer[] { 0, 5, 3, 7 }, r0[0]);
	Assert.assertArrayEquals(new Integer[] { 0, 2, 0, 1 }, r0[1]);

	Assert.assertArrayEquals(new Integer[] { 3, 2, 0, 4 }, r2[0]);
	Assert.assertArrayEquals(new Integer[] { 2, 2, 2, 1 }, r2[1]);
    }

    // TODO: Probar FloydWarshall acá tmb

    @Test
    public void kruskalGND1() {
	GrafoMST MST = new GrafoMST(GND1).kruskal();
	GrafoMST MSTesperado = new GrafoMST(GND1);

	MSTesperado.agregarArista(0, 2, 3);
	MSTesperado.agregarArista(2, 1, 2);
	MSTesperado.agregarArista(1, 3, 2);

	Assert.assertEquals(7, (int) MST.getPesoTotal());
	Assert.assertTrue(MST.equals(MSTesperado));
    }

}

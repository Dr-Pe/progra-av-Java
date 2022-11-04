package junit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import grafos.GrafoDirigido;

public class PruebasGrafoDirigido {

    private GrafoDirigido GD1 = new GrafoDirigido(new Integer[][] { { null, 7, 3, null },
	    { null, null, null, 2 }, { null, 2, null, 8 }, { null, null, null, null } });

    /*
     * GD1:
     * 
     * (0)-3->(2)
     * (0)-7->(1)
     * (1)-2->(3)
     * (2)-2->(1)
     * (2)-8->(3)
     */

    @Test
    public void pesoGD1() {
	Integer p0 = GD1.peso(0, 0); // 0
	Integer p1 = GD1.peso(0, 1); // 7
	Integer p2 = GD1.peso(2, 1); // 2
	Integer p3 = GD1.peso(1, 2); // null, no es bidireccional

	Assert.assertEquals(Integer.valueOf(0), p0);
	Assert.assertEquals(Integer.valueOf(7), p1);
	Assert.assertEquals(Integer.valueOf(2), p2);
	Assert.assertEquals(null, p3);
    }

    @Test
    public void sucesoresGD1() {
	List<Integer> s0 = GD1.sucesores(0);
	List<Integer> s1 = GD1.sucesores(1);
	List<Integer> s2 = GD1.sucesores(2);
	List<Integer> s3 = GD1.sucesores(3);

	Assert.assertEquals(Integer.valueOf(1), s0.get(0));
	Assert.assertEquals(Integer.valueOf(2), s0.get(1));

	Assert.assertEquals(Integer.valueOf(3), s1.get(0));

	Assert.assertEquals(Integer.valueOf(1), s2.get(0));
	Assert.assertEquals(Integer.valueOf(3), s2.get(1));

	Assert.assertEquals(0, s3.size());
    }

    @Test
    public void igualdadGD1() {
	GrafoDirigido GD1Prima = new GrafoDirigido(4);

	GD1Prima.agregarArista(0, 1, 7);
	GD1Prima.agregarArista(0, 2, 3);
	GD1Prima.agregarArista(1, 3, 2);
	GD1Prima.agregarArista(2, 1, 2);
	GD1Prima.agregarArista(2, 3, 8);

	Assert.assertTrue(GD1Prima.equals(GD1));
    }

    @Test
    public void dijkstraNodo0GD1() {
	Integer[][] r = GD1.dijkstra(0);

	Assert.assertArrayEquals(new Integer[] { 0, 5, 3, 7 }, r[0]);
	Assert.assertArrayEquals(new Integer[] { 0, 2, 0, 1 }, r[1]);
    }

    @Test
    public void dijkstraNodo2GD1() {
	Integer[][] r = GD1.dijkstra(2);

	Assert.assertArrayEquals(new Integer[] { null, 2, 0, 4 }, r[0]);
	Assert.assertArrayEquals(new Integer[] { null, 2, 2, 1 }, r[1]);
    }

    @Test
    public void floydWarshallDistanciasGD1() {
	Integer[][] distancias = GD1.floydWarshall();
	Integer[] distanciasNodo0 = distancias[0];
	Integer[] distanciasNodo1 = distancias[1];
	Integer[] distanciasNodo2 = distancias[2];
	Integer[] distanciasNodo3 = distancias[3];

	Assert.assertArrayEquals(GD1.dijkstra(0)[0], distanciasNodo0);
	Assert.assertArrayEquals(GD1.dijkstra(1)[0], distanciasNodo1);
	Assert.assertArrayEquals(GD1.dijkstra(2)[0], distanciasNodo2);
	Assert.assertArrayEquals(GD1.dijkstra(3)[0], distanciasNodo3);
    }

}

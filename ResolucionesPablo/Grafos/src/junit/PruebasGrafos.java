package junit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import grafos.Grafo;

public class PruebasGrafos {

    private Grafo G1 = new Grafo(new Integer[][] { { null, 7, 3, null },
	    { null, null, null, 2 }, { null, 2, null, 8 }, { null, null, null, null } });

    /*
     * G1:
     * 
     * (0)-3->(2)
     * (0)-7->(1)
     * (1)-2->(3)
     * (2)-2->(1)
     * (2)-8->(3)
     */

    @Test
    public void pesoG1() {
	Integer p0 = G1.peso(0, 0); // 0
	Integer p1 = G1.peso(0, 1); // 7
	Integer p2 = G1.peso(2, 1); // 2
	Integer p3 = G1.peso(1, 2); // null, no es bidireccional

	Assert.assertEquals(Integer.valueOf(0), p0);
	Assert.assertEquals(Integer.valueOf(7), p1);
	Assert.assertEquals(Integer.valueOf(2), p2);
	Assert.assertEquals(null, p3);
    }

    @Test
    public void sucesoresG1() {
	List<Integer> s0 = G1.sucesores(0);
	List<Integer> s1 = G1.sucesores(1);
	List<Integer> s2 = G1.sucesores(2);
	List<Integer> s3 = G1.sucesores(3);

	Assert.assertEquals(Integer.valueOf(1), s0.get(0));
	Assert.assertEquals(Integer.valueOf(2), s0.get(1));

	Assert.assertEquals(Integer.valueOf(3), s1.get(0));

	Assert.assertEquals(Integer.valueOf(1), s2.get(0));
	Assert.assertEquals(Integer.valueOf(3), s2.get(1));

	Assert.assertEquals(0, s3.size());
    }

    @Test
    public void dijkstraNodo0G1() {
	Integer[][] r = G1.dijkstra(0);

	Assert.assertArrayEquals(new Integer[] { 0, 5, 3, 7 }, r[0]);
	Assert.assertArrayEquals(new Integer[] { 0, 2, 0, 1 }, r[1]);
    }

    @Test
    public void dijkstraNodo2G1() {
	Integer[][] r = G1.dijkstra(2);

	Assert.assertArrayEquals(new Integer[] { null, 2, 0, 4 }, r[0]);
	Assert.assertArrayEquals(new Integer[] { null, 2, 2, 1 }, r[1]);
    }

    @Test
    public void floydWarshallDistanciasG1() {
	G1.floydWarshall();
	Integer[] distanciasNodo0 = G1.getDistancias()[0];
	Integer[] distanciasNodo1 = G1.getDistancias()[1];
	Integer[] distanciasNodo2 = G1.getDistancias()[2];
	Integer[] distanciasNodo3 = G1.getDistancias()[3];

	Assert.assertArrayEquals(G1.dijkstra(0)[0], distanciasNodo0);
	Assert.assertArrayEquals(G1.dijkstra(1)[0], distanciasNodo1);
	Assert.assertArrayEquals(G1.dijkstra(2)[0], distanciasNodo2);
	Assert.assertArrayEquals(G1.dijkstra(3)[0], distanciasNodo3);
    }

}

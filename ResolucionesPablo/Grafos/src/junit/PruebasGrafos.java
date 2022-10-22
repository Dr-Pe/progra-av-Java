package junit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import grafos.Grafo;

public class PruebasGrafos {

    private Grafo g1 = new Grafo(new Integer[][] { { -1, 7, 3, -1 }, { -1, -1, -1, 2 },
	    { -1, 2, -1, 8 }, { -1, -1, -1, -1 } });

    @Test
    public void pesoG1() {
	int p0 = g1.peso(0, 0); // -1
	int p1 = g1.peso(0, 1); // 7
	int p2 = g1.peso(2, 1); // 2
	int p3 = g1.peso(1, 2); // -1, no es bidireccional

	Assert.assertEquals(-1, p0);
	Assert.assertEquals(7, p1);
	Assert.assertEquals(2, p2);
	Assert.assertEquals(-1, p3);
    }

    @Test
    public void sucesoresG1() {
	List<Integer> s0 = g1.sucesores(0);
	List<Integer> s1 = g1.sucesores(1);
	List<Integer> s2 = g1.sucesores(2);
	List<Integer> s3 = g1.sucesores(3);

	Assert.assertEquals(Integer.valueOf(1), s0.get(0));
	Assert.assertEquals(Integer.valueOf(2), s0.get(1));

	Assert.assertEquals(Integer.valueOf(3), s1.get(0));

	Assert.assertEquals(Integer.valueOf(1), s2.get(0));
	Assert.assertEquals(Integer.valueOf(3), s2.get(1));

	Assert.assertEquals(0, s3.size());
    }

}

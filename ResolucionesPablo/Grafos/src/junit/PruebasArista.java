package junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import grafos.Arista;

public class PruebasArista {

    @Test
    public void orden() {
	List<Arista> aristas = new ArrayList<Arista>();

	aristas.add(new Arista(0, 1, 7));
	aristas.add(new Arista(0, 2, 3));
	aristas.add(new Arista(1, 3, 2));
	aristas.add(new Arista(2, 1, 2));
	aristas.add(new Arista(2, 3, 8));

	aristas.sort(null);

	int[] pesos = new int[] { 2, 2, 3, 7, 8 };

	for(int i = 0; i < aristas.size(); i++) {
	    Assert.assertEquals(pesos[i], aristas.get(i).getPeso());
	}
    }

    @Test
    public void igualdad() {
	Arista a = new Arista(1, 1, 1);
	Arista b = new Arista(1, 1, 1);
	Arista c = new Arista(1, 2, 3);

	Assert.assertTrue(a.equals(b));
	Assert.assertFalse(a.equals(c));
    }

}

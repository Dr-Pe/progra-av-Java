package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algorithms.Prim;
import graphs.UndirectedGraph;

public class JunitUG {

    private UndirectedGraph UG1;
    private UndirectedGraph UG2;

    @Before
    public void generateUGs() {
	UG1 = new UndirectedGraph(new Integer[][] { { null, 7, 3, null },
		{ 7, null, 2, 2 }, { 3, 2, null, 8 }, { null, 2, 8, null } });

	UG2 = new UndirectedGraph(9); // Taken from
				      // "https://www.geeksforgeeks.org/wp-content/uploads/Fig-11.jpg"
	UG2.addEdge(0, 1, 4);
	UG2.addEdge(0, 7, 8);
	UG2.addEdge(1, 2, 8);
	UG2.addEdge(1, 7, 11);
	UG2.addEdge(2, 3, 7);
	UG2.addEdge(2, 5, 4);
	UG2.addEdge(2, 8, 2);
	UG2.addEdge(3, 4, 9);
	UG2.addEdge(3, 5, 14);
	UG2.addEdge(4, 5, 10);
	UG2.addEdge(5, 6, 2);
	UG2.addEdge(6, 7, 1);
	UG2.addEdge(7, 8, 7);
    }

    @Test
    public void weights() {
	Assert.assertEquals(Integer.valueOf(7), UG1.weight(0, 1));
	Assert.assertEquals(Integer.valueOf(7), UG1.weight(1, 0));

	Assert.assertEquals(UG1.weight(0, 2), UG1.weight(2, 0));

	Assert.assertEquals(UG1.weight(2, 3), UG1.weight(3, 2));
    }

    @Test
    public void prim() {
	Prim pr1 = new Prim(UG1);
	Prim pr2 = new Prim(UG2);

	Assert.assertTrue(pr1.getMST().equals(new UndirectedGraph(new Integer[][] {
		{ null, null, 3, null }, { null, null, 2, 2 }, { 3, 2, null, null },
		{ null, 2, null, null } })));

	UndirectedGraph mstUG2 = new UndirectedGraph(UG2.order);

	mstUG2.addEdge(0, 1, 4);
	mstUG2.addEdge(0, 7, 8);
	mstUG2.addEdge(2, 3, 7);
	mstUG2.addEdge(2, 5, 4);
	mstUG2.addEdge(2, 8, 2);
	mstUG2.addEdge(3, 4, 9);
	mstUG2.addEdge(5, 6, 2);
	mstUG2.addEdge(6, 7, 1);

	Assert.assertTrue(pr2.getMST().equals(mstUG2));
    }

}

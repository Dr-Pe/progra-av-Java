package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import graphs.UndirectedGraph;

public class JunitUndirectedG {

    private UndirectedGraph UG;

    @Before
    public void generateUG() {
	UG = new UndirectedGraph(new Integer[][] { { null, 7, 3, null },
		{ 7, null, 2, 2 }, { 3, 2, null, 8 }, { null, 2, 8, null } });
    }

    @Test
    public void weights() {
	Assert.assertEquals(Integer.valueOf(7), UG.weight(0, 1));
	Assert.assertEquals(Integer.valueOf(7), UG.weight(1, 0));

	Assert.assertEquals(UG.weight(0, 2), UG.weight(2, 0));

	Assert.assertEquals(UG.weight(2, 3), UG.weight(3, 2));
    }

}

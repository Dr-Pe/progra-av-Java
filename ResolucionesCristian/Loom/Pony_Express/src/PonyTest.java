import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PonyTest {
	
	@Test
	public void testEnunciado() {
		
		Assert.assertEquals(1, Pony_Mensajero.jinetes(new int[] {18, 15}));
		Assert.assertEquals(4, Pony_Mensajero.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));
		Assert.assertEquals(2, Pony_Mensajero.jinetes(new int[] {43, 23, 40, 13}));
		Assert.assertEquals(3, Pony_Mensajero.jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));
		Assert.assertEquals(3, Pony_Mensajero.jinetes(new int[] {51, 51, 51}));
	}
	
	@Test
	public void caso_1_jineteUnico() {
		Assert.assertEquals(1, Pony_Mensajero.jinetes(new int[] {50, 50}));
	}
	
	//hasta 100 corta primer jinete, arranca jinete 2 en 1-1-1-1
	@Test
	public void caso_2_EstacionesCortas() {
		Assert.assertEquals(2, Pony_Mensajero.jinetes(new int[] {10,10,10,10,10,10,10,10,10,10,1,1,1,1,1,1,1,1}));
	}
	

}

package test;

import org.junit.Test;

import razas.Nazeahog;

import org.junit.Assert;
import org.junit.Before;

public class NazeahogtTest {
	
	Nazeahog carlos;
	
	@Before
	public void setInicio() {
		carlos = new Nazeahog();
	}
	
	@Test
	public void testSaludInicial() {
		Assert.assertEquals(55,carlos.getVidaAct());
	}
	
	@Test
	public void testDanioRecibido() {
		carlos.recibirDanio(10);
		Assert.assertEquals(45,carlos.getVidaAct());
	}
	
	@Test
	public void testDescanso() {
		carlos.recibirDanio(10);
		carlos.descansar();
		Assert.assertEquals(45,carlos.getVidaAct());
	}
	
	@Test
	public void testEnojado() {
		carlos.recibirDanio(10);
		Assert.assertEquals(true,carlos.estaEnojado());
	}
	
	@Test
	public void testGolpe() {
		Nazeahog juan = new Nazeahog();
		juan.atacar(carlos,3);
		
		Assert.assertEquals(-31,juan.getVida());
	}
	
	
	
}

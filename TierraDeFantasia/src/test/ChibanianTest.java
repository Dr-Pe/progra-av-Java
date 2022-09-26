package test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import razas.Chibanian;


public class ChibanianTest {

    Chibanian chibanianAtaque, chibanianDefensa;

    @Before
    public void setUp() {
	chibanianAtaque = new Chibanian();
	chibanianDefensa = new Chibanian();
    }

    @Test
    public void testAtaqueNormalEnRango() {
	int vidaRestanteEsperada = chibanianDefensa.getVida()
				- chibanianAtaque.getDanioBasico() * 2;
	chibanianAtaque.atacar(chibanianDefensa, 19);

	int result = chibanianDefensa.getVida();

	Assert.assertEquals(vidaRestanteEsperada, result);
    }

    @Test
    public void testAtaqueFueraDeRango() {
	int vidaRestanteEsperada = chibanianDefensa.getVida();

	chibanianAtaque.atacar(chibanianDefensa, 18);

	int result = chibanianDefensa.getVida();

	Assert.assertEquals(vidaRestanteEsperada, result);

    }

    @Test
    public void testAtaqueDescansado() {
	chibanianAtaque.descansar();

	int vidaRestanteEsperada = chibanianDefensa.getVida() - 78;

	chibanianAtaque.atacar(chibanianDefensa, 20);

	int result = chibanianDefensa.getVida();

	Assert.assertEquals(vidaRestanteEsperada, result);

    }

    @Test
    public void testRecibirAtaque() {

	int vidaRestanteEsperada = chibanianDefensa.getVida()
				- chibanianAtaque.getDanioBasico() * 2;
	vidaRestanteEsperada += Math.ceil(chibanianDefensa.getVida() * 1.05);

	chibanianAtaque.atacar(chibanianDefensa, 20);

	int result = chibanianDefensa.getVida();

	Assert.assertEquals(vidaRestanteEsperada, result);

    }

}

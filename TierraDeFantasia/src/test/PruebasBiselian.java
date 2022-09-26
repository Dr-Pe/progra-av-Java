package test;

import org.junit.Assert;
import org.junit.Test;

import razas.Biselian;
import razas.Vainilla;

public class PruebasBiselian {

    @Test
    public void pruebaAtaqueEnRango() {

	// Arrange
	Biselian bis = new Biselian();
	Vainilla otro = new Vainilla();

	// Act
	bis.atacar(otro, 1);

	// Assert
	Assert.assertEquals(Vainilla.VIDA_MAXIMA - Biselian.DANIO_BASICO, otro.getVida());
    }

    @Test
    public void pruebaAtaqueFueraDeRango() {

	// Arrange
	Biselian bis = new Biselian();
	Vainilla otro = new Vainilla();

	// Act
	bis.atacar(otro, 5);

	// Assert
	Assert.assertEquals(Vainilla.VIDA_MAXIMA, otro.getVida());
    }

    @Test
    public void pruebaAtaquePostDescanso() {

	Biselian bis = new Biselian();
	Vainilla otro = new Vainilla();

	bis.descansar();
	bis.atacar(otro, 0);

	Assert.assertEquals(Vainilla.VIDA_MAXIMA, otro.getVida());
    }

    @Test
    public void pruebaRecibirDanio() {

	Biselian bis = new Biselian();
	Vainilla otro = new Vainilla();

	otro.atacar(bis, 0);

	Assert.assertEquals(Biselian.VIDA_MAXIMA_DEFECTO - Vainilla.DANIO_BASICO,
				bis.getVida());
    }

    @Test
    public void pruebaRoboDeVida() {

	Biselian bis = new Biselian();
	Vainilla otro = new Vainilla();

	otro.atacar(bis, 0);

	int vidaActual = bis.getVida(); // 52

	bis.atacar(otro, 0);

	Assert.assertEquals((int) Math.ceil(vidaActual + vidaActual * 0.03),
				bis.getVida());
    }

    @Test
    public void pruebaCuracionDescanso() {

	Biselian bis = new Biselian();
	Vainilla otro = new Vainilla();

	otro.atacar(bis, 0);

	int vidaActual = bis.getVida(); // 52

	bis.descansar();

	Assert.assertEquals(vidaActual + 33, bis.getVida());
	Assert.assertEquals(Biselian.VIDA_MAXIMA_DEFECTO + 33, bis.getVidaMaxima());
    }

    @Test
    public void pruebaAtaquePostDescansoPostRecibirDanio() {

	Biselian bis = new Biselian();
	Vainilla otro = new Vainilla();

	bis.descansar();
	otro.atacar(bis, 0);
	bis.atacar(otro, 0);

	Assert.assertEquals(Vainilla.VIDA_MAXIMA - Biselian.DANIO_BASICO, otro.getVida());
    }
}

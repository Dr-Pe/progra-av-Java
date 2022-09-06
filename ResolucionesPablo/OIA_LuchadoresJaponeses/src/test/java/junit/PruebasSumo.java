package junit;

import org.junit.Test;

import java.io.File;

import org.junit.Assert;

import clases.Sumo;
import clases.Torneo;


public class PruebasSumo {

    private final static int MAS_GRANDE = 1;
    private final static int IGUALES = 0;
    
    @Test
    public void pruebaADominaB() {
	// Arrange
	Sumo A = new Sumo(300, 1500);
	Sumo B0 = new Sumo(200, 1400);	// Dominado en todo
	Sumo B1 = new Sumo(200, 1500);	// Dominado en peso
	Sumo B2 = new Sumo(300, 1400);	// Dominado en altura
	
	// Act
	int r0 = A.compareTo(B0);
	int r1 = A.compareTo(B1);
	int r2 = A.compareTo(B2);
	
	// Assert
	Assert.assertEquals(MAS_GRANDE, r0);
	Assert.assertEquals(MAS_GRANDE, r1);
	Assert.assertEquals(MAS_GRANDE, r2);
    }
    
    @Test
    public void pruebaAigualB() {
	Sumo A = new Sumo(300, 1500);
	Sumo B = new Sumo(300, 1500);
	
	Assert.assertEquals(IGUALES, A.compareTo(B));
    }
    
    @Test
    public void pruebaDominacionMutua() {
	Sumo A = new Sumo(300, 1500);
	Sumo B = new Sumo(368, 1470);	// A.peso < B.peso pero A.altura > B.altura
	Sumo C = new Sumo(250, 1780);	// A.peso > C.peso pero A.altura < C.altura
	
	Assert.assertEquals(IGUALES, A.compareTo(B));
	Assert.assertEquals(IGUALES, A.compareTo(C));
    }
    
    @Test
    public void pruebaArchivos() {
	Torneo.main(null);
	File expected = new File("src/test/sumo_expected.out");
	File actual = new File("src/test/sumo.out");
	
	// No recuerdo como comparar archivos the fat way
	
    }
    
}

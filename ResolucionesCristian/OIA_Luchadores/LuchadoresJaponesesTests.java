package luchadores;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class LuchadoresJaponesesTests {

	@Test
	public void sumo() throws IOException {
		Resolucion resolver = new Resolucion();
		resolver.resolverLuchadores("sumo");
		
		byte[] file1Bytes = Files.readAllBytes(Paths.get("Casos de prueba/out/sumo.out"));
		byte[] file2Bytes = Files.readAllBytes(Paths.get("Casos de prueba/out obtenido/sumo.out"));
		
		String file1 = new String(file1Bytes, StandardCharsets.UTF_8);
		String file2 = new String(file2Bytes, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

}

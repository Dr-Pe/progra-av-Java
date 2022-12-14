package oia_vagonesDeTren;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class Test_vagonesDeTren {
	Transporte sarmiento;
	
	@Before
	public void setup() {
		sarmiento = new Transporte();
	}
	
	@Test
	public void casoEnunciado() throws IOException {
		sarmiento.transportar("caso_1");
		
		byte[] bytesFile1 = Files.readAllBytes(Paths.get("CasosDePrueba/out/caso_1.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("CasosDePrueba/out_obtenido/caso_1.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
		
	}
	@Test
	public void animalesMuyAgresivos()  throws IOException  {
		sarmiento.transportar("caso_2");
		
		byte[] bytesFile1 = Files.readAllBytes(Paths.get("CasosDePrueba/out/caso_2.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("CasosDePrueba/out_obtenido/caso_2.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}
	
	@Test
	public void animalesInofensivos() throws IOException {
		sarmiento.transportar("caso_3");
		
		byte[] bytesFile1 = Files.readAllBytes(Paths.get("CasosDePrueba/out/caso_3.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("CasosDePrueba/out_obtenido/caso_3.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}
	//fatiga

}

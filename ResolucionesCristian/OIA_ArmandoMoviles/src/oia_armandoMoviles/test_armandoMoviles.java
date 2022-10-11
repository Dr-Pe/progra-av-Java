package oia_armandoMoviles;

import static org.junit.Assert.*;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class test_armandoMoviles {
	Fabrica fabrica;

	@Before
	public void setup() {
		fabrica = new Fabrica();
	}

	@Test
	public void casoEnunciado() throws IOException {
		fabrica.trabajar("caso_1");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("CasosDePrueba/out/caso_1.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("CasosDePrueba/out_obtenido/caso_1.out"));

		String file1 = new String(bytesFile1);
		String file2 = new String(bytesFile2);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

	@Test
	public void casoPesosIguales() throws IOException {
		fabrica.trabajar("caso_2");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("CasosDePrueba/out/caso_2.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("CasosDePrueba/out_obtenido/caso_2.out"));

		String file1 = new String(bytesFile1);
		String file2 = new String(bytesFile2);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

	@Test
	public void casoCotasMaximas() throws IOException {
		fabrica.trabajar("caso_3");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("CasosDePrueba/out/caso_3.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("CasosDePrueba/out_obtenido/caso_3.out"));

		String file1 = new String(bytesFile1);
		String file2 = new String(bytesFile2);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

	@Test
	public void casoNoSePuedeCrearMoviles() throws IOException {
		fabrica.trabajar("caso_4");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("CasosDePrueba/out/caso_4.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("CasosDePrueba/out_obtenido/caso_4.out"));

		String file1 = new String(bytesFile1);
		String file2 = new String(bytesFile2);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

}

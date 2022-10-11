package oia_mesadasDeGranito;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class test_MesadaDeGranito {
	Negocio walmart;

	@Before
	public void setup() {
		walmart = new Negocio();
	}

	@Test
	public void flujoNormal() throws IOException {

		walmart.trabajar("caso_1");

		byte[] file1Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_1.out"));
		byte[] file2Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_1.out"));

		String file1 = new String(file1Bytes, StandardCharsets.UTF_8);
		String file2 = new String(file2Bytes, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

	@Test
	public void todosSeApilanEnUno() throws IOException {
		walmart.trabajar("caso_2");

		byte[] file1Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_2.out"));
		byte[] file2Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_2.out"));

		String file1 = new String(file1Bytes, StandardCharsets.UTF_8);
		String file2 = new String(file2Bytes, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

	@Test
	public void ningunoSeApilaConNinguno() throws IOException {
		walmart.trabajar("caso_3");

		byte[] file1Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_3.out"));
		byte[] file2Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_3.out"));

		String file1 = new String(file1Bytes, StandardCharsets.UTF_8);
		String file2 = new String(file2Bytes, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

	@Test
	public void VariasRotaciones() throws IOException {
		walmart.trabajar("caso_4");

		byte[] file1Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_4.out"));
		byte[] file2Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_4.out"));

		String file1 = new String(file1Bytes, StandardCharsets.UTF_8);
		String file2 = new String(file2Bytes, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

	@Test
	public void ValoresIguales() throws IOException {
		walmart.trabajar("caso_5");

		byte[] file1Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_5.out"));
		byte[] file2Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_5.out"));

		String file1 = new String(file1Bytes, StandardCharsets.UTF_8);
		String file2 = new String(file2Bytes, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

	@Test
	public void CambioDeBase() throws IOException {
		walmart.trabajar("caso_6");

		byte[] file1Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_6.out"));
		byte[] file2Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_6.out"));

		String file1 = new String(file1Bytes, StandardCharsets.UTF_8);
		String file2 = new String(file2Bytes, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

	@Test
	public void ErrorDeApilamiento() throws IOException {
		walmart.trabajar("caso_7");

		byte[] file1Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_7.out"));
		byte[] file2Bytes = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_7.out"));

		String file1 = new String(file1Bytes, StandardCharsets.UTF_8);
		String file2 = new String(file2Bytes, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

}
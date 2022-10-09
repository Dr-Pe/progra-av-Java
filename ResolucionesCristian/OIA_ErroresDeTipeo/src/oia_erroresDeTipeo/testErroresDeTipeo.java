package oia_erroresDeTipeo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class testErroresDeTipeo {

	private JornadaLaboral lunes;

	@Before
	public void setup() {
		lunes = new JornadaLaboral();
	}

	@Test
	public void textoEnunciado() throws IOException {
		lunes.laburar("caso_1");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_1.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_1.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals(file1, file2);

	}

	@Test
	public void mismosTextos() throws IOException {
		lunes.laburar("caso_2");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_2.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_2.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals(file1, file2);

	}

	@Test
	public void TextosVacios() throws IOException {
		lunes.laburar("caso_3");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_3.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_3.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals(file1, file2);
	}

	@Test
	public void textosSinErrores() throws IOException {
		lunes.laburar("caso_4");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_3.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_3.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals(file1, file2);
	}

	@Test
	public void textosConEspaciosYPuntuaciones() throws IOException {
		lunes.laburar("caso_5");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_3.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_3.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals(file1, file2);
	}

	@Test
	public void caseSensitive() throws IOException {
		lunes.laburar("caso_6");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("casosDePrueba/out/caso_3.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("casosDePrueba/out_obtenido/caso_3.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals(file1, file2);
	}

}

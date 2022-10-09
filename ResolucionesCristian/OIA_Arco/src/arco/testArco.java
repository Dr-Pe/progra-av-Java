package arco;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class testArco {

	@Test
	public void caso_enunciado_nivel1() throws IOException {
		Partido.registrarPartido_nivel1("caso_1");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("Casos_de_prueba/out/caso_1.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("Casos_de_prueba/out_obtenido/caso_1.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

	@Test
	public void caso_enunciado_nivel2() throws IOException {

		Partido.registrarPartido_nivel2("caso_1_nivel2");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("Casos_de_prueba/out/caso_1_nivel2.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("Casos_de_prueba/out_obtenido/caso_1_nivel2.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);

	}
}

package divisores;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class DivisoresTest {

	@Test
	public void caso1_enunciado_nivel1() throws IOException {
		Partida.jugarPartida("caso_1");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("Casos_de_prueba/out/caso_1.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("Casos_de_prueba/out_obtenido/caso_1.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

	@Test
	public void caso2_enunciado_nivel1() throws IOException {
		Partida.jugarPartida("caso_2");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("Casos_de_prueba/out/caso_2.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("Casos_de_prueba/out_obtenido/caso_2.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}

	@Test
	public void caso3_enunciado_nivel1() throws IOException {
		Partida.jugarPartida("caso_3");

		byte[] bytesFile1 = Files.readAllBytes(Paths.get("Casos_de_prueba/out/caso_3.out"));
		byte[] bytesFile2 = Files.readAllBytes(Paths.get("Casos_de_prueba/out_obtenido/caso_3.out"));

		String file1 = new String(bytesFile1, StandardCharsets.UTF_8);
		String file2 = new String(bytesFile2, StandardCharsets.UTF_8);

		assertEquals("El contenido de los archivos es distinto", file1, file2);
	}
}

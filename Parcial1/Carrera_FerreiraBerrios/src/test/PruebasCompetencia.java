package test;

import org.junit.Test;

import carrera.Competencia;

public class PruebasCompetencia {

	@Test
	public void casoEnunciado() {
		Competencia c0 = new Competencia("carrera");
		c0.competir();
	}
	
	@Test
	public void caso01() {
		Competencia c1 = new Competencia("caso01_una_categoria");
		c1.competir();
	}
	
	@Test
	public void caso02() {
		Competencia c2 = new Competencia("caso02_un_corredor_por_categoria");
		c2.competir();
	}
	
	@Test
	public void caso03() {
		Competencia c3 = new Competencia("caso03_una_categoria_uno_llega");
		c3.competir();
	}
	
	@Test
	public void caso04() {
		Competencia c4 = new Competencia("caso04_input_minimo");
		c4.competir();
	}

}

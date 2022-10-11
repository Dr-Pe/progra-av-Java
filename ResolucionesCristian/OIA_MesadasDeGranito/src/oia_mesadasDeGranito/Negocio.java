package oia_mesadasDeGranito;

public class Negocio {
	public void trabajar(String registro) {
		Almacen almacen = new Almacen();
		
		almacen.leer(registro);
		almacen.resolver();
		almacen.escribir();
	}
	
}

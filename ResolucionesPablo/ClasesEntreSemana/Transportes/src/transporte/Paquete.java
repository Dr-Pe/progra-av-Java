package transporte;

public class Paquete {

	private double peso;
	private double volumen;
	private String destino;

	public Paquete(double peso, double volumen, String destino) {
		this.peso = peso;
		this.volumen = volumen;
		this.destino = destino;
	}

	public double getPeso() {
		return this.peso;
	}

	public double getVolumen() {
		return this.volumen;
	}
	
	public String getDestino() {
		return this.destino;
	}

}

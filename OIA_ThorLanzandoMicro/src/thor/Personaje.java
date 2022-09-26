package thor;

public class Personaje {

    private float altura;
    private float fuerza;


    public Personaje(float a, float f) {
	altura = a;
	fuerza = f;
    }

    public float calcularDistancia(Objeto o) {
	// Calcula distancia a la que el Personaje puede lanzar el Objeto o

	return (this.altura * this.fuerza) / o.getPeso();
    }

}

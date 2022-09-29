package tdas;

public class ColaPrioritariaEnteros {

    private MonticuloEnteros cola;

    public ColaPrioritariaEnteros(int tam) {
	// O(1)
	this.cola = new MonticuloEnteros(tam);
    }

    public boolean encolar(int el) {
	// O(log(n))
	return this.cola.agregar(el);
    }

    public Integer desencolar() {
	// O(log(n))
	return this.cola.sacar(); // Or null
    }

}

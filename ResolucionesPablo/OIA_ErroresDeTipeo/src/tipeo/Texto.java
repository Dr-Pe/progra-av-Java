package tipeo;

import java.util.HashMap;
import java.util.Map;

public class Texto {

    private Map<Character, Integer> caracteres;


    public Texto(String texto) {
	this.caracteres = new HashMap<Character, Integer>();

	for(int i = 0; i < texto.length(); i++) {
	    this.caracteres.putIfAbsent(texto.charAt(i), i);
	}
    }

    public Integer get(Character c) {
	return this.caracteres.get(c);
    }

}

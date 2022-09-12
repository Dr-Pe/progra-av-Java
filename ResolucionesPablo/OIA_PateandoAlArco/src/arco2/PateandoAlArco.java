package arco2;

public class PateandoAlArco {
    
    public static void main(String[] args) {
	
	int[] x = new int[] {0, 1000};
	int[] y = new int[] {100, 1000};
	String[] r = palogol(x, y);
	
	for(String str : r) {
	    System.out.println(str);
	}
    }
        
    public static String[] palogol(int[] x, int[] y) {
	
	String[] r = new String[x.length];
	
	for(int i = 0; i<x.length; i++) {
	    r[i] = arco1.PateandoAlArco.arco(x[i], y[i]);
	}
	return r;
    }
}

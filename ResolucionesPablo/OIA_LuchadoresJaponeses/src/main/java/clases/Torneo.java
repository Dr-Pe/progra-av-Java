package clases;

import java.io.File;
import java.util.Scanner;

public class Torneo {

    public static void main(String[] args) {
	String path_in = "/test/resources/sumo.in";
	Sumo[] luchadores = cargarLuchadores(path_in);

    }

    public static Sumo[] cargarLuchadores(String path) {
	File fp = null;
	Scanner sc = null;
	Sumo[] r = null;

	try {
	    fp = new File(path);
	    sc = new Scanner(fp);

	    int cant = sc.nextInt();
	    r = new Sumo[cant];
	    
	    for(int i=0; i<cant; i++)
		r[i] = new Sumo(sc.nextInt(), sc.nextInt());
	    
	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    sc.close();
	}

	return r;
    }
}

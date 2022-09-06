package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Torneo {

    public static void main(String[] args) {
	String path_in = "src/test/resources/sumo.in";
	String path_out = "src/test/resources/sumo.out";
	
	Sumo[] luchadores = cargarLuchadores(path_in);
	ejecutarCombates(luchadores);
	imprimirResultados(path_out, luchadores);

    }
    
    public static void imprimirResultados(String path, Sumo[] luchadores) {
	FileWriter fw = null;
	PrintWriter pw = null;
	
	try {
	    fw = new FileWriter(path);
	    pw = new PrintWriter(fw);
	    
	    for(Sumo luchador : luchadores) {
		pw.println(luchador.getDominados());
	    }
	    
	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    pw.close();
	    try {
		fw.close();
	    } catch(IOException e) {
		e.printStackTrace();
	    }
	}
    }

    public static void ejecutarCombates(Sumo[] luchadores) {
	for(int i = 0;i < luchadores.length;i++) {
	    for(int j = i + 1;j < luchadores.length;j++) {
		luchadores[i].combate(luchadores[j]);
	    }
	}
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

	    for(int i = 0;i < cant;i++)
		r[i] = new Sumo(sc.nextInt(), sc.nextInt());

	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    sc.close();
	}

	return r;
    }

}

package thor;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Archivo {

    private String path;

    public Archivo(String path) {
	this.path = path;
    }

    public float cargarArchivo(List<Personaje> pjs, List<Objeto> objs) {
	// Devuelve distancia leida en el archivo .in (-1 si hay error) y carga arrays
	// de Personaje y Objeto

	File fp = null;
	Scanner sc = null;
	int D = -1;

	try {
	    fp = new File(this.path);
	    sc = new Scanner(fp);

	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    D = sc.nextInt();

	    for(int i = 0; i < n; i++)
		pjs.add(new Personaje(sc.nextInt(), sc.nextInt()));
	    for(int i = 0; i < m; i++)
		objs.add(new Objeto(sc.nextInt()));


	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    sc.close();
	}

	return D;
    }

}

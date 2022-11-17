package res;

import grafo.Coloreo;
import grafo.Grafo;

public class Resolucion {

    private Grafo g;
    private int invitados;

    public static void main(String[] args) {

	String nombre = "caso3_447nodos_todo_conexo";

	Archivo in = new Archivo("archivos/" + nombre + ".in");
	Archivo out = new Archivo("archivos/" + nombre + ".out");

	Resolucion r = in.leerArchivo();

	r.resolver();
	out.escribirArchivo(r);

	System.out.println(r.invitados);

    }

    public Resolucion(Grafo g) {
	this.g = g;
    }

    public void resolver() {
	Coloreo c = new Coloreo(g);
	invitados = c.tamMaximoGrupo();
    }

    public int getInvitados() {
	return invitados;
    }

}

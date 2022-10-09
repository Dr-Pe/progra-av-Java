package oia_erroresDeTipeo;

public class JornadaLaboral {
	public void laburar(String name) {
		Archivo arch = new Archivo(name);
		Dactilografo juan = new Dactilografo();

		String[] textos = arch.leerArchivoIn();
		int intercambios = juan.revisar(textos[0], textos[1]);

		arch.escribirArchivoOut(name, intercambios);
	}
}

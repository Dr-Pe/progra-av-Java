import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Resolucion {

	private Graph g;
	private int lider_A;
	private int lider_B;
	private int aliados_A;
	private int aliados_B;

	public static void main(String[] args) {
		Resolucion r = new Resolucion("caso_0");
		System.out.println("Ejecucion finalizada");
	}

	public Resolucion(String name) {
		aliados_A = 0;
		aliados_B = 0;
		leerArchivo(name);
		resolver();
		escribirArchivo(name);
	}

	public void leerArchivo(String name) {

		File fp = null;
		Scanner scan = null;

		try {

			fp = new File("testIn/" + name + ".in");
			scan = new Scanner(fp);

			int n = scan.nextInt(); // vecinos
			int m = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();

			g = new Graph(n);
			lider_A = x - 1;
			lider_B = y - 1;

			for (int i = 0; i < m; i++) {
				int k = scan.nextInt();
				int r = scan.nextInt();
				int l = scan.nextInt();
				g.addEdge(k - 1, r - 1, l);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}
	//Complejidad: O(N+A) BFS
	public void resolver() {

		Integer[] vecCostosX = g.BFS(lider_A);
		Integer[] vecCostosY = g.BFS(lider_B);

		for (int i = 0; i < vecCostosX.length; i++) {
			if (vecCostosX[i] != null && vecCostosY[i] != null) {
				if (vecCostosX[i] > vecCostosY[i]) {
					aliados_A++;
				} else {
					aliados_B++;
				}
			}
		}
	}

	public void escribirArchivo(String name) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter("testOutObtenido/" + name + ".out");
			pw = new PrintWriter(fw);
			
			pw.print(aliados_A + " " + aliados_B);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pw.close();
		}
	}

}

import java.util.ArrayList;
import java.util.Arrays;

import java.util.stream.Collectors;

public class Album {

	ArrayList<Integer> val;

	public Album() {
		this.val = new ArrayList<Integer>();

	}

	public static void main(String[] args) {
		int[] c1 = { 1, 1, 1, 1};
		int[] c2 = { 1, 5};
		System.out.println(Album.difFiguritas(c1, c2));
	}

	/**
	 * 
	 * @param v :colecciones1
	 * @var A : array de colecciones1
	 * @var a : acumulador colecciones1
	 * @var r : repetidos de colecciones1
	 * @var l : size colecciones1
	 * 
	 * @param w :colecciones2
	 * @var B : array de colecciones2
	 * @var b : acumulador colecciones2
	 * @var p : repetidos de colecciones2
	 * @var k : size colecciones2
	 * 
	 * @return
	 */
	
	
	//434
	
	public static int difFiguritas(int[] coleccionista1, int[] coleccionista2) {
		int r = 0;
		int p = 0;

		
		ArrayList<Integer> A = (ArrayList<Integer>) Arrays.stream(coleccionista1).boxed().collect(Collectors.toList());

		int l = A.size();
		A.sort(null);

		for (int i = 0; i < l - 1; i++) 
			if (A.get(i) == A.get(i + 1))
				r++;
		

		ArrayList<Integer> B = (ArrayList<Integer>) Arrays.stream(coleccionista2).boxed().collect(Collectors.toList());
		int k = B.size();
		B.sort(null);

		for (int i = 0; i < k - 1; i++) 
			if (B.get(i) == B.get(i + 1))
				p++;
		

		return (l -= r) - (k -= p) == 0 ? 0 : l - k < 0 ? -1 : 1;

	}

}

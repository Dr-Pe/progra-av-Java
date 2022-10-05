package reinas;

public class Tablero {

    private final int N;
    private Reina[][] matriz;

    public Tablero(int n) {
	this.N = n;
	this.matriz = new Reina[n][n];
    }

    public boolean add(Reina r) {
	int fila = r.getFila();
	int col = r.getColumna();

	if(fila > this.N || col > this.N)
	    return false;
	else if(matriz[fila - 1][col - 1] != null)
	    return false;

	matriz[fila - 1][col - 1] = r;
	return true;
    }

    public void calcularConflictos() {
	// f(n) = 6(n**2) - 6n ---> O(n**2)

	for(int n = 0; n < this.N; n++) {
	    this.conflictosPorFila(n); 	  // O(n)
	    this.conflictosPorColumna(n); // O(n)
	} // n * 2n -> 2(n**2)
	this.conflictosPorDiagonal(0, 0); 	     // O(n)
	this.conflictosPorDiagonalInversa(0, N - 1); // O(n)
	for(int d = 1; d < this.N - 1; d++) {
	    this.conflictosPorDiagonal(0, d); 	     	      // O(n)
	    this.conflictosPorDiagonal(d, 0); 	     	      // O(n)
	    this.conflictosPorDiagonalInversa(0, d); 	      // O(n)
	    this.conflictosPorDiagonalInversa(d, this.N - 1); // O(n)
	} // 4n * (n - 2) -> 4(n**2) - 8n
    }

    private void conflictosPorFila(int fila) {
	int j = 0;

	while(j < this.N) {
	    if(this.matriz[fila][j] != null) {
		// Primer Reina de la fila encontrada
		Reina rb = this.matriz[fila][j];
		// Busco otra Reina
		j++;
		while(j < this.N && this.matriz[fila][j] == null)
		    j++;
		// Si encontró otra antes de salirse del Tablero...
		if(j < this.N) {
		    // Agrego conflictos a las reinas en juego
		    rb.addConflicto(this.matriz[fila][j]);
		    this.matriz[fila][j].addConflicto(rb);
		    j--; // Ahora se calcula desde la segunda Reina encontrada
		}
	    }
	    j++;
	}
    }

    private void conflictosPorColumna(int col) {
	int i = 0;

	while(i < this.N) {
	    if(this.matriz[i][col] != null) {
		// Primer Reina de la columna encontrada
		Reina rb = this.matriz[i][col];
		// Busco otra Reina
		i++;
		while(i < this.N && this.matriz[i][col] == null)
		    i++;
		// Si encontró otra antes de salirse del Tablero...
		if(i < this.N) {
		    // Agrego conflictos a las reinas en juego
		    rb.addConflicto(this.matriz[i][col]);
		    this.matriz[i][col].addConflicto(rb);
		    i--; // Ahora se calcula desde la segunda Reina encontrada
		}
	    }
	    i++;
	}
    }

    private void conflictosPorDiagonal(int fila, int col) {
	// Donde fila y columna son los del elemento superior izquierdo de la diagonal

	int i = 0;
	while(fila + i < this.N && col + i < this.N) {
	    if(this.matriz[fila + i][col + i] != null) {
		// Primer Reina de la columna encontrada
		Reina rb = this.matriz[fila + i][col + i];
		// Busco otra Reina
		i++;
		while(fila + i < this.N && col + i < this.N
					&& this.matriz[fila + i][col + i] == null)
		    i++;
		// Si encontró otra antes de salirse del Tablero...
		if(fila + i < this.N && col + i < this.N) {
		    // Agrego conflictos a las reinas en juego
		    rb.addConflicto(this.matriz[fila + i][col + i]);
		    this.matriz[fila + i][col + i].addConflicto(rb);
		    i--; // Ahora se calcula desde la segunda Reina encontrada
		}
	    }
	    i++;
	}
    }

    private void conflictosPorDiagonalInversa(int fila, int col) {
	// Donde fila y columna son los del elemento superior derecho de la diagonal

	int i = 0;
	while(fila + i < this.N && col - i >= 0) {
	    if(this.matriz[fila + i][col - i] != null) {
		// Primer Reina de la columna encontrada
		Reina rb = this.matriz[fila + i][col - i];
		// Busco otra Reina
		i++;
		while(fila + i < this.N && col - i > 0
					&& this.matriz[fila + i][col - i] == null)
		    i++;
		// Si encontró otra antes de salirse del Tablero...
		if(fila + i < this.N && col - i > 0) {
		    // Agrego conflictos a las reinas en juego
		    rb.addConflicto(this.matriz[fila + i][col - i]);
		    this.matriz[fila + i][col - i].addConflicto(rb);
		    i--; // Ahora se calcula desde la segunda Reina encontrada
		}
	    }
	    i++;
	}
    }

    @Override
    public String toString() {
	String r = "  ";

	for(int j = 0; j < this.N; j++)
	    r += (j + 1) + " ";

	for(int i = 0; i < this.N; i++) {
	    r += "\n" + (i + 1) + " ";
	    for(int j = 0; j < this.N; j++) {
		if(matriz[i][j] != null)
		    r += "X ";
		else
		    r += "- ";
	    }
	}

	return r;
    }

}

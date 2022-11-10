package graphs;

public class Node {
	private int color;
	private int grado;
	private int index;

	public Node(int g, int i) {
		this.grado = g;
		this.index = i;
		this.color = -1;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public void up() {
		this.grado++;
	}
	public int getColor() {
		return this.color;
	}
	
	public int getGrado() {
		return this.grado;
	}
	public int getIdx() {
		return this.index;
	}
	@Override
	public String toString() {
		return "idx:" + index ;///*+ ", color:" + color */+ ", grado:" + grado;
	}
}

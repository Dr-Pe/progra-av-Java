
public class Vertice {

	private int id;
	private int x;
	private int y;

	public Vertice(int i, int x, int y) {
		this.id = i;
		this.x = x;
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double distancia(Vertice otro) {
		int x = this.x - otro.x;
		int y = this.y - otro.y;
		return Math.hypot(x, y);
	}

	@Override
	public String toString() {
		return this.id + "=(" + this.x + "," + this.y + ")";
	}

}
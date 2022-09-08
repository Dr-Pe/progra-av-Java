package arco;

public class Tiro {
	private int x;
	private int y;
	private String estado;

	public Tiro() {

	}

	public Tiro(int x, int y) {
		this.x = x;
		this.y = y;
		this.estado = null;

	}

	public Tiro(int x, int y, String estado) {
		this.x = x;
		this.y = y;
		this.estado = estado;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}

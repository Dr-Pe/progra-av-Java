package brains;

import java.util.List;

import edu.unlam.snake.brain.Brain;
import edu.unlam.snake.engine.Direction;
import edu.unlam.snake.engine.Point;

public class MyBrain extends Brain {

    /*
     * Pablo Ferreira,
     * Cristian Berrios.
     * 
     * 5/11/2022
     */

    public MyBrain() {
	super("Ferreira | Berrios");
//		throw new RuntimeException("Agregar ids loom");

    }

    public Direction getDirection(Point head, Direction previous) {
	Direction r = previous;

	List<Point> fruits = info.getFruits();
	List<Point> snake = info.getSnake();
	List<List<Point>> enemies = info.getEnemies();
	List<Point> obstacles = info.getObstacles();

	Point myNextHead = head.clone();
	Point posibleHead = head.clone();

	Point fr = buscarFrutaMasCercana(head, fruits);
	r = moverHaciaFruta(head, r, fr);
	myNextHead.moveTo(r);

	for(Point obstacle : obstacles) {
	    if(myNextHead.equals(obstacle)) {
		posibleHead.moveTo(r.turnRight());
		if(posibleHead.equals(obstacle))
		    return r.turnLeft();
		else
		    r = r.turnRight();
	    }
	}

	for(List<Point> len : enemies) {
	    for(Point plen : len) {
		if(myNextHead.equals(plen)) {
		    posibleHead.moveTo(r.turnRight());
		    if(posibleHead.equals(plen))
			return r.turnLeft();
		    else
			r = r.turnRight();
		}
	    }
	}

	for(Point pls : snake) {
	    if(myNextHead.equals(pls)) {
		posibleHead.moveTo(r.turnRight());
		if(posibleHead.equals(pls))
		    return r.turnLeft();
		else
		    r = r.turnRight();
	    }
	}

	return r;
    }

    public Direction moverHaciaFruta(Point head, Direction prev, Point fruta) {
	Point adelante = head.clone();
	Point izquierda = head.clone();
	Point derecha = head.clone();

	adelante.moveTo(prev);
	izquierda.moveTo(prev.turnLeft());
	derecha.moveTo(prev.turnRight());

	double a = distancia(adelante, fruta);
	double b = distancia(izquierda, fruta);
	double c = distancia(derecha, fruta);

	if(a < b && a < c)
	    return prev;
	else if(b < c)
	    return prev.turnLeft();
	else
	    return prev.turnRight();
    }

    public Point buscarFrutaMasCercana(Point head, List<Point> fruits) {
	Point fr = fruits.get(0);

	for(Point f : fruits) {
	    if(distancia(head, f) < distancia(head, fr))
		fr = f;
	}

	return fr;
    }

    public double distancia(Point a, Point b) {
	return Math.sqrt(Math.pow(a.getX() - b.getX(), 2)
				+ Math.pow(a.getY() - b.getY(), 2));
    }
}

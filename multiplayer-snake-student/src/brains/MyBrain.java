package brains;

import java.util.List;

import edu.unlam.snake.brain.Brain;
import edu.unlam.snake.engine.Direction;
import edu.unlam.snake.engine.Point;

public class MyBrain extends Brain {

    public MyBrain() {
	super("IdLoom1 | IdLoom2 | IdLoom3");
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

//	if(previous == Direction.UP || previous == Direction.DOWN) {
//	    if(fr.getX() < head.getX()) {
//		if(previous == Direction.UP)
//		    r = r.turnLeft();
//		else
//		    r = r.turnRight();
//	    }
//	    else {
//		if(previous == Direction.UP)
//		    r = r.turnRight();
//		else
//		    r = r.turnLeft();
//	    }
//	}
//	else {
//	    if(fr.getY() < head.getY()) {
//		if(previous == Direction.RIGHT)
//		    r = r.turnLeft();
//		else
//		    r = r.turnRight();
//	    }
//	    else {
//		if(previous == Direction.LEFT)
//		    r = r.turnRight();
//		else
//		    r = r.turnLeft();
//	    }
//	}

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

	for(Point obstacle : obstacles) {
	    if(myNextHead.equals(obstacle)) {
		posibleHead.moveTo(r.turnRight());
		if(posibleHead.equals(obstacle))
		    return r.turnLeft();
		else
		    r = r.turnRight();
	    }
	}

	return r;
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

package brains;

import java.util.List;

import edu.unlam.snake.brain.Brain;
import edu.unlam.snake.engine.Direction;
import edu.unlam.snake.engine.Point;

public class MyBrainF extends Brain {

    public MyBrainF() {
	super("Nunez Carolina | Juarez Emanuel | Couzo Eduardo");
//		throw new RuntimeException("Agregar ids loom");

    }

    public Direction getDirection(Point head, Direction previous) {
	Direction nuevaDir = previous;
	List<Point> fruits = info.getFruits();
	List<Point> snake = info.getSnake();
	List<List<Point>> enemies = info.getEnemies();
	List<Point> obstacles = info.getObstacles();
	Point myNextHead = head.clone();
	Point posibleHead = head.clone();
	boolean der = true;
	boolean adelante = true;
	Point frutaMinima = fruits.get(fruits.size() - 1);

	nuevaDir = buscarCirculito(head, nuevaDir, frutaMinima);
	myNextHead.moveTo(nuevaDir);
	for(Point cuerpo : snake) {
	    if(myNextHead.equals(cuerpo)) {
		posibleHead.moveTo(nuevaDir.turnRight());
		adelante = false;
		if(posibleHead.equals(cuerpo)) {
		    der = false;
		}
	    }
	}
	for(Point obstacle : obstacles) {
	    if(myNextHead.equals(obstacle)) {
		posibleHead.moveTo(nuevaDir.turnRight());
		adelante = false;
		if(posibleHead.equals(obstacle)) {
		    nuevaDir = nuevaDir.turnLeft();
		    der = false;
		}
	    }
	}
	for(List<Point> enemigo : enemies) {
	    for(Point cuerpoEnemigo : enemigo) {
		if(myNextHead.equals(cuerpoEnemigo)) {
		    posibleHead.moveTo(nuevaDir.turnRight());
		    adelante = false;
		    if(posibleHead.equals(cuerpoEnemigo)) {
			der = false;
		    }
		}
	    }
	}
	if(adelante) {
	    return nuevaDir;
	}
	else if(der) {
	    return nuevaDir.turnRight();
	}
	else {
	    return nuevaDir.turnLeft();
	}
    }

    public Direction buscarCirculito(Point head, Direction prev, Point fruta) {
	Point lateralIzq = head.clone();
	Point lateralDer = head.clone();
	Point frontal = head.clone();

	lateralIzq.moveTo(prev.turnLeft());
	frontal.moveTo(prev);
	lateralDer.moveTo(prev.turnRight());

	if(manhathan(frontal, fruta) < manhathan(lateralIzq, fruta) && manhathan(frontal,
				fruta) < manhathan(lateralDer, fruta))
	    return prev;
	else if(manhathan(lateralIzq, fruta) < manhathan(lateralDer, fruta))
	    return prev.turnLeft();
	else
	    return prev.turnRight();
    }

    public double manhathan(Point a, Point b) {
	return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }
}

package scene;

import core.Direction;
import graphics.Rect;
import graphics.Shape;
import util.Constants;
import util.GameUtils;

public class Snake extends Shape {
	
	private Direction direction;
	private int piecesToElongate;
	
	public Snake() {
		super(Constants.SNAKE_COLOR);
		direction = Direction.NONE;
		
		//adiciona a cabe�a
		Rect rect = new Rect(Constants.SNAKE_INITIAL_X, Constants.SNAKE_INITIAL_Y, Constants.SNAKE_PIECE_SIZE, Constants.SNAKE_PIECE_SIZE);
		addRect(rect);
		
		for(int i = 1; i<Constants.SNAKE_SIZE; i++) {
			rect = duplicate(rect, Direction.LEFT);
			addRect(rect);
		}
	}
	
	public synchronized void move() {
		if(direction != Direction.NONE) {
		Rect head = getFirstRect();
		Rect tail = getLastRect();
		GameUtils.moveRect(getRects());
		Rect newHead = duplicate(head, direction);
		getRects().set(0, newHead);
		
		if(piecesToElongate > 0) {
			getRects().add(tail);
			piecesToElongate --;
		}
		
		}
	}
	
	public synchronized void up() {
		if(direction.canChangeTo(Direction.UP)) {
		direction = Direction.UP;
		}
	}
	public synchronized void down() {
		if(direction.canChangeTo(Direction.DOWN)) {
		direction = Direction.DOWN;
		}
	}
	public synchronized void left() {
		if(direction.canChangeTo(Direction.LEFT)) {
		direction = Direction.LEFT;
		}
	}
	public synchronized void right() {
		if(direction.canChangeTo(Direction.RIGHT)) {
		direction = Direction.RIGHT;
		}
	}
	
	//metodo que verifica se a snake colide com ela msm
	public boolean collidesWithItself() {
		Rect head = getFirstRect();
		
		for(int i = 1; i < getRects().size(); i++) {
			Rect rect = getRects().get(i);
			if(head.intersects(rect)) {
				return true;
			}
		}
		return false;
	}
	//alonga a snake quando pega a comida
	public void elongate() {
		piecesToElongate = Constants.SNAKE_ELONGATE_PIECES;
	}
}

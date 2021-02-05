package scene;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import graphics.Rect;
import util.Constants;
import util.GameUtils;

public class Food extends Rect{

	private int eatenTimes;
	
	
	public Food(Rectangle drawingArea, Snake snake) {
		setRandomLocation(drawingArea,snake);
		setDimension(new Dimension(Constants.FOOD_SIZE, Constants.FOOD_SIZE ));
		setColor(Color.GREEN);
	}
	
	public void setRandomLocation(Rectangle drawingArea, Snake snake) {
		
	 do {
		int offset = 3;
		int x = GameUtils.random(
				(int) drawingArea.getMinX() + offset,
				(int) drawingArea.getMaxX() - offset - Constants.FOOD_SIZE
				);
		int y = GameUtils.random(
				(int) drawingArea.getMinY() + offset,
				(int) drawingArea.getMaxY() - offset - Constants.FOOD_SIZE
				);
		setLocation(new Point(x,y));
	 }while(snake.intersects(this));			
	}
	
	//método para ' comer ' a comida
	public void checkIfEaten(Snake snake, Rectangle drawingArea) {
		//verifica se 'pegou' a comida
		if(snake.intersects(this)) {
			//soma a pontuação
			eatenTimes++;
			//muda a localização da comida
			setRandomLocation(drawingArea, snake);
			snake.elongate();
			
		}
	}
	
	public int getEatenTimes() {
		return eatenTimes;
	}
}

package snake;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Rect extends Drawable{
	//point fornece as coordenadas x e y
	private Point location;
	//dimension fornece a altura e largura
	private Dimension dimension;

	public Rect(int x, int y,int width, int height) {
		this.location = new Point(x,y);
		this.dimension= new Dimension(width, height);
	
	}
	
	
	
	public Rect(Point location, Dimension dimension) {
		this.location = location;
		this.dimension = dimension;
		
	
	}



	public void draw(Graphics g) {
	
		g.fillRect((int)location.getX(),(int)location.getY(),(int)dimension.getWidth(),(int)dimension.getHeight());
	}
	


	public Point getPoint() {
		return location;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public Point getLocation() {
		return location;
	}
}

	
	



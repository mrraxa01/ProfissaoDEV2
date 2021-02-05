package core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import graphics.Renderer;
import scene.Snake;
import util.Constants;


public class GameWindow extends JFrame implements KeyListener {


	private static final long serialVersionUID = 1L;

	private Renderer renderer;
	private Snake snake;
	private Image buffer;
	private Graphics gImage;
	private Rectangle drawingArea;
	private long lastKeyboardEventTime;
	
	public GameWindow(Snake snake) {
		
		renderer = new Renderer();
		this.snake = snake;
		
		//titulo
		setTitle(Constants.GAME_TITLE);
		//tamanho da janela
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		// abre centralizado
		setLocationRelativeTo(null);
		//sair ao fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//informa que o próprio game window vai tratar os eventos de teclado
		addKeyListener(this);
		//visível
		setVisible(true);
		
		buffer = createImage(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		gImage = buffer.getGraphics();
		defineDrawingArea();
	}
	
	private void defineDrawingArea() {
		int upperY = Constants.WINDOW_HEIGHT - (int) getContentPane().getSize().getHeight();
		drawingArea = new Rectangle(0, upperY, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - upperY);
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		//toda vez que pressionar uma tecla será pego o momento
		long now = System.currentTimeMillis();
		
		//se o intervalo de pressionamento da tecla for menor de 40 milisegundos o último toque será descartado
		if(now - lastKeyboardEventTime < Constants.GAME_MIN_BETWEEN_KEYBOARD_EVENTS) {
			return;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			snake.up();
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			snake.down();
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			snake.left();
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			snake.right();
		}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
		lastKeyboardEventTime = now;
		
	}
	
	@Override
	public void paint(Graphics gScreen) {
		if(renderer != null && gImage != null && buffer != null) {
			renderer.render(gImage);
			gScreen.drawImage(buffer, 0, 0, null);
		}
	}
	
	public Renderer getRenderer() {
		return renderer;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	public Rectangle getDrawingArea() {
		return drawingArea;
	}
	
	
	
	
	
	
	
	 	
}

package snake;

import java.awt.Graphics;
import javax.swing.JFrame;


public class GameWindow extends JFrame {


	private static final long serialVersionUID = 1L;

	private Renderer renderer;
		
	public GameWindow() {
		
		renderer = new Renderer();
		
		
		//titulo
		setTitle(Constants.GAME_TITLE);
		//tamanho da janela
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		// abre centralizado
		setLocationRelativeTo(null);
		//sair ao fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//vis�vel
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		renderer.render(g);
	}
	
	public Renderer getRenderer() {
		return renderer;
	}
	 	
}

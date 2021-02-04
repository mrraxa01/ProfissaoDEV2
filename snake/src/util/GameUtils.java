package util;

import java.util.List;

import graphics.Rect;

public class GameUtils {

	public static void moveRect(List<Rect> rects) {
		for (int i = rects.size() -1; i >= 1; i--) {
			rects.set(i, rects.get(i - 1));
			
		}
	}
	
	public static void sleep(int millis) {
		//temporiza a execução do while em milisegundos
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		
		}
	}
}

package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;

public class MainGameLoop {

	public static void main(String[] args) {
		
		//abrimos el display
		
		DisplayManager.createDiplay();
		
		//creamos el loop del juego mientras se cierra el diplay
		
		while(!Display.isCloseRequested())
		{
			//logica del juego
			//render
			DisplayManager.updateDisplay();
		}
		
		//cuando la ventana se cierra destuimos el display
				DisplayManager.closeDisplay();
	}

}

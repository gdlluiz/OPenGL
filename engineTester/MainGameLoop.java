package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {

	public static void main(String[] args) {
		
		//abrimos el display
		
		DisplayManager.createDiplay();
		
		
		//cargamos el Render
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		
		// ponemos lista de vertices
		float[] vertices = {
				//left bottom triangle
				-0.5f, 0.5f, 0f,
				-0.5f, -0.5f, 0f,
				0.5f, -0.5f, 0f,
				
				//right top triangle
				0.5f, -0.5f, 0f,
				0.5f, 0.5f, 0f,
				-0.5f, 0.5f, 0f,
		};
		
		RawModel model = loader.loadToVAO(vertices);
		
		
		//creamos el loop del juego mientras se cierra el diplay
		
		while(!Display.isCloseRequested())
		{
			//preparamos el render cada loop
			renderer.prepare();
			//logica del juego
			//render
			renderer.render(model);
			DisplayManager.updateDisplay();
		}
		
		//liberamos memoria
		loader.cleanUP();
		//cuando la ventana se cierra destuimos el display
				DisplayManager.closeDisplay();
	}

}

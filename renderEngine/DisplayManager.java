package renderEngine;

import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	// se crea el alto y ancho del display
			private static final int WIDTH = 1280;
			private static final int HEIGHT = 720;
			private static final int FPS_CAP = 120;  //FPS frames per second
	
	// Metodo que crea el display
	public static void createDiplay()
	{		
		// se crea un conexto de atributos con la version openGL a usar 3.2
		ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
		
		try {
			// se determina el tamaño del display con la funcion
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			// se crea el display 
			Display.create(new PixelFormat(), attribs);
			
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		//determinamos to render el display usano la version OpenGL 1.1
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
		
	}

	//Metodo que hace update de los frames
	public static void updateDisplay()
	{
		//sincronizamos el display
		Display.sync(FPS_CAP);
		Display.update();
		
	}
	
	//Metodo que cierra el display
	public static void closeDisplay()
	{
		// solo se destruye el metodo
		Display.destroy();
	}
	
}

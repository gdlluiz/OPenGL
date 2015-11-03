package renderEngine;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Loader 
{
	//creamos una lista de todas las ID creadas de VAO & VBO
	private List<Integer> vaos = new ArrayList<Integer>();
	private List<Integer> vbos = new ArrayList<Integer>();


	//clase que va a tomar las posiciones del modelo Vertices VAOand return informatio
	// about VBO  	
	public RawModel loadToVAO(float[] positions)
	{
		//se crea un VAO vacio y se le asigna un ID
		int vaoID = createVAO();
		// se guarda la info en la lista de aributos
		storeDataInAttributeList(0,positions);
		unbindVAO();
		//retornamos los datos que creamos como informacion del RawModel
		//entre 3 porque cada vertex tiene tres puntos
		return new RawModel(vaoID, positions.length/3);
	}
	
	//borramos todos los VAO & VBO creados en memoria
	public void cleanUP()
	{
		for(int vao:vaos)
		{
			GL30.glDeleteVertexArrays(vao);
		}
		for(int vbo:vbos)
		{
			GL15.glDeleteBuffers(vbo);
		}
	}
	
	
	private int createVAO()
	{
		// se crea un VAO vacio y retorna el ID del VAO creado
		int vaoID = GL30.glGenVertexArrays();
		//cada vez que creamos un VAO lo agregamos a la lista para borrarlo despues
		vaos.add(vaoID);
		//se activa el VAO
		GL30.glBindVertexArray(vaoID);
		return vaoID;
		
	}
	
	// guarda la info en la lista de atributos
	private void storeDataInAttributeList(int attributeNumber, float[] data)
	{
		// se guardan los datos en modo VBO ( buffer)
		int vboID = GL15.glGenBuffers();
		//cada vez que creamos un VBO lo agregamos a la lista para borrarlo despues
		vbos.add(vboID);
		//se activa el vbo
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
		FloatBuffer buffer= storeDataInFloatBuffer(data); 	 
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(attributeNumber, 3, GL11.GL_FLAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER,0);
	}
	
	//un-bind the VAO
	
	private void unbindVAO()
	{
		GL30.glBindVertexArray(0);
	}

	// se guardan los datos como float buffer en un float array 
	private FloatBuffer storeDataInFloatBuffer(float[] data)
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip(); // se hace el cambio a lectura de datos
		return buffer;
	}
}

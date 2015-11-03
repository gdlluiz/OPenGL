package renderEngine;
//esta clase representa el modelo 3D que se guarda en memoria 
public class RawModel {
	
	private int vaoID;
	private int vertexCount;
	
	//constructor de la clase
	public RawModel(int vaoID, int vertexCount)
	{
		this.vertexCount = vertexCount;
		this.vaoID = vaoID;		
	}

	//generamos los getters
	public int getVaoID() {
		return vaoID;
	}

	public int getVertexCount() {
		return vertexCount;
	}
	
	

}

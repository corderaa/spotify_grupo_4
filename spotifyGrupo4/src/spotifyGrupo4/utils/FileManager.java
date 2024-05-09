package spotifyGrupo4.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


 

/**
 * The Object  to be stored  must implement Serializable. 
 * And to file must be a .dat
 */
public class FileManager {
	


	private  final String RUTA = ".\\files\\";

	public void writeObject(Object objeto, String ruta) throws IOException {
		 ruta = RUTA + ruta;
		try {
			FileOutputStream fileOutput = new FileOutputStream(ruta);
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
			outputStream.writeObject(objeto);
			fileOutput.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			throw  e;
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw  e;
			//e.printStackTrace();
		}
	}

	public Object readObject(String ruta) throws IOException {
		Object objeto = null;
		 ruta = RUTA + ruta;

		try {
			FileInputStream fileInput = new FileInputStream(ruta);
			try {
				ObjectInputStream objectInput = new ObjectInputStream(fileInput);
				objeto = (Object)objectInput.readObject();
				fileInput.close();
				objectInput.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw  e;
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw  e;
			//e.printStackTrace();
		}
		
		return objeto;
	}	
}
package ej1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ManejoFicheros {
	private static ObjectInputStream leer;
	Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();

	public void crearFicheroBinario(List<Alumno> alumnos) {
		try {
			FileOutputStream conexion = new FileOutputStream(new File("fichero.dat"));
			ObjectOutputStream escribir = new ObjectOutputStream(conexion);
			for (Alumno alumno : alumnos) {
				escribir.writeObject(alumno);
			}
			System.out.println("alumnos guardados exitosamente");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void leerFicheroBinario() {
		ObjectInputStream leer = null; // Declarar el objeto como null
		try {
			FileInputStream conexion = new FileInputStream("fichero.dat");
			leer = new ObjectInputStream(conexion);

			while (true) { // Intentamos leer indefinidamente
				try {
					Alumno a = (Alumno) leer.readObject();
					System.out.println(a.toString());
				} catch (EOFException e) {
					// Al llegar al final del archivo, salimos del bucle
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			cerrarLeer();
		}
	}

	public void CrearFicheroJson(List<Grupo> alumnoscongrupo) {
		try (FileWriter fw = new FileWriter("datos.json")) {
			gson.toJson(alumnoscongrupo, fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void leerFicheroJson(List<Grupo> alumnoscongrupo) {
		String json = gson.toJson(alumnoscongrupo);
		try {
			FileReader reader = new FileReader(new File("datos.json"));
			List<Grupo> deserializedList = gson.fromJson(reader, new TypeToken<List<Grupo>>() {}.getType());
			for (Grupo g : deserializedList) {
				System.out.println(g.toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void cerrarLeer() {
		if (leer != null) {
			try {
				leer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

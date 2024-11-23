package ej1;

import java.util.Scanner;

public class Menu {
	CreadorDeAlumnos c = new CreadorDeAlumnos();
	CreadorDeGrupos cg = new CreadorDeGrupos();
	ManejoFicheros m = new ManejoFicheros();
	ManejoBaseDeDatos mb = new ManejoBaseDeDatos();
	Scanner abielto = new Scanner(System.in);

	public void mostrarMenu() {
		System.out.println("1. Insertar nuevo alumno");
		System.out.println("2. Insertar nuevo grupo");
		System.out.println("3. Mostrar alumnos y Grupos");
		System.out.println("4. Guardar alumnos en un fichero Binario");
		System.out.println("5. Leer alumnos de fivhero Binario y guardar en BD");
		System.out.println("6. Modificar nombre de alumno por PK");
		System.out.println("7. Eliminar alumno por PK");
		System.out.println("8. Eliminar alumno por Curso");
		System.out.println("9. Guardar Grupos con Alumnos");
		System.out.println("10. Leer Fichoro Json");
		System.out.println("11. Salir");
	}

	public void elegir(int valor) {
		switch (valor) {
		case 1: {
			c.crear1Alumno(cg);
			break;
		}
		case 2: {
			cg.crearGrupo();
			break;
		}
		case 3: {
			c.mostrarAlumnos();
			cg.mostrarGrupos();
			break;
		}
		case 4: {
			m.crearFicheroBinario(c.getAlumnos());
			break;
		}
		case 5: {
			m.leerFicheroBinario();
			mb.guardarAlumnosEnBd(c.getAlumnos(), cg.getGrupos());
			break;
		}
		case 6: {
			System.out.println("que nia quieres buscar?");
			mb.modificarNombreAlumnoPorPk(abielto.nextInt());
			abielto.nextLine();
			break;
		}
		case 7: {
			System.out.println("que nia quieres eliminar?");
			mb.eliminarAlumnoPorpK(abielto.nextInt());
			abielto.nextLine();
			break;
		}
		case 8: {
			System.out.println("que curso quieres eliminar?, estos son los cursos que hay:");
			mb.ChuparAlumnoPorCurso();
			System.out.println("te lo vuelvo a preguntar, que alumnos por curso quieres eliminar?");
			mb.eliminarAlumnoPorCurso(abielto.nextLine());
			abielto.nextLine();
			break;
		}
		case 9: {
			m.CrearFicheroJson(cg.getGrupos());
		}
		case 10: {
			m.leerFicheroJson(cg.getGrupos());
		}

		}
	}
}

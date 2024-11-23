package ej1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CreadorDeAlumnos {
	private final Scanner abielto = new Scanner(System.in);
	private int nia, grupo;
	private String nombre, apellido, ciclo, curso;
	private char genero;
	private Date fechadenacimiento;
	private List<Alumno> alumnos = new ArrayList<Alumno>();

	public void crear1Alumno(CreadorDeGrupos g) {
		System.out.println("Dame El NIA pls");
		nia = abielto.nextInt();
		ComprobarSiHayGrupo(g);
		System.out.println("Dame El nombre pls");
		nombre = abielto.nextLine();
		System.out.println("Dame El apellido pls");
		apellido = abielto.nextLine();
		System.out.println("Dame El ciclo pls");
		ciclo = abielto.nextLine();
		System.out.println("Dame El curso pls");
		curso = abielto.nextLine();
		System.out.println("Dame El genero pls");
		genero = abielto.nextLine().charAt(0);
		System.out.println("Dame la fecha de nacimiento pls (yyyy-MM-dd)");
		try {
			fechadenacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(abielto.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		alumnos.add(new Alumno(nia, grupo, nombre, apellido, ciclo, curso, genero, fechadenacimiento));
		System.out.println("alumno creado con exito");
	}

	public void mostrarAlumnos() {
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.toString());
		}
	}

	public void ComprobarSiHayGrupo(CreadorDeGrupos g) {
		boolean encontrado = false;
		System.out.println("Dame El grupo pls");
		grupo = abielto.nextInt();
		abielto.nextLine();
		for (Grupo grupo : g.getGrupos()) {
			if (grupo.getId() == this.grupo) {
				encontrado = true;
				break;
			} else {
				encontrado = false;
			}
		}
		if (encontrado) {
			this.grupo = grupo;
			System.out.println("grupo encontrado y metido el alumno perfectamente");
		} else {
			System.out.println("el grupo no existe, vamos a crearlo");
			g.crearGrupoCuandoNoExiste(grupo);
		}
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
	
}

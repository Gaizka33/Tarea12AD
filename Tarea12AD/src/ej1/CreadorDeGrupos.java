package ej1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreadorDeGrupos {
	private final Scanner abielto = new Scanner(System.in);
	private int id;
	private String nombre;
	private List<Alumno> alumnos;
	private List<Grupo> grupos = new ArrayList<Grupo>();

	public void crearGrupo() {
		comprobarSiElGrupoExiste();
		System.out.println("Dame el nombre del grupo pls");
		nombre = abielto.nextLine();
		grupos.add(new Grupo(id, nombre));
	}

	public void crearGrupoCuandoNoExiste(int id) {
		this.id = id;
		System.out.println("Dame el nombre del grupo pls");
		nombre = abielto.nextLine();
		grupos.add(new Grupo(id, nombre));
	}

	public void comprobarSiElGrupoExiste() {
		boolean encontrado = false;
		System.out.println("Dame el Id del grupo pls");
		id = abielto.nextInt();
		abielto.nextLine();
		for (Grupo grupo : grupos) {
			if (grupo.getId() == this.id) {
				encontrado = true;
				break;
			} else {
				encontrado = false;
			}
		}
		if (encontrado) {
			System.out.println("el grupo ya existe, pon otro nuevo");
			comprobarSiElGrupoExiste();
		} else {
			System.out.println("Percecto my homie");
		}
	}
	
	public void mostrarGrupos() {
		for (Grupo grupo : grupos) {
			System.out.println(grupo.toString());
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Scanner getAbielto() {
		return abielto;
	}

}

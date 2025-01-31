package ej1;

import java.io.Serializable;
import java.util.Date;

public class Alumno implements Serializable {
	private int nia, grupo;
	private String nombre, apellido, ciclo, curso;
	private char genero;
	private Date fechadenacimiento;

	public Alumno(int nia, int grupo, String nombre, String apellido, String ciclo, String curso, char genero,
			Date fechadenacimiento) {
		super();
		this.nia = nia;
		this.grupo = grupo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciclo = ciclo;
		this.curso = curso;
		this.genero = genero;
		this.fechadenacimiento = fechadenacimiento;
	}

	@Override
	public String toString() {
		return "Alumno [nia=" + nia + ", grupo=" + grupo + ", nombre=" + nombre + ", apellido=" + apellido + ", ciclo="
				+ ciclo + ", curso=" + curso + ", genero=" + genero + ", fechadenacimiento=" + fechadenacimiento + "]";
	}

	public int getNia() {
		return nia;
	}

	public void setNia(int nia) {
		this.nia = nia;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public Date getFechadenacimiento() {
		return fechadenacimiento;
	}

	public void setFechadenacimiento(Date fechadenacimiento) {
		this.fechadenacimiento = fechadenacimiento;
	}

}

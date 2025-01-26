 package ej1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManejoBaseDeDatos {
	private final String Usuario = "root";
	private final String Paswd = "linarespajero";
	private final String url = "jdbc:mysql://localhost:3306/alumnoscongrupo";
	private final Scanner abielto = new Scanner(System.in);

	public Connection Conectar() {
		try {
			return DriverManager.getConnection(url, Usuario, Paswd);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void guardarAlumnosEnBd(List<Alumno> lista, List<Grupo> grupos) {
		resetearAlumnos();
		guardarGrupos(grupos);
		for (Alumno alumno : lista) {
			String query = "INSERT INTO alumno(NIA, NOMBRE, APELLIDO, GENERO, FECHANACIMIENTO, CICLO , CUROS, GRUPO)"
					+ "VALUES (?,?,?,?,?,?,?,?)";
			try (PreparedStatement partedelaquery = Conectar().prepareStatement(query)) {

				partedelaquery.setInt(1, alumno.getNia());
				partedelaquery.setString(2, alumno.getNombre());
				partedelaquery.setString(3, alumno.getApellido());
				partedelaquery.setString(4, String.valueOf(alumno.getGenero()));
				Date sqlDate = new Date(alumno.getFechadenacimiento().getTime());
				partedelaquery.setDate(5, sqlDate);
				partedelaquery.setString(6, alumno.getCiclo());
				partedelaquery.setString(7, alumno.getCurso());
				partedelaquery.setInt(8, alumno.getGrupo());

				partedelaquery.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void resetearAlumnos() {
		String delete = "DELETE FROM alumno";
		try (Statement query = Conectar().createStatement()) {
			query.executeUpdate(delete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarNombreAlumnoPorPk(int Nia) {
		String query = "UPDATE Alumno SET NOMBRE = ? WHERE NIA = ?";

		try (PreparedStatement partedelaquery = Conectar().prepareStatement(query)) {
			System.out.println("cual quieres que sea sun nuevo nommbre?");
			partedelaquery.setString(1, abielto.nextLine());
			partedelaquery.setInt(2, Nia);
			partedelaquery.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarAlumnoPorpK(int Nia) {
		String delete = "DELETE FROM ALUMNO WHERE NIA =" + Nia;
		try (Statement query = Conectar().createStatement()) {
			query.executeUpdate(delete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ChuparAlumnoPorCurso() {
		String mostrar = "SELECT CUROS FROM ALUMNO";
		try (Statement query = Conectar().createStatement()) {
			ResultSet resultado = query.executeQuery(mostrar);

			while (resultado.next()) {
				String curso = resultado.getString("CUROS");
				System.out.println(curso);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminarAlumnoPorCurso(String curso) {
		String eliminar = "DELETE FROM ALUMNO WHERE CUROS = " + curso;

		try (Statement query = Conectar().createStatement()) {
			query.executeUpdate(eliminar);
			System.out.println("alumnos eliminados");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void guardarGrupos(List<Grupo> grupos) {
		resetearGrupos();
		for (Grupo grupo : grupos) {
			String query = "INSERT INTO grupo(ID, NOMBRE)" + "VALUES (?,?)";
			try (PreparedStatement partedelaquery = Conectar().prepareStatement(query)) {
				partedelaquery.setInt(1, grupo.getId());
				partedelaquery.setString(2, grupo.getNombre());

				partedelaquery.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void resetearGrupos() {
		String delete = "DELETE FROM GRUPO";
		try (Statement query = Conectar().createStatement()) {
			query.executeUpdate(delete);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void guardarTodosLosAlumnosDeGrupos(List<Grupo> grupos) {
		for (Grupo g : grupos) {
			String chupar = "SELECT a.NIA, a.NOMBRE, a.APELLIDO, a.GENERO, a.FECHANACIMIENTO, a.CICLO, a.CUROS, a.GRUPO FROM ALUMNO a"
					+ " LEFT JOIN GRUPO g ON a.GRUPO = g.ID WHERE g.ID = " + g.getId();

			List<Alumno> alumnos = new ArrayList<>();

			try (Statement query = Conectar().createStatement()) {
				ResultSet resultado = query.executeQuery(chupar);

				while (resultado.next()) { 
					// Retrieve data for each student
					int nia = resultado.getInt("NIA");
					String nombre = resultado.getString("NOMBRE");
					String apellido = resultado.getString("APELLIDO");
					char genero = resultado.getString("GENERO").charAt(0);
					Date fechaNacimiento = resultado.getDate("FECHANACIMIENTO");
					String ciclo = resultado.getString("CICLO");
					String curso = resultado.getString("CUROS");
					int grupo = resultado.getInt("GRUPO");

					// Create Alumno object and add it to the list
					Alumno alumnoParaGrupo = new Alumno(nia, grupo, nombre, apellido, ciclo, curso, genero,
							fechaNacimiento);
					alumnos.add(alumnoParaGrupo);
					g.setListaAlumnos(alumnos);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
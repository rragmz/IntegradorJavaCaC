package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conexion {
	public String driver = "com.mysql.cj.jdbc.Driver";

	public Connection getConnection() throws ClassNotFoundException {
		Connection conexion = null;

		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/integradorcac", "root", "4953");
		} 
		catch (SQLException e) {
			System.out.println("Error de conexion");
		}
		return conexion;
	}

	// Pruebo si anda la BBDD con main
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conexion = null;
		conexion con = new conexion();
		conexion = con.getConnection();

		PreparedStatement ps;
		ResultSet rs;

		ps = conexion.prepareStatement("select * from alumnos");
		rs = ps.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id_alumno");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			int dni = rs.getInt("dni");
			String mail = rs.getString("mail");


			System.out.println("Id: " + id + " Nombre: " + nombre + " Apellido: " + apellido + " DNI: " + dni
					+ " Mail: " + mail);
		}
	}
}

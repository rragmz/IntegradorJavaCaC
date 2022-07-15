package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnosDAO {
	//Armamos la conexión
	Connection conexion;
	
	public AlumnosDAO() throws ClassNotFoundException
	{
		conexion con = new conexion();
		conexion = con.getConnection();
	}
	
	public List<Alumnos> listarAlumnos()
	{
		PreparedStatement ps;
		ResultSet rs;
		List<Alumnos> lista = new ArrayList<>();
		
		try 
		{
			ps = conexion.prepareStatement("select * from alumnos");
			rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				int id=rs.getInt("id_alumno");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int dni = rs.getInt("dni");
				String mail = rs.getString("mail");
				
				//Instancio un objeto del tipo Socios
				Alumnos alumno = new Alumnos(id, nombre, apellido, dni, mail);
				lista.add(alumno);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion AlumnosDAO");
			return null;
		}
		return lista;
	}
	
	//Mostrar un alumno
		public Alumnos mostrarAlumno(int id_al)
		{
			PreparedStatement ps;
			ResultSet rs;
			Alumnos alumno = null;
			
			try 
			{
				ps = conexion.prepareStatement("select * from alumnos where id_alumno=?");
				ps.setInt(1, id_al);
				rs = ps.executeQuery();
				while(rs.next()) 
				{
					int id=rs.getInt("id_alumno");
					String nombre = rs.getString("nombre");
					String apellido = rs.getString("apellido");
					int dni = rs.getInt("dni");
					String mail = rs.getString("mail");

					alumno = new Alumnos(id, nombre,apellido,dni,mail);
				}
				return alumno;
			}
			catch(SQLException e) 
			{
				System.out.println("Error al insertar dato");
				return null;
			}
		}
	
	public boolean insertarAlumno(Alumnos alumno) 
	{
		PreparedStatement ps;
		
		//Siempre que algo pueda fallar try-catch
		try 
		{
			ps = conexion.prepareStatement("insert into alumnos (nombre,apellido,dni,mail) values (?,?,?,?)");
			//ps.setString(0, null);
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getApellido());
			ps.setInt(3, alumno.getDni());
			ps.setString(4, alumno.getMail());
			
			ps.execute();
			return true;
		}
		catch(SQLException e) 
		{
			System.out.println("Error al insertar dato");
			return false;
		}
	}
	
	//En vez de insertar, va a modificar
	public boolean actualizarAlumno(Alumnos alumno) 
	{
		PreparedStatement ps;
		
		//Siempre que algo pueda fallar try-catch
		try 
		{
			//Detallamos ID para que no actualice todo
			ps = conexion.prepareStatement("update alumnos set nombre=?,apellido=?,dni=?, mail=? where id_alumno=?");
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getApellido());
			ps.setInt(3, alumno.getDni());
			ps.setString(4, alumno.getMail());
			ps.setInt(5, alumno.getId_alumno());
			
			ps.execute();
			return true;
		}
		catch(SQLException e) 
		{
			System.out.println("Error al insertar dato");
			return false;
		}
	}
	
	//Método para eliminar -> solo necesita el id
	public boolean eliminarAlumno(int id_al) 
	{
		PreparedStatement ps;
		try
		{
			ps = conexion.prepareStatement("delete from alumnos where id_alumno=?");
			ps.setInt(1, id_al);
			ps.execute();
			return true;
		}
		catch(SQLException e) 
		{
			System.out.println("Error al eliminar");
			return false;
		}
	}
	
	
} 


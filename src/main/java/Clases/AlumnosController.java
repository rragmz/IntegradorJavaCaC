package Clases;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AlumnosController")
public class AlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AlumnosController() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String accion;
		AlumnosDAO alumnoDAO = null;
		try {
			alumnoDAO = new AlumnosDAO();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		//El requerimiento a la página jsp
		RequestDispatcher dispatcher = null;
		
		//Lo que el formulario me devuelva como accion me lo guarda en este String
		accion = request.getParameter("accion");
		if(accion == null || accion.isEmpty()) 
		{
			dispatcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
		}
		else if(accion.equals("modificar"))
		{
			dispatcher = request.getRequestDispatcher("Vistas/modificar.jsp");
		}
		else if(accion.equals("actualizar"))
		{
			
			int id=Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int dni=Integer.parseInt(request.getParameter("dni"));
			String mail = request.getParameter("mail");
			
			Alumnos alumno = new Alumnos(id, nombre, apellido, dni, mail);
		
			alumnoDAO.actualizarAlumno(alumno);
			dispatcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
		}
		else if(accion.equals("eliminar"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			alumnoDAO.eliminarAlumno(id);
			dispatcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
		}
		else if(accion.equals("nuevo"))
		{
			dispatcher = request.getRequestDispatcher("Vistas/nuevo.jsp");
		}
		else if(accion.equals("insert"))
		{
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int dni=Integer.parseInt(request.getParameter("dni"));
			String mail = request.getParameter("mail");
			
			Alumnos alumno = new Alumnos(0,nombre,apellido,dni,mail);
			alumnoDAO.insertarAlumno(alumno);
			dispatcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
		}
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

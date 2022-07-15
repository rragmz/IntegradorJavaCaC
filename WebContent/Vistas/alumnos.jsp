<%@page import="Clases.AlumnosDAO"%>
<%@page import="Clases.Alumnos"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Alumnos</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/26f9c1f2c0.js" crossorigin="anonymous"></script>
</head>
<body>
	<h1 class="text-center" style="margin: 20px 0;">Listado de Alumnos</h1>
	<div class="container">
		<div class="row">
			<a class="btn btn-success col-3 m-1" href="AlumnosController?accion=nuevo">Agregar alumno</a>
			<table class="table table-info">
				<thead>
					<th>ID</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>
					<th>Mail</th>
					<th class="text-center">Modificar</th>
					<th class="text-center">Eliminar</th>
				</thead>
				<%
				List<Alumnos> resultado = null;
				AlumnosDAO alumno = new AlumnosDAO();
				resultado = alumno.listarAlumnos();

				for (int i = 0; i < resultado.size(); i++) {
					String ruta = "AlumnosController?accion=modificar&id=" + resultado.get(i).getId_alumno();
					String rutaE = "AlumnosController?accion=eliminar&id=" + resultado.get(i).getId_alumno();
				%>
				<tr>
				<td><%=resultado.get(i).getId_alumno()%></td>
				<td><%=resultado.get(i).getNombre()%></td>
				<td><%=resultado.get(i).getApellido()%></td>
				<td><%=resultado.get(i).getDni()%></td>
				<td><%=resultado.get(i).getMail()%></td>
				<td class="text-center"><a href=<%=ruta%>><i class="fa-solid fa-pencil"></i></a></td>
				<td class="text-center"><a href=<%=rutaE%>><i class="fa-solid fa-trash"></i></a></td>
				</tr>
				<%
				//Cierro el for
				}
				%>
			</table>
		</div>
	</div>
</body>
</html>
</body>
</html>
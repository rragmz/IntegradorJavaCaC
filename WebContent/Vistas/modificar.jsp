<%@page import="Clases.AlumnosDAO"%>
<%@page import="Clases.Alumnos"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Alumno</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
		<h1 class="text-center">Modificar Alumno</h1>
		<div class="row">
		<%
		String id=request.getParameter("id");
		int mid;
		mid = Integer.parseInt(id);
		
		Alumnos resultado = null;
		AlumnosDAO alumno = new AlumnosDAO();
		resultado = alumno.mostrarAlumno(mid);
		%>
			<form class="p-5" action="AlumnosController?accion=actualizar" method="post">
				<div class="mb-3">
 					<label for="id" class="form-label"></label>
					<input type="hidden" class="form-control" id="id" name="id" value=<%=resultado.getId_alumno() %>>
				</div>
				<div class="mb-3">
					<label for="nombre" class="form-label">Nombre</label>
					<input type="text" class="form-control" id="nombre" name="nombre" value=<%=resultado.getNombre() %>>
				</div>
				<div class="mb-3">
					<label for="apellido" class="form-label">Apellido</label>
					<input type="text" class="form-control" id="apellido" name="apellido" value=<%=resultado.getApellido() %>>
				</div>
				<div class="mb-3">
					<label for="dni" class="form-label">DNI</label>
					<input type="number" class="form-control" id="dni" name="dni" value=<%=resultado.getDni() %>>
				</div>
				<div class="mb-3">
					<label for="mail" class="form-label">Mail</label>
					<input type="email" class="form-control" id="mail" name="mail" value=<%=resultado.getMail() %>>
				</div>
				<button type="submit" class="btn btn-success">Modificar</button>
			</form>
		</div>
	</div>
</body>
</html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>

<jsp:include page="./utils/head.jsp">
	<jsp:param value="Tareas" name="pagetitle"/>
</jsp:include>
<body class="container">
	<jsp:include page="./utils/header.jsp">
		<jsp:param value="tareas" name="page" />
	</jsp:include>
		<section>
		<c:out value="Hola ${user.nombre},"></c:out>

		<ul class="list-group">
			<c:forEach items="${tareas}" var="tarea">
			<li class="list-group-item">
				<div>${tarea.tid}</div>
				<div>${tarea.descripcion}</div>
				<div>${tarea.estado}</div> 
				<div>
				<a href="./tareas/detalle?tid=${tarea.tid}"><span class="glyphicon glyphicon-eye-open"></span></a></div> 
				<c:if test="${tarea.estado>=3}">
					<div><a href="#" class="borrar-tarea" data-tid="${tarea.tid}"><span class="glyphicon glyphicon-trash"></span></a></div>
				</c:if>
			</li>
			</c:forEach>
		</ul>
	</section>
	<footer> Pie de página </footer>

</body>
<jsp:include page="./utils/foot.jsp"></jsp:include>

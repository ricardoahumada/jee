<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tl" %>

<tl:head pagetitle="Tareas"></tl:head>
<body class="container">
	
	<tl:header page="tareas" style="rojo"></tl:header>
	
		<section>
		<c:out value="Hola ${user.nombre}, aquí tienes tus tareas:"></c:out>

		<ul class="list-group">
			<c:forEach items="${tareas}" var="tarea">
			<li class="list-group-item">
				<div>${tarea.tid}</div>
				<div>${tarea.descripcion}</div>
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
	<tl:footer></tl:footer>

</body>
<jsp:include page="./utils/foot.jsp"></jsp:include>

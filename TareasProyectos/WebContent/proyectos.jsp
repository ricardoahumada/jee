<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tl" %>

<tl:head pagetitle="Tareas"></tl:head>
<body class="container">
	
	<tl:header page="proyectos" style="rojo"></tl:header>
	
		<section>
		<c:out value="Hola ${user.nombre}, aquí tienes tus proyectos:"></c:out>

		<ul class="list-group">
			<c:forEach items="${proyectos}" var="proj">
			<li class="list-group-item">
				<div>${proj.pid}</div>
				<div>${proj.titulo}</div>
				<br />
				<div>
					<h4>Tareas:</h4>
					<ul>
					<c:forEach items="${proj.tareas}" var="tarea">
						<li>${tarea.tid} | ${tarea.descripcion}</li>
					</c:forEach>
					</ul>
				</div>
				
			</li>
			</c:forEach>
		</ul>
		
	</section>
	<tl:footer></tl:footer>

</body>
<jsp:include page="./utils/foot.jsp"></jsp:include>

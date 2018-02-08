<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tl"%>

<tl:head pagetitle="Tareas"></tl:head>
<body class="container">
	<tl:header page="dashboard" style="rojo"></tl:header>
	
	<section class="col-lg-6">
		<h2>Tu datos</h2>
		<div>
		<ul>
			<li>${datos_dashboard["datos_usuario"].nombre}</li>
			<li>${datos_dashboard["datos_usuario"].apellido}</li>
			<li>${datos_dashboard["datos_usuario"].email}</li>
		</ul>
		</div>
	</section>

	<section class="col-lg-6">
		<h2>Tus tareas</h2>
		<div>
			<ul class="list-group">
				<c:forEach items='${datos_dashboard["lista_tareas_usuario"]}' var="tarea">
					<li class="list-group-item">
						<div>${tarea.tid}</div>
						<div>${tarea.descripcion}</div>
						<div>${tarea.estado}</div>
						<div>
							<a href="./tareas/detalle?tid=${tarea.tid}"><span
								class="glyphicon glyphicon-eye-open"></span></a>
						</div> <c:if test="${tarea.estado>=3}">
							<div>
								<a href="#" class="borrar-tarea" data-tid="${tarea.tid}"><span
									class="glyphicon glyphicon-trash"></span></a>
							</div>
						</c:if>
					</li>
				</c:forEach>
			</ul>
			
		</div>
	</section>
	
	<section class="col-lg-6">
		<h2>Tus proyectos</h2>
		<div>
			<ul class="list-group">
				<c:forEach items='${datos_dashboard["lista_proyectos_usuario"]}' var="proj">
					<li class="list-group-item">
						<div>${proj.pid}</div>
						<div>${proj.titulo}</div>
					</li>
				</c:forEach>
			</ul>
			
		</div>
	</section>

</body>
<jsp:include page="./utils/foot.jsp"></jsp:include>

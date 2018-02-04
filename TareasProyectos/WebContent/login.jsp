<jsp:include page="./utils/head.jsp">
	<jsp:param value="Login" name="pagetitle"/>
</jsp:include>
<body class="container">
	<section class="login-section text-center col-sm-4 col-sm-offset-4">
		<h1>TareasProy App</h1>
		
		<div class="alert-danger">${error}</div>
		
		<form method="POST" action="">
			<div class="form-group">
				<input type="email" class="form-control" placeholder="Introduce tu email" name="email" />
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder="Introduce tu contraseña" name="pass" />
			</div>
			<button class="btn btn-primary btn-lg btn-block">Entrar</button>
		</form>
	</section>
</body>
<jsp:include page="./utils/foot.jsp"></jsp:include>

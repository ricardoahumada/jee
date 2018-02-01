<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	
	<title>Login</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
</head>
<body>
	<section class="container text-center">
		<h1>TareasProy App</h1>
		<div class="error"><%=request.getAttribute("error")%></div>
		<form method="POST" action="">
			<div class="form-group">
				<input type="email" placeholder="Introduce tu email" name="email" />
			</div>
			<div class="form-group">
				<input type="password" placeholder="Introduce tu contraseñe" name="pass" />
			</div>
			<button>Entrar</button>
		</form>
	</section>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</html>
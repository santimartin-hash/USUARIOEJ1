<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inicio de sesión</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
	<style>
		.container {
			margin-top: 50px;
		}

		.card {
			box-shadow: 0px 1px 10px rgba(0, 0, 0, 0.3);
			border-radius: 10px;
			border: none;
		}

		.card-header {
			background-color: #2c3e50;
			color: white;
			border-radius: 10px 10px 0px 0px;
			border: none;
			text-align: center;
			font-size: 30px;
			font-weight: bold;
			padding-top: 20px;
			padding-bottom: 20px;
		}

		.card-body {
			padding: 50px;
		}

		.form-group {
			margin-bottom: 30px;
		}

		.form-control {
			border-radius: 30px;
			height: 50px;
			font-size: 18px;
		}

		.btn-primary {
			border-radius: 30px;
			height: 50px;
			font-size: 18px;
			background-color: #2c3e50;
			border: none;
			width: 100%;
			margin-top: 20px;
			transition: all 0.2s ease-in-out;
		}

		.btn-primary:hover {
			background-color: #34495e;
		}

		.btn-forgot {
			font-size: 16px;
			color: #2980b9;
			margin-top: 10px;
			display: block;
			text-align: center;
		}

		.btn-forgot:hover {
			color: #2c3e50;
		}

		.error {
			color: red;
			font-size: 14px;
			margin-top: 10px;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-5 col-md-8">
				<div class="card">
					<div class="card-header">
						Iniciar sesión
					</div>
					<div class="card-body">
						<form method="post" action="Login">
							<div class="form-group">
								<label for="username"><i class="fas fa-user"></i> Usuario</label>
								<input type="text" class="form-control" id="username" name="username" placeholder="Ingrese su nombre de usuario">
							</div>
							<div class="form-group">
								<label for="password"><i class="fas fa-lock"></i> Contraseña</label>
								<input type="password" class="form-control" id="password" name="password" placeholder="Ingrese su contraseña">
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i> Ingresar</button>
							</div>
							<div class="form-group">
							</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
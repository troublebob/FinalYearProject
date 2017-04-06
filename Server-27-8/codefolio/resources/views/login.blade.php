<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta name="description" content="This is an awesome login page" />
		<meta name="author" content="Rob Foran" />
		
		<title>Login</title>

		<!-- Bootstrap core CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />

		<!-- Custom styles for this template -->
		<link rel="stylesheet" href="{{ asset("css/login.css") }}" />
		
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>

		<div class="container">

			<div class="header h1 text-center">
				CodeFolio Login
			</div>
		
			<form class="form-signin" action="{{ route("login.post") }}" method="post">
				<h2 class="form-signin-heading">Please log in</h2>
				<label for="inputEmail" class="sr-only">Email address</label>
				<input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" value="{{ old("email") }}" required autofocus />
				<label for="inputPassword" class="sr-only">Password</label>
				<input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required />
				<div class="checkbox">
					<label>
						<input type="checkbox" value="remember-me" /> Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
			</form>

		</div> <!-- /container -->

		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	</body>
</html>

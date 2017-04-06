<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta name="description" content="This is an awesome home page" />
		<meta name="author" content="Rob Foran" />
		
		<title>CodeFolio - @yield('title')</title>

		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>

		<!-- Bootstrap core CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
		<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

		<!-- Custom styles for this template -->
		<!-- <link rel="stylesheet" href="{{ asset("css/home.css") }}" /> -->
		
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>

	<body onload="setTimeout(function() {
		//location.reload(true);
	}, 500);">

		<nav class="navbar navbar-default navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<a href="#" class="navbar-brand">CodeFolio</a>
				</div>
				<div class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">
							Logged in as: {{ Auth::user()->name }}
						</a>
						<ul class="dropdown-menu">
							<li><a href="{{ route("logout") }}">Logout</a></li>
						</ul>
					</li>
				</div>
			</div>
		</nav>

		<div class="container">

			@yield('content')

		</div>

		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<script src="js/ie10-viewport-bug-workaround.js"></script>
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cabecalho</title>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstraptheme.min.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js">
</script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-fixed-top navbar-inverse"
				role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Jornal</span>
					</button>
					<a class="navbar-brand" href="home"> Jornal </a>
				</div>

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				 	<ul class="nav navbar-nav">
						<li> <a href="#"> Classificados </a> </li>
						<li> <a href="cadastrar"> <span class="glyphicon glyphicon-pencil"></span>  Inscreva-se</a></li>
						<li class="active"> <a href="#"> <span class="glyphicon glyphicon-log-in"></span>  Entrar</a></li>

					</ul>
					<form class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control">
						</div>
						<button type="submit" class="btn btn-default">Pesquisar  <span class="glyphicon glyphicon-search"></span></button>
					</form>
				</div>
			</nav>
		</div>
	</div>

</body>
</html>
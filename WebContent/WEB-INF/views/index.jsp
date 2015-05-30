<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<title>Jornal!</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstraptheme.min.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</head>

<body
	style="background-image: url(http://st.depositphotos.com/1000147/1874/v/950/depositphotos_18748187-Vector-newspaper-with-non-existent-language-background.jpg);">
	<div class="container">
<!-- cabecalho -->
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default navbar-fixed-top navbar-inverse"
					role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Jornal</span>
						</button>
						<a class="navbar-brand" href="home"> <strong>Jornal</strong></a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="#">Classificados</a></li>
							<li><a href="cadastrar"><span class="glyphicon glyphicon-pencil"></span>  Inscreva-se</a></li>
<!-- Fazer login -->
							<li class="active">
								<a href="#" ><span class="glyphicon glyphicon-log-in"> </span>  Entrar</a>
							</li>
<!-- Fim do login -->
						</ul>
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control">
							</div>
							<button type="submit" class="btn btn-muted">Pesquisar  <span class="glyphicon glyphicon-search"></span></button>
						</form>
					</div>
				</nav>
			</div>
		</div>
<!-- Lista todas as secoes -->
		<div class="row clearfix" style="padding-top: 75px; padding-bottom: 75px;">
			<s:forEach var="secao" items="${secoes}">
				<div class="col-md-4 column">
					<a href="noticiasDaSecao?id=${secao.id}"> <img alt="140x140"
						src="http://lorempixel.com/140/140/"
						class="img-circle center-block" />
					</a>
					<!-- Cria mapping  das secoes -->
					<h2 class="text-center"> 
						<strong >
						<a href="noticiasDaSecao?id=${secao.id}" style="color:black;"> ${secao.titulo} </a>
						</strong>
					</h2>
				</div>
			</s:forEach>
		</div>
<!-- Rodape -->
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default navbar-fixed-bottom navbar-inverse" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							
						</button>
						<a class="navbar-brand" href="home">Jornal</a>
					</div>
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">Contato</a></li>
							<li class="active"><a href="#">Sobre</a></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>

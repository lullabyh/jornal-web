<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<title>Cadastro</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstraptheme.min.css">
<link rel="stylesheet" href="http://dontpad.com/mariana/css/style.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</head>

<body style="background-image: url(http://st.depositphotos.com/1000147/1874/v/950/depositphotos_18748187-Vector-newspaper-with-non-existent-language-background.jpg);">
<!-- Inicio do div container -->
	<div class="container">
<!-- cabecalho -->
	<c:import url="cabecalho.jsp"></c:import>

<!-- Cadastro de Leitor -->
		<div class="row clearfix " style="padding-top: 75px; padding-bottom: 75px;">
		    <div class="col-md-3 column">	
		    </div>
		    <div class="col-md-6 column well">
		    	<h3>Cadastre-se</h3>
		    	<div></div>
			    <form role="form" action="inserirCadastro" method="post">
			    	<div class="form-group">
					     <label for="name">Name</label>
					     <input class="form-control" name="nome" type="text" placeholder="Digite seu nome...">
				    </div>
				    <div class="form-group">
					     <label for="email">Email address</label>
					     <input class="form-control" name="email" type="email" placeholder="Digite seu email..."/>
				    </div>
				    <div class="form-group">
					     <label for="login">Login</label>
					     <input class="form-control" name="login" type="text" placeholder="Digite seu login..."/>
				    </div>
				    <div class="form-group">
					     <label for="password">Password</label>
					     <input class="form-control" name="senha" type="password" placeholder="Digite sua senha..."/>
				    </div>
				    <!-- Verificar se vai continuar aqui -->
				    <div class="form-group">
					     <label class="control-label">Tipo de Usuario </label>
					     <select class="form-control" id="role">
				          <option >Leitor</option>
				          <option>Jornalista</option>
				          <option>Editor</option>
				        </select>
				    </div> <button type="submit" class="btn btn-default">Submit</button>
			    </form>
		    </div>
		    <div class="col-md-3 column">
		    </div>
		</div>
		
<!-- Rodape -->
		<c:import url="rodape.jsp"></c:import>
<!-- Fim do div container -->
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Noticias Da Secao</title>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstraptheme.min.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>

<!--  style="background-color:#BFC1D2;" -->
<body style="background-image: url(http://st.depositphotos.com/1000147/1874/v/950/depositphotos_18748187-Vector-newspaper-with-non-existent-language-background.jpg);">
	<div class="container">
	
<!-- Cabecalho -->
		<c:import url="cabecalho.jsp"></c:import>

<!-- menu de secao e secao -->
		<div style="padding-top: 75px;">
		</div>
		<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-static-top">
			  <div class="container-fluid">
			    <div class="navbar-header">
			        <ul class= "nav navbar-nav">
			        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu  <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			          	<c:forEach var="secao" items="${secoes }">
		                 	<li><a href="noticiasDaSecao?id=${secao.id }">${secao.titulo }</a></li>
		                </c:forEach>
			          </ul>
			        </li>
			        </ul>
			    </div>
			    <div>
			      <ul class=" nav navbar-nav">
			      	<li class="divider active"><a href="noticiasDaSecao?id=${secaoAtual.id }"> ${secaoAtual.titulo }</a></li>
			      </ul>
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>obs Alterar icone</a></li>
			      </ul>
			    </div>
			  </div>
			</nav>
		</div>
		</div>

<!-- Lista as ultimas noticias de todas as noticias -->
		<div class="row clearfix" style="padding-top: 0px;">
			<div class="col-md-12 column">
				<div class="carousel slide" id="mycarousel" data-ride="carousel">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0" data-target="#mycarousel">
						</li>
						<li data-slide-to="1" data-target="#mycarousel"></li>
						<li data-slide-to="2" data-target="#mycarousel"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<a href="lerNoticia?id=${primeira.id}">
								<img alt="" src="http://lorempixel.com/1600/500/" />
							</a>
							<div class="carousel-caption">
								<h2 >
									<a href="lerNoticia?id=${primeira.id}"  style="color:white;" >${primeira.titulo}</a> 
								</h2>
								<h3 >
									<a href="lerNoticia?id=${primeira.id}" style="color:white;" >${primeira.subtitulo }</a> 
								</h3>
							</div>
						</div>
						<c:forEach var="noticia" items="${ultimasNoticias }">
							<div class="item ">
								<a href="lerNoticia?id=${noticia.id}">
									<img alt="" src="http://lorempixel.com/1600/500/" />
								</a>
								<div class="carousel-caption">
									<h2>
										<a href="lerNoticia?id=${noticia.id}" style="color:white;">${noticia.titulo }</a>
									</h2>
									<h3>
										<a href="lerNoticia?id=${noticia.id}" style="color:white;">${noticia.subtitulo }</a>
									</h3>
								</div>
							</div>
						</c:forEach>
					</div>
					<a class="left carousel-control" href="#mycarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#mycarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>
		</div>
<!-- Neste grid eh didivido em dois DIV uma para listar secao e o segundo para listar as noticias da secao atual -->
		<div class="row clearfix" style="padding-top: 50px; padding-bottom: 75px;">
			
<!-- Lista todas as noticias da secao selecionada -->
			
			<div class="col-md-9 column">
				<div class="row">
					<c:forEach var="noticia" items="${noticias}">
						<div class="col-md-4">
							<div class="thumbnail" >
								<a href="lerNoticia?id=${noticia.id}"><img alt="300x200" src="http://lorempixel.com/500/300/people" /></a>
								<div class="caption">
									<h3 style="min-height: 10px; max-height: 10px;">
										<a href="lerNoticia?id=${noticia.id}" style="color:black;">
											${noticia.titulo }
										</a>
									</h3>
									<br>
									<h4 style="min-height: 70px; max-height: 70px;">
										${noticia.subtitulo }</h4>
									<p>
										<a class="btn btn-default" href="lerNoticia?id=${noticia.id}">Leia mais</a>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			
<!-- Anuncios Classificados e propagandas -->
			
			<div class="col-md-3 column">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							Anuncios
						</h3>
					</div>
					<div class="panel-body">
						Listar Anuncio
					</div>
					<div class="panel-body">
						Listar Anuncio
					</div>
					<div class="panel-body">
						Listar Anuncio
					</div>
					<div class="panel-footer">
						Listar Anuncio
					</div>
				</div>
			</div>
		</div>

<!-- Rodape -->
		<c:import url="rodape.jsp"></c:import>
<!-- DIV do fim do container -->
	</div> 
</body>
</html>
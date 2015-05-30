<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Noticia</title>

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
<body style="background-image: url(http://st.depositphotos.com/1000147/1874/v/950/depositphotos_18748187-Vector-newspaper-with-non-existent-language-background.jpg);">
<!-- Integracao com o facebook -->

	<div id="fb-root"></div>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v2.3&appId=854443121294814";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
	</script>
<!--Inicio do div Container -->
	<div class="container">
	
<!-- Cabecalho -->
		<c:import url="cabecalho.jsp"></c:import>
		
<!-- menu de secao e secao -->
		<div style="padding-top: 50px; padding-bottom: 25px;">
		</div>
		<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-static-top">
			  <div class="container-fluid">
			    <div class="navbar-header">
			        <ul class= "nav navbar-nav">
			        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu  <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			          	<c:forEach var="secao" items="${listaDeSecoes }">
		                 	<li><a href="noticiasDaSecao?id=${secao.id }">${secao.titulo }</a></li>
		                </c:forEach>
			          </ul>
			        </li>
			        </ul>
			    </div>
			    <div>
			      <ul class=" nav navbar-nav">
			      	<li class="divider active"><a href="noticiasDaSecao?id=${nomeSecao.id }"> ${nomeSecao.titulo }</a></li>
			        <li class="divider"><a href="#">${noticia.titulo }</a></li>
			      </ul>
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Alterar icone</a></li>
			      </ul>
			    </div>
			  </div>
			</nav>
		</div>
		</div>
<!-- Noticia  -->
		<div class ="well">
		<div class="row clearfix">
			<div class="col-md-8 column" >
				<div class="page-header">
					<h1>
						${noticia.titulo } 
					</h1>
					<h5 class="text text-left">
						${noticia.dataNoticia }
						<br><small> ${noticia.autor }</small>
					</h5>
				</div>
				<img alt="140x140" src="http://lorempixel.com/300/300/" />
				<h2>
					${noticia.subtitulo }
				</h2>
				<p>
					${noticia.texto }		
				</p>
				<p>
					<a class="btn" href="#">View details »</a>
				</p>
<!-- Comentarios Facebook -->
				<div id="fbComentario" class="fb-comments" data-width="725" data-href="http://localhost:8080/jornal-v1/lerNoticia/${noticia.id}" data-numposts="3" data-colorscheme="dark"></div>
			</div>
<!-- Ultimas Noticias -->
			<div class="col-md-4 column" >
				<h2>
					Ultimas Noticias
				</h2>
				<c:forEach var="ultimaNot" items="${ultimasNoticias }">
					<div class="media">
						<a href="lerNoticia?id=${ultimaNot.id }" class="pull-left"><img src="http://lorempixel.com/64/64/" class="media-object" alt='' /></a>
						
						<div class="media-body" >
						<h3 class="media-heading" >
								<a href="lerNoticia?id=${ultimaNot.id }" style="color:black;">
								${ultimaNot.titulo }
								</a>
						</h3> 
						<a href="lerNoticia?id=${ultimaNot.id }" style="color:black;">
							${ultimaNot.subtitulo }
						</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		</div>
<!-- Rodape -->
		<c:import url="rodape.jsp"></c:import>
	</div>
</body>
</html>
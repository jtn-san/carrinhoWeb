<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Meu carrinho - Editar</title>
<link rel="icon" href="assets/images/k-logo.png">

<!-- Bootstrap CSS -->
<link href="library/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Additional CSS Files -->
<link rel="stylesheet" href="assets/css/fontawesome.css">
	<link rel="stylesheet" href="assets/css/main.css">
</head>
<body>

	<!-- Pre Header -->
	<div id="pre-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<span>Kasper Papelaria Enterprise</span>
				</div>
			</div>
		</div>
	</div>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		<div class="container">
			<a class="navbar-brand center" href="#"><img
				src="assets/images/header-logo.png" alt=""></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="index.html">Home <span class="sr-only">(current)</span>
					</a></li>
					<!--<li class="nav-item">
            <a class="nav-link" href="products.html">Produtos</a>
          </li>
                    <li class="nav-item">
            <a class="nav-link" href="about.html">About Us</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contact.html">Contact Us</a>
          </li> -->
				</ul>
			</div>
		</div>
	</nav>

	<!--  -->
		<h1>Editar Produto</h1>
	<form name="frmProduto" action="update">
		<table>
			<tr>
				<td><input type="text" name="idpro" readonly id="caixa3" value="<%out.println(request.getAttribute("idpro"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="produto" readonly class="Caixa1" value="<%out.println(request.getAttribute("produto"));%>"></td>
			</tr>
			<tr>
				<td><input type="number" name="quantidade" class="Caixa2" value="<%out.println(request.getAttribute("quantidade"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="valor" readonly class="Caixa1" value="<%out.println(request.getAttribute("valor"));%>"></td>
			</tr>
		</table>
		<input type="button" value="salvar" class="Botao1" onclick="validar()">
	</form>

	<!-- Bootstrap core JavaScript -->
	<script src="library/jquery/jquery.min.js"></script>
	<script src="library/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Additional Scripts -->
		<script src="assets/js/valida.js"></script>
	<script src="assets/js/custom.js"></script>
	<script src="assets/js/owl.js"></script>


	<script type="text/Javascript">
		cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field
		function clearField(t) { //declaring the array outside of the
			if (!cleared[t.id]) { // function makes it static and global
				cleared[t.id] = 1; // you could use true and false, but that's more typing
				t.value = ''; // with more chance of typos
				t.style.color = '#fff';
			}
		}
	</script>
</body>
</html>
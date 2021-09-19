<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Meu carrinho</title>
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

	<h1 class="mt 5px">	Meu carrinho </h1>
	<br>
	<!-- Passo 1 -->
	<a href="novo.html" class="Botao1">Novo Produto</a>
	<table id="tabela" class="table">
		<!-- estatico -->
		<thead>
			<tr>
				<th>Id</th>
				<th>Produto</th>
				<th>Valor </th>
				<th>Quantidade</th>
				<th>Opções</th>
			</tr>
		</thead>
		<!-- dinamico -->
		<tbody>
			<%
			@SuppressWarnings("unchecked")
			// recebe a lista da camada controller armazenando no vetor
			ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
			
				<td><%=lista.get(i).getIdpro()%></td>
				<td><%=lista.get(i).getProduto()%></td>
				<td><%=lista.get(i).getQuantidade()%></td>
				<td><%=lista.get(i).getValor()%></td>
				
				<td><a href="select?idpro=<%=lista.get(i).getIdpro()%>" class="Botao1">Editar</a><a href="javascript: confirmar(<%=lista.get(i).getIdpro()%>)" class="Botao2">Excluir</a></td>	
			</tr>
			<%
			}
			%>
			<thead>

		</thead>
		
		</tbody>
	</table>
<div class="row mb-2">
  <label for="colFormLabelSm" class="rounded col-sm-1 col-form-label col-form-label-sm text-dark text-center bg-warning">Total</label>
  <div class="col-sm-2">
    <input type="text" class="form-control form-control-sm" id="colFormLabelSm" name="valor" value="<%out.println(request.getAttribute("total"));%>">
  </div>
</div>

	<!-- Bootstrap core JavaScript -->
	<script src="library/jquery/jquery.min.js"></script>
	<script src="library/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Additional Scripts -->
	<script src="assets/js/valida.js"></script>
	<script src="assets/js/custom.js"></script>
	<script src="assets/js/owl.js"></script>

<script>
 $(document).ready(function(){

   $("#total0,#total1").keyup(function(){
     var total0 = $("#total0").val();
     var total1 = $("#total1").val();
     var total_geral = parseInt(total0)+parseInt(total1);
        $("#final").val(total_geral);
   });

 });
</script>

	<script lang="text/Javascript">
    cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field
    function clearField(t) {                   //declaring the array outside of the
      if (!cleared[t.id]) {                      // function makes it static and global
        cleared[t.id] = 1;  // you could use true and false, but that's more typing
        t.value = '';         // with more chance of typos
        t.style.color = '#fff';
      }
    }
  </script>
</body>
</html>
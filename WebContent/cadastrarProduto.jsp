<%@ page language="java" 
	contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
	<title>Projeto ETB</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="content-type" content="text/html">
	<meta name="viewport" content="width=device-width, 
				initial-scale=1.0, shrink-to-fit=no">
	<link rel="stylesheet" href="css/styles.css" type="text/css">
	<link rel="stylesheet" href="css/menu.css" type="text/css">
	<link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="fonts/css/all.css" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="template/banner.jsp"></jsp:include>
		
		</div>
		<div id="menu">
			<jsp:include page="template/menu.jsp"></jsp:include>

		</div> <!-- fim da div menu -->
		
		<div id="conteudo" class="bg-background">
			<form action="gerenciarProduto" method="POST">
			<h3 class="text-center mt-3">Cadastro de Produto</h3>
			
			<input type="hidden" id="idproduto" name="idProduto"
				value="${produto.idProduto}">
				
			<div class="form-group row offset-md-2 mt-3">
				<label for="idnome"
					 class="col-md-2 col-form-label">Nome</label>
				<div class="col-md-7">
					<input type="text" name="nome" id="nome"
					class="form-control" value="${produto.nome }">
				</div>
			</div>
			
			<div class="form-group row offset-md-2 mt-3">
				<label for="iddescricao"
					 class="col-md-2 col-form-label">Descrição</label>
				<div class="col-md-7">
					<input type="text" name="descricao" id="descricao"
					class="form-control" value="${produto.descricao}">
				</div>
			</div>
			
			<div class="form-group row offset-md-2 mt-3">
				<label for="idestoque"
					 class="col-md-2 col-form-label">Estoque</label>
				<div class="col-md-7">
					<input type="text" name="estoque" id="estoque"
					class="form-control" value="${produto.estoque}">
				</div>
			</div>
			
			<div class="form-group row offset-md-2 mt-3">
				<label for="idpreco"
					 class="col-md-2 col-form-label">Preço</label>
				<div class="col-md-7">
					<input type="text" name="preco" id="preco"
					 class="form-control" value="${produto.preco}">
				</div>
			</div>
			
			<div class="form-group row offset-md-2 mt-3">
				<label for="idfile"
					 class="col-md-2 col-form-label">Imagem</label>
				<div class="col-md-7">
					<input type="file" multiple= "multiple" name= "file" id="idfile"
					class="form-control" value="${produto.nomeArquivo}">
				</div>
			</div>
			
			
			<div class="form-group row offset-md-2">
					<label for="idstatus"
						class="col-md-2 form-label">Status</label>
					<div class="col-md-6">
						<select id="idstatus" name="status" 
								class="form-control-md mt-2">
							<option value="1" 
								<c:if test="${produto.status == 1 }" >
								</c:if> selected>Ativado
							</option>
							<option value="0"
								<c:if test="${produto.status == 0 }" >
								</c:if> selected>Desativado
							</option>
						</select>
					</div>
			</div>
			
			<div class="d-grip gap-2 d-md-flex justify-content-md-end mr-3">
					<button class="btn btn-primary btn-md mr-2">
						Gravar&nbsp;
						<i class="fa-solid fa-floppy-disks"></i>
					</button>
					<a href="listarProduto.jsp"
							class="btn btn-info btn-md"
							role="button">
							Voltar&nbsp;
							<i class="fa-solid fa-circle-left"></i>
					</a>
				</div>
			</form>
			
			</div> <!-- fim da div conteudo -->
			
		</div> <!-- fim da div container -->
	
	<!-- JQuery.js -->
	<script src="js/jquery.min.js"></script>
	
	
	<!-- Popper via cdn -->
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
   integrity = "sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" 
   crossorigin = "anonymous">
	</script>
	
	<!-- Bootstrap.js -->
	<script src="js/bootstrap.min.js"></script>
	
	
</body>
</html>
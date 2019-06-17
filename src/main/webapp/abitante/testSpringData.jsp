<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Test per query Spring Data per Abitante</h3>
		</div>
		
		
		<%-- CERCA PER NOME FINDBYNOME --%>
		<form class="form-inline" action="ExecuteTestSpringDataAbitanteServlet" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input
					type="text" class="form-control" id="queryInput" name="queryInput"
					placeholder="findByName">
			</div>
			<input type="hidden" name="codop" value="findByName">
			<button type="submit" class="btn btn-primary mb-2">Esegui Test!!!</button>
		</form>
		
		
		<%-- CERCA PER ETA MAGGIORE DI -  FINDBYETAGREATERTHAN --%>
		<form class="form-inline" action="ExecuteTestSpringDataAbitanteServlet" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input
					type="text" class="form-control" id="queryInput2" name="queryInput"
					placeholder="findByEtaGreaterThan">
			</div>
			<input type="hidden" name="codop" value="findByEtaGreaterThan">
			<button type="submit" class="btn btn-primary mb-2">Esegui Test!!!</button>
		</form>
		
		
		<%-- CERCA PER NOME ED ETA FINDBYNOMEANDETA --%>
		<form class="form-inline" action="ExecuteTestSpringDataAbitanteServlet" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input
					type="text" class="form-control" id="queryInput3" name="queryInput"
					placeholder="nome">
				<input
					type="text" class="form-control" id="queryInput4" name="queryInputEta"
					placeholder="eta">
			</div>
			<input type="hidden" name="codop" value="findByNomeAndEta">
			<button type="submit" class="btn btn-primary mb-2">Esegui Test!!!</button>
		</form>
		
		
		<%-- CERCA PER  ETA ORDINANDO NOME DESC - FINDBYETAORDERBYNOMEDESC --%>
		<form class="form-inline" action="ExecuteTestSpringDataAbitanteServlet" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input
					type="text" class="form-control" id="queryInput5" name="queryInputEta"
					placeholder="eta ordertby nome desc">
			</div>
			<input type="hidden" name="codop" value="findByEtaOrderByNomeDesc">
			<button type="submit" class="btn btn-primary mb-2">Esegui Test!!!</button>
		</form>
		
		
		<%-- CERCA  PER NOME CHE INIZIA CON - FINDBYNOMESTARTSWITH --%>
		<form class="form-inline" action="ExecuteTestSpringDataAbitanteServlet" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input
					type="text" class="form-control" id="queryInput6" name="queryInput"
					placeholder="nome">
			</div>
			<input type="hidden" name="codop" value="findByNomeStartsWith">
			<button type="submit" class="btn btn-primary mb-2">Esegui Test!!!</button>
		</form>
		
		<%-- CERCA  PER NOME MA EAGER --%>
		<form class="form-inline" action="ExecuteTestSpringDataAbitanteServlet" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input
					type="text" class="form-control" id="queryInput7" name="queryInput"
					placeholder="findByCognomeEager">
			</div>
			<input type="hidden" name="codop" value="findByCognomeEager">
			<button type="submit" class="btn btn-primary mb-2">Esegui Test!!!</button>
		</form>
		
		
		

	</div>
	<!-- /.container -->



</body>
</html>
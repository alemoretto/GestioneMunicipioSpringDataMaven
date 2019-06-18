<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Abitante</title>
</head>
<body>

	<div class="container">
		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Dettagli:</h3>
		</div>
		<br>
		<div class="container-fluid" id="idContainer">

			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${abitanteDTO.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${abitanteDTO.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${abitanteDTO.cognome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Et�</dt>
				<dd class="col-sm-9">${abitanteDTO.eta}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Residenza</dt>
				<dd class="col-sm-9">${abitanteDTO.residenza}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Municipio</dt>
				<dd class="col-sm-9">${abitanteDTO.municipioInput}</dd>
			</dl>
		</div>
	</div>


</body>
</html>

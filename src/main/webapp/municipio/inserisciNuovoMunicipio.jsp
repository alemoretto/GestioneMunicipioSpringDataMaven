<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuovo Municipio</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/jqueryUI/jquery-ui.min.css" />
<style>
.ui-autocomplete-loading {
	background: white url("img/anim_16x16.gif") right center no-repeat;
}
</style>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>
		

		<div class="page-header">
			<h3>Pagina di Inserimento Municipio</h3>
		</div>

		<form class="form-horizontal" action="${pageContext.request.contextPath}/municipio/ExecuteInsertMunicipioServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<c:if test="${messaggiDiErrore.descrizioneInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.descrizioneInput}</div>
				</c:if> 
				<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId"
						name="descrizioneInput" value="${municipioDTO.descrizioneInput}">
				<div id="nomeInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
				<c:if test="${messaggiDiErrore.codiceInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.codiceInput}</div>
				</c:if> 
				<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId"
						name="codiceInput" value="${municipioDTO.codiceInput}">
				<div id="codiceInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="ubicazioneInputId">Ubicazione:</label>
				<c:if test="${messaggiDiErrore.ubicazioneInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.ubicazioneInput}</div>
				</c:if> 
				<div class="col-sm-4">
					<input class="form-control" type="text" id="ubicazioneInputId"
						name="ubicazioneInput" value="${municipioDTO.ubicazioneInput}">
				<div id="ubicazioneInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Effettua
						Inserimento</button>
				</div>
			</div>
			
			
		</form>

	</div>
	<!-- /.container -->



</body>


</html>
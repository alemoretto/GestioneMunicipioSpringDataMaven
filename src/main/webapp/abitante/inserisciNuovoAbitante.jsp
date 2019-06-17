<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuovo Abitante</title>
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
			<h3>Pagina di Inserimento Abitante</h3>
		</div>

		<!--	  <form class="form-horizontal" action="${pageContext.request.contextPath}/abitante/ExecuteInsertAbitanteServlet"
			method="post"> -->
		<form class="form-horizontal" action="ExecuteInsertAbitanteServlet"
			method="post"> 
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<c:if test="${messaggiDiErrore.nomeInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.nomeInput}</div>
				</c:if> 
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput" value="${abitanteDTO.nome}">
				<div id="nomeInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<c:if test="${messaggiDiErrore.cognomeInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.cognomeInput}</div>
				</c:if> 
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput" value="${abitanteDTO.cognome}">
				<div id="cognomeInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
				<c:if test="${messaggiDiErrore.etaInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.etaInput}</div>
				</c:if> 
				<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId"
						name="etaInput" value="${abitanteDTO.eta}">
				<div id="etaInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<c:if test="${messaggiDiErrore.residenzaInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.residenzaInput}</div>
				</c:if> 
				<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId"
						name="residenzaInput" value="${abitanteDTO.residenza}">
				<div id="residenzaInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="municipioInputId">Municipio:</label>
				<c:if test="${messaggiDiErrore.municipioInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.municipioInput}</div>
				</c:if> 
				<div class="col-sm-4">
					<input class="form-control" type="text" id="municipioInputId"
						name="municipioInput" value="${abitanteDTO.municipioInput}">
				<div id="municipioInputErrorId" style="display: none; color: red"></div>
					<input type="hidden" name="municipioId" id="municipioId" value="${abitanteDTO.municipioId}">
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Effettua
						Inserimento</button>
				</div>
			</div>
			
			<%-- FUNZIONE JQUERY UI CON AJAX PER AUTOCOMPLETE --%>
			<script>
				$( "#municipioInputId" ).autocomplete({
					 source: function(request, response) {
					        $.ajax({
					            url: "SearchMunicipioAjaxServlet",
					            datatype: "json",
					            data: {
					                term: request.term,   
					            },
					            success: function(data) {
					                response($.map(data, function(item) {
					                    return {
						                    label: item.label,
						                    value: item.value
					                    }
					                }))
					            }
					        })
					    },
					//quando seleziono la voce nel campo deve valorizzarsi la descrizione
				    focus: function(event, ui) {
				        $("#municipioInputId").val(ui.item.label)
				        return false
				    },
				    minLength: 2,
				    //quando seleziono la voce nel campo hidden deve valorizzarsi l'id
				    select: function( event, ui ) {
				    	$('#municipioId').val(ui.item.value);
				    	console.log($('#municipioId').val())
				        return false;
				    },
				});
			</script>
			
			
		</form>

	</div>
	<!-- /.container -->



</body>


</html>
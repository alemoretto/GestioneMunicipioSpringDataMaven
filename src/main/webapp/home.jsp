<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accedi</title>
</head>
<body>

<div class="container">
 <%@ include file="header.jsp" %>

	<div class="jumbotron">
      <div class="container">
        <h1 class="display-4">Gestione Municipio</h1>
        <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/PrepareSearchMunicipioServlet" role="button">Vai alla Gestione &raquo;</a></p>
      </div>
      
    </div>
    <div class="jumbotron">
      <div class="container">
        <h1 class="display-4">Gestione Abitante</h1>
        <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/PrepareSearchAbitanteServlet" role="button">Vai alla Gestione &raquo;</a></p>
      </div>
      
    </div>



	 <%@ include file="footer.jsp" %>
</div>

</body>
</html>
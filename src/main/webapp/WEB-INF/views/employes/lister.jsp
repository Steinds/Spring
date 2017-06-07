<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Liste Employés</title>

</head>
<jsp:include page="../menu.jsp" />
<body>

	<div class="container">
	<h1>Liste des Employés</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Entreprise</th>
					<th>Matricule</th>
					<th>Grade</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employes}" var="employes">
					<tr>
						<td>${employes.entreprise.denomination}</td>
						<td>${employes.matricule}</td>
						<td>${employes.grade.code}</td>
						<td><a>Visualiser</a></td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>
</body>
</html>
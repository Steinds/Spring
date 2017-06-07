
<!DOCTYPE html>

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Ajouter</title>
</head>
<jsp:include page="../menu.jsp" />
<body>

	
	<div class="row">
	<div class="col-md-6 col-md-offset-3">
		
		<h1><a href="./employes/list"><span
			class="glyphicon glyphicon-arrow-left"></span></a>              Ajouter un employé</h1></div>
	</div>
	<div class="row col-md-4 col-md-offset-4">
	<form class="form-horizontal" method="POST">
		<fieldset>



			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="matricule">Matricule</label>
				<div class="col-md-4">
					<input id="matricule" name="matricule" type="text" placeholder=""
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="entreprise">Entreprise</label>
				<div class="col-md-4">
					<select id="entreprise" name="entreprise" class="form-control">
						<c:forEach items="${entreprise}" var="entreprise">
							<option value="${entreprise.id}">${entreprise.denomination}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="profil">Profil</label>
				<div class="col-md-4">
					<select id="profil" name="profil" class="form-control">
						<c:forEach items="${profil}" var="profil">
							<option value="${profil.id}">${profil.code}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="grade">Grade</label>
				<div class="col-md-4">
					<select id="grade" name="grade" class="form-control">
						<c:forEach items="${grade}" var="grade">
							<option value="${grade.id}">${grade.code}-${grade.tauxBase} -
								${grade.nbHeuresBase}</option>

						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="valider"></label>
				<div class="col-md-4">
					<button id="valider" name="valider" class="btn btn-primary">Valider</button>
				</div>
			</div>

		</fieldset>
		<sec:csrfInput/>
	</form>
	</div>
</body>
</html>
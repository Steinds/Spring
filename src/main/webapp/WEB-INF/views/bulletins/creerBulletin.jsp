
<!DOCTYPE html>

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Ajouter</title>
</head>
<jsp:include page="../menu.jsp" />
<body>

	
	<div class="row">
	<div class="col-md-6 col-md-offset-3">
		
		<h1><a href="./employes/list"><span
			class="glyphicon glyphicon-arrow-left"></span></a>              Ajouter un Bulletin</h1></div>
	</div>
	<div class="row col-md-4 col-md-offset-4">
	<form class="form-horizontal" method="POST">
		<fieldset>



			
			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="periode">Periode</label>
				<div class="col-md-4">
					<select id="periode" name="periode" class="form-control">
						<c:forEach items="${periode}" var="periode">
							<option value="${periode.id}">${periode.dateDebut}-${periode.dateFin} </option>
						</c:forEach>
					</select>
				</div>
			</div>
			

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="matricule">Matricule</label>
				<div class="col-md-4">
					<select id="matricule" name="matricule" class="form-control">
						<c:forEach items="${employe}" var="matricule">
							<option value="${matricule.id}">${matricule.matricule}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			
			
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="prime">Prime Exceptionelle</label>
				<div class="col-md-4">
					<input id="prime" name="prime" type="text" placeholder=""
						class="form-control input-md" >

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
<!-- Etape 2 : créer la couche web
 * 2. créer la VUE */  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sid.sc.web.CreditModel"%>

<%
	CreditModel creditModel = (CreditModel) request.getAttribute("creditModel");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crédit bancaire</title>

<link rel="stylesheet" type="test/css" href="css/style.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  
</head>
<body>
	<p class="spacer"></p>
	<div class="container">
		<div class="col-md-6 col-xm-12 col-sm-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading"><h2>Simulateur de crédit</h2></div>
				<div class="panel-body">
					<form action="calculerMensualiteCredit" method="post">
						<div class="form-group">
							<label class="control-label">Montant :</label> 
							<input class="form-control" type="text" name="montant" id="montant" value="<%=creditModel.getMontant()%>" />
						</div>
						<div class="form-group">
							<label class="control-label">Taux :</label> 
							<input class="form-control" type="text" name="taux" id="taux" value="<%=creditModel.getTaux()%>" />
						</div>
						<div class="form-group">
							<label class="control-label">Durée :</label> 
							<input class="form-control" type="text" name="duree" id="duree" value="<%=creditModel.getDuree()%>" />
						</div>
						<button class="btn btn-danger">Calculer</button>
					</form>
					<div class="spacer">
						<label>Mensualité :</label> 
						<label><%=creditModel.getMensualite()%></label>
					</div>
				</div>
			</div>
		</div>
	</div>
  	
  	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
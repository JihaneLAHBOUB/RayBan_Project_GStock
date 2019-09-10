<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="css/bootstrap.min.css" rel="stylesheet"> 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/v4-shims.css">

<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script>
	$(document).ready(function() {
		console.log('button clicked');
		$('#mytbl').DataTable();
		console.log('after button clicked');
	});
</script>
</head>
<body>	
<div class="container-fluid">
	<div class="row content">
			
			<div class="col-sm-3 sidenav sidebar">
				<div id="admin">
					<img src="css/admin-gray.png" alt="admin">
					<div class="log">
						 <p>Admin ${sessionScope.username }</p> 
					</div>
					</div>
					<div id="mySidenav">
					  <a href="logout.html" id="contact">Log out</a>
				</div>
					 <s:a href="home.html"><i class="fa fa-fw fa-home"></i> About Us </s:a>
				<br> <s:a href="index.html"><i class="fas fa-store-alt"></i> Go To Achats</s:a>
				<br> <s:a href="inventaire.html"><i class="fas fa-dolly-flatbed"></i> Go To Inventory</s:a>
				<br> <s:a href="invhistorique.html"><i class="fas fa-history"></i> Go To History</s:a>
			</div>
			<div class="col-sm-9" style="background-color:white;">
				<div class="header">
				</div>
				<span>
				<!-- Button pour ajouter une inventaire -->
				<s:a href="addnewinv.html" cssClass="btn btn-info op" ><i class="fas fa-plus"></i></s:a> 
				<!-- Form pour chercher une inventaire -->
				<s:a href="searchInventory.html" cssClass="btn btn-info op"><i class="fas fa-search"></i></s:a>
				</span>
				<h1> <small> List Inventaires: </small></h1>
				<hr>
				<br>
				<table class="table table-striped table-hover" id="mytbl">
				<thead>
					<tr>
						<th>Inventaire ID</th>
						<th>Article ID</th>
						<th>Quantity Achete</th>
						<th>Description Inventaire</th>
						<th>Date Inventaire</th>
						<th>Option</th>
					</tr>
					</thead>
					<tbody>
					<s:iterator var="inventaire" value="listInventaires">
					<tr>
					<td><s:property value="#inventaire.codeInv"/></td>
					<td><s:property value="#inventaire.codeArt"/></td>
					<td><s:property value="#inventaire.qteArt"/></td>
					<td><s:property value="#inventaire.descInv"/></td>
					<td><s:date name="#inventaire.dateInv" format="yyyy-MM-dd"/></td>
				
					<td>
								<!-- Button pour modifier une inventaire -->
								<s:url var="updateURL" value="updateinv.html">
									<s:param name="codeInv"><s:property value="#inventaire.codeInv" /></s:param>
								</s:url>
								<s:a href="%{updateURL}" cssClass="btn btn-primary">Update</s:a>
								<!-- Button pour supprimer une inventaire -->
								<s:url var="deleteURL" value="deleteInv.html">
									<s:param name="codeInv"><s:property value="#inventaire.codeInv" /></s:param>
								</s:url>
								<s:a href="%{deleteURL}" onclick="return confirm('Do you want to delete?')"  cssClass="btn btn-danger">Delete</s:a>
					</td>
					</tr>
					</s:iterator>
					</tbody>
				</table>
				
			
			</div>
	</div>
</div>
</body>
</html>
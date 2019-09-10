<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		$.fn.dataTableExt.sErrMode = 'throw';
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
				<ul class="pager">
				    <li class="next"><s:a href="inventaire.html">previous</s:a></li>
				 </ul>
				<h1> <small> Search Inventaires: </small></h1>
				<!-- Form pour chercher un inventaire -->
		 		<form action="process-searchinv.html" method="post">
				<table>
					<tr>
						<td style="padding-left: 0px"><input type="text" name="codeInv" class="form-control" placeholder="Search By Inventory ID..."></td>
						
						<td style="padding-left: 5px;"><input type="submit" value="Search" class="btn btn-info"></td>
					</tr>
				</table>
				</form>
				<br><br>
		<!-- Table pour lister les inventaires -->
		<table class="table table-striped table-hover" id="mytbl">
		<thead>
		<tr>
			<th>Inventaire ID</th>
			<th>Article ID</th>
			<th>Quantity Achete</th>
			<th>Description Inventaire</th>
			<th>Date Inventaire</th>
			<th>Options</th>
		</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${not empty listInventaires }">
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
									<s:a href="%{deleteURL}" onclick="return confirm('Do you want to delete?')" cssClass="btn btn-danger">Delete</s:a>
							</td>	
					</tr>
				</s:iterator>
			</c:when>
			
			<c:otherwise>
				<tr>
					<td colspan="5"><% out.println("Data not found!"); %></td>
				</tr>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
				
				
			</div>  
				
	</div>
</div>

</body>
</html>
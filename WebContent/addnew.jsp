<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Ajouter un nouveau achat</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>	
	
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="css/bootstrap.min.css" rel="stylesheet"> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/v4-shims.css">


<sj:head /> 
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
					    <li class="next"><s:a href="index.html">previous</s:a></li>
					 </ul>
				
					<h1> <small> Add New: </small></h1>
					<hr>
					<br>
					<%
					//Message sur la validation de la quantité
						String message = (String) request.getAttribute("messageQ");
						if(!(message == null)){
							
						%>	
						<div class="alert alert-danger alert-dismissible fade in">
						
						    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						    <strong>Required Fields Quantity!</strong> Please correct the following errors in the form fields below :
						   
						</div>
						
						<%	}
						if((message == null)){
							message = "";
							out.println(message);
						}
						%>
						<%
						//Message pour validation de la date
						String messageD = (String) request.getAttribute("messageD");
						if(!(messageD == null)){
							
						%>	
						<div class="alert alert-danger alert-dismissible fade in">
						
						    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						    <strong>Required Fields Date!</strong> Please correct the following errors in the form fields below :
						    
						</div>
						
						<%	}
						if((messageD == null)){
							messageD = "";
							out.println(messageD);
						}
						%>
					<s:form  action="processadd.html" method="post">
						<!-- Dropdown Menu pour lister les articles-->
						 <s:select list="listArticles" listKey="codeArt" listValue="nomArt" name="achat.codeArt" headerKey="1" headerValue="----Choose articles-------" label="Code Article " cssClass="form-control " ></s:select>
						<!-- champ pour entrée la quantité-->
						 <s:textfield label="Quantité Article" name="achat.qteAchete" cssClass="form-control"></s:textfield>
						<!-- champ pour choisir la date -->
					     <sj:datepicker id="date4" name="dateReception" displayFormat="yy-mm-dd"  label="Date de Reception"/> 
						<!-- button submit pour envoyer la demande -->
					 	 <s:submit value="Ajouter Achat" cssClass="btn btn-info"></s:submit>
					 	
		 			</s:form>
		
				</div>  				
		</div>
	</div>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link href="css/bootstraplogin.min.css" rel="stylesheet"> 
<link rel="stylesheet" type="text/css" href="css/loginstyle.css">
</head>
<body>
	
			<div class="container">
	    	<div class="row">
		        <nav class="navbar navbar-default">
		            <h3 class="text-center">RayBan</h3>
		        </nav>
		   	</div>
	        <div class="row">
	            <div class="col-xs-6">
	                <img src="css/graphic.svg" alt=""/>
	            </div>
	            <div class="col-xs-6" id="helo">
	            
                    <h2 class="text-center">Welcome back.</h2>
                	<br>
                	<%
                			//Message pour valider Login
							String msgL = (String) request.getAttribute("messageL");
							if(!(msgL == null)){
								%>	
								<div class="alert alert-danger alert-dismissible fade in">
								
								    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								    <strong>Required Field !</strong> Invalid Username or Password
								</div>
								
								<%
							}else{
								msgL="";
								out.println(msgL);
							}
					%>
                	
					<s:form action='processlogin.html'>
						<!-- Champ pour entrée login -->
						<s:textfield name="user" label="Username " id="marg" cssClass="form-control size" />
						<!-- Champ pour entrée un mot de pass -->
						<s:password name="password" label="Password " cssClass="form-control col-sm-6 size" />
						<s:submit value="login" cssClass="btn btn-primary margbtn"/>		
						
					</s:form>
		      	</div>
			</div>
		</div>


</body>

</html>
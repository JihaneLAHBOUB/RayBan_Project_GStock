<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="css/bootstrap.min.css" rel="stylesheet"> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/v4-shims.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
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
				
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
				    <!-- Indicators -->
				    <ol class="carousel-indicators">
				      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				      <li data-target="#myCarousel" data-slide-to="1"></li>
				      <li data-target="#myCarousel" data-slide-to="2"></li>
				    </ol>
				
				    <!-- Wrapper for slides -->
				    <div class="carousel-inner">
				
				      <div class="item active">
				        <img src="css/rayban-header.jpg" alt="ray ban" style="width:100%;">
				        <div class="carousel-caption">
				          <h3>UK LIMITED EDITION</h3>
				          <p>Make your mark with something unexpected.</p>
				        </div>
				      </div>
				
				      <div class="item">
				        <img src="css/clubmasterheader_2.png" alt="header" style="width:100%;">
				        <div class="carousel-caption">
				          <h3></h3>
				          <p></p>
				        </div>
				      </div>
				    
				      <div class="item">
				        <img src="css/Ray-Ban-Clubmaster-Aluminum.jpg" alt="header-ray-ban-1" style="width:100%;">
				        <div class="carousel-caption">
				          <h3>OUR STYLES, YOUR OWN WAY.</h3>
				          <p>Exclusively on Ray-Ban.com</p>
				        </div>
				      </div>
				  
				    </div>
				
				    <!-- Left and right controls -->
				    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
				      <span class="glyphicon glyphicon-chevron-left"></span>
				      <span class="sr-only">Previous</span>
				    </a>
				    <a class="right carousel-control" href="#myCarousel" data-slide="next">
				      <span class="glyphicon glyphicon-chevron-right"></span>
				      <span class="sr-only">Next</span>
				    </a>
				  </div>
				   <div class="text-center" style="padding: 0px 120px;">
					  <img alt="" src="css/GL_ray-ban_black.png">
					  <p>Ray-Ban is the global leader in premium eyewear and by far the best selling eyewear brand in the world. The iconic designs and quality of its frames ensure that Ray-Ban is here to stay.</p>
					</div> 
					
					<div class="row">
					    <div class="col-sm-4">
					    <br>
					      <p class="text-center"><strong>Services</strong></p>
					      <img src="css/service-left-img.jpg" class="img-circle person" alt="Random Name" width="255" height="255" style="margin-left: 35px;">
					    </div>
					    <div class="col-sm-4">
					    <br>
					      <p class="text-center"><strong>Garantie</strong></p>
					      <img src="css/410-article_vert_garantie_casse.jpg.jpg" class="img-circle person" alt="Random Name" width="255" height="255" style="margin-left: 35px;">
					    </div>
					    <div class="col-sm-4">
					    <br>
					      <p class="text-center"><strong>Satisfaction</strong></p>
					      <img src="css/customer-satisfaction.jpg" class="img-circle person" alt="Random Name" width="255" height="255" style="margin-left: 35px;">
					    </div>
					</div>  
				
	</div>
</div>
</div>
			
</body>
</html>
 <%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- -css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="css/mystyle.css" rel="stylesheet" type="text/css"/> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    .banner-background{
   clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 100%, 76% 95%, 35% 100%, 0 92%, 0 0);
    }
    
</style>
</head>


<body>
 <!--  navbar -->
 <%@include file="normal_navbar.jsp" %>
  
<!--   banner   -->
<div class="container-fuild p-0 m-0">
    <div class="jumbotron primary-background text-white banner-background">
    <div class="container">
       <h3 class="display-3">Welcome to TechBlog</h3>
       <p>Welcome to technical blog,one common trend in the development of programming languages has been to add more ability to solve problems using a higher level of abstraction. The earliest programming languages were tied very closely to the underlying hardware of the computer</p>
      
       <button class="btn btn-outline-light btn-lg"><span class="fa fa-user-plus fa-spin"></span>Start! its free</button>
       <a href="login_page.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-circle fa-spin"></span>Login</a>
    </div>
    </div>
</div>

   <!-- cards -->
<div class="container">
<div class="row mb-2">
  <div class="col-md-4">
       <div class="card">
 
          <div class="card-body">
            <h5 class="card-title">Java Programming</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="#" class="btn primary-background text-white">Read More</a>
          </div>
       </div>	
  
  </div>
  
  <div class="col-md-4">
       <div class="card">
 
          <div class="card-body">
            <h5 class="card-title">Java Programming</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="#" class="btn primary-background text-white">Read More</a>
          </div>
       </div>	
  
  </div>
  
  <div class="col-md-4">
       <div class="card">
 
          <div class="card-body">
            <h5 class="card-title">Java Programming</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="#" class="btn primary-background text-white">Read More</a>
          </div>
       </div>	
  
  </div>

</div>

<div class="row">
  <div class="col-md-4">
       <div class="card">
 
          <div class="card-body">
            <h5 class="card-title">Java Programming</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="#" class="btn primary-background text-white">Read More</a>
          </div>
       </div>	
  
  </div>
  
  <div class="col-md-4">
       <div class="card">
 
          <div class="card-body">
            <h5 class="card-title">Java Programming</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="#" class="btn primary-background text-white">Read More</a>
          </div>
       </div>	
  
  </div>
  
  <div class="col-md-4">
       <div class="card">
 
          <div class="card-body">
            <h5 class="card-title">Java Programming</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="#" class="btn primary-background text-white">Read More</a>
          </div>
       </div>	
  
  </div>
</div>


    
   <!--  javascript -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="js/myjs.js" type="text/javascript"></script>

<script>
  
</script>

</body>
</html>
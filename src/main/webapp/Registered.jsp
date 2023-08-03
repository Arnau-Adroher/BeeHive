<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<script type="text/javascript">
 $(document).ready(function(){
	$('#navigation').load('MenuController');
	$('#lcolumn').html("<p></p>");
	$('#rcolumn').html("<p></p>");
 });
</script>
<html>
<head>
  <meta charset="UTF-8">
  <title>Registration Page</title>
  <style>
    body {
      background-image: url(https://cdn.shopify.com/s/files/1/0651/3301/9380/files/shutterstock_1145847032_yellow.jpg?v=1657804991&width=1500);
      background-repeat: no-repeat;
      background-size: cover;
      font-family: Arial, sans-serif;
    }
    
    .container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    
    .registration-card {
      background-color: #FFA500;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      text-align: center;
    }
    
    h1 {
      font-size: 24px;
      margin-bottom: 20px;
      color: #fff;
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="registration-card">
      <h1 class="h3 mb-3 fw-normal">You have been registered correctly! :)</h1>
    </div>
  </div>
</body>
</html>


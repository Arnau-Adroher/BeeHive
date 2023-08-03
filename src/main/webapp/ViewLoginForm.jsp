<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<style>
body {
  display: sticky;
  align-items: center;
  background-color: #fffffff;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
}
.form-signin input {
  margin-bottom: 5px;
  height: 30px;
  border-radius: 5px;

}
input:valid {
	background-color: #00ff6e6c;
}
input:invalid {
	background-color: #ff00006c;
}
</style>
<script type="text/javascript">
 $(document).ready(function(){
	$('#navigation').load('MenuController');
	$('#lcolumn').html("<p></p>");
	$('#rcolumn').html("<p></p>");
 });
</script>
<body class = "text-center">

<main class="form-signin w-100 m-auto">
	<form action="LoginController" method = "POST" id="loginform">
	
	  <h1 class="h3 mb-3 fw-normal">Log in</h1>
	  
	  <input class="form-control" type="text" id="userName" name="userName" placeholder="nomUsuari" value="${model.userName}" required pattern = "[a-zA-Z0-9._]{2,16}$">
	  <c:if test = "${login.error[0]}">
		<div class="alert alert-warning">Aquest nom d'usuari no existeix</div>
	  </c:if>

	  <input class="form-control" type="password" id="pwd" name="pwd" placeholder="Contrassenya" value="${model.pwd}" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$">
	  <c:if test = "${login.error[1]}">
		<div class="alert alert-warning"> Contrassenya incorrecta </div>
	  </c:if>
	  
	  <button class = "w-100 btn btn-lg btn-warning"> Log in </button>
	</form>
	
	<form action="LoadAnonimous" method = "POST">
		<br>
		<button class = "w-100 btn  btn-outline-dark "> Entrar com a anònim </button>
	</form>
	 
	
	
</main>
<script>
const form = document.getElementById("loginform");
form.addEventListener("submit", function (event) {
	if (!this.checkValidity()) {
		this.reportValidity();
		event.preventDefault();
	} 
}, false);
</script>

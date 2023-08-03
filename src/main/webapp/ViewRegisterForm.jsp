<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<style>
body {
  display: sticky;
  align-items: center;
  background-color: #ffffff;
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
	<form action="RegisterController" id="myform">
	
	  <h1 class="h3 mb-3 fw-normal">Sign in</h1>
	  
	  <input class="form-control" type="text" id="userName" name="userName" placeholder="nomUsuari" value="${model.userName}" required pattern = "[a-zA-Z0-9._]{2,16}$">
	  <c:if test = "${model.error[0]}">
		<div class="alert alert-warning"> Nom d'usuari invàlid: ha de contenir entre 2 i 16 caràcters, i no pot tenir caràcters especials que no siguin . o _</div>
	  </c:if>
	  <c:if test = "${model.error[5]}">
		<div class="alert alert-warning"> Aquest nom d'usuari ja existeix </div>
	  </c:if>
	
	  <input class="form-control" type="text" id="name" name="name" placeholder="Name" value="${model.name}" required pattern = "[a-zA-Z0-9._]{2,16}$">
	  <c:if test = "${model.error[1]}">
		<div class="alert alert-warning" > Nom invàlid </div>
	  </c:if>
	  
	  <input class="form-control" type="text" id="birthDate" name="birthDate" placeholder="Birth Year" value="${model.birthDate}" required pattern = "\d\d\d\d">
	  <c:if test = "${model.error[2]}">
		<div class="alert alert-warning"> Any invàlid, has de ser major de 18 </div>
	  </c:if>
	  
	  <input class="form-control" type="password" id="pwd1" name="pwd1" placeholder="Password" value="${model.pwd1}" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$">
	  <c:if test = "${model.error[3]}">
		<div class="alert alert-warning"> Contrassenya invàlida.Ha de tenir 8 caràcters,majúscules, minúscules i números </div>
	  </c:if>
	  
	  <input class="form-control" type="password" id="pwd2" name="pwd2" placeholder="Confirm Password" value="${model.pwd2}" required>
	  <c:if test = "${model.error[4]}">
		<div class="alert alert-warning"> Les contrassenyas no són iguals </div>
	  </c:if> 
	  <br>
	  <button class = "w-100 btn btn-lg btn-warning"> Submit </button>
	</form>
	
	
</main>
<script>

const form = document.getElementById("myform");
const pwd1 = document.getElementById("pwd1");
const pwd2 = document.getElementById("pwd2");

var input_un = document.getElementById("userName");
input_un.addEventListener("mouseover", function(event) {
    // muestra el tooltip
    input_un.setAttribute("title", "2-16 caràcters. Només lletres, . i _");
});
input_un.addEventListener("mouseout", function(event) {
    // oculta el tooltip
    input_un.setAttribute("title", "");
});

var input_n = document.getElementById("name");
input_n.addEventListener("mouseover", function(event) {
    // muestra el tooltip
    input_n.setAttribute("title", "2-16 caràcters. Només lletres, números, . i _");
});
input_n.addEventListener("mouseout", function(event) {
    // oculta el tooltip
    input_n.setAttribute("title", "");
});

var input_b = document.getElementById("birthDate");
input_b.addEventListener("mouseover", function(event) {
    // muestra el tooltip
    input_b.setAttribute("title", "Has de ser major de 18");
});
input_b.addEventListener("mouseout", function(event) {
    // oculta el tooltip
    input_b.setAttribute("title", "");
});

var input_p1 = document.getElementById("pwd1");
input_p1.addEventListener("mouseover", function(event) {
    // muestra el tooltip
    input_p1.setAttribute("title", "Min 8 caràcters. Majúscules, minúscules i números");
});
input_p1.addEventListener("mouseout", function(event) {
    // oculta el tooltip
    input_p1.setAttribute("title", "");
});

var input_p2 = document.getElementById("pwd2");
input_p2.addEventListener("mouseover", function(event) {
    // muestra el tooltip
    input_p2.setAttribute("title", "Min 8 caràcters. Majúscules, minúscules i números");
});
input_p2.addEventListener("mouseout", function(event) {
    // oculta el tooltip
    input_p2.setAttribute("title", "");
});

var checkPasswordValidity = function() {
	 if (pwd2.value.equals(pwd1.value)) {
		pwd2.setCustomValidity("Les contrassenyes ha de ser iguals!");
	} else {
		pwd2.setCustomValidity("");
	}
}

pwd2.addEventListener("input", checkPasswordValidity, false);

form.addEventListener("submit", function (event) {
	checkPasswordValidity();
	if (!this.checkValidity()) {
		this.reportValidity();
		event.preventDefault();
	} 
}, false);


</script>
</body>
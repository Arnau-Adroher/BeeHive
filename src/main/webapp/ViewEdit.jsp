<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<style>
body {
            align-items: center;
            background-color: #ffffff;
            font-family: "Segoe UI", Arial, sans-serif;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
        }

        .form-signin input {
            margin-bottom: 10px;
            height: 40px;
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

<body class = "w3-center">

	<form action="EditController" id="myform">
	
	  <h1 class="h3">Edita</h1>
	  
	
	  <input class="w3-card w3-section w3-round-xlarge w3-animate-opacity" type="text" id="name" name="name" placeholder="Name" value="${user.name}" required pattern = "[a-zA-Z0-9._]{2,16}$">

	  <br>
	  <input class="w3-card w3-section w3-round-xlarge w3-animate-opacity" type="text" id="birthDate" name="birthDate" placeholder="Birth Year" value="${user.birthDate}" required pattern = "\d\d\d\d">
	  
	  
	  <br><br>
	  <button class = "edit w3-button w3-round-xlarge w3-yellow"> Guardar </button>
	</form>
	
	
</body>

<script>

const form = document.getElementById("myform");


var input_n = document.getElementById("name");
input_n.addEventListener("mouseover", function(event) {
    // muestra el tooltip
    input_n.setAttribute("title", "2-16 characters. Only use letters, numbers, . and -");
});
input_n.addEventListener("mouseout", function(event) {
    // oculta el tooltip
    input_n.setAttribute("title", "");
});

var input_b = document.getElementById("birthDate");
input_b.addEventListener("mouseover", function(event) {
    // muestra el tooltip
    input_b.setAttribute("title", "Only 4 numbers. You must be over 18");
});
input_b.addEventListener("mouseout", function(event) {
    // oculta el tooltip
    input_b.setAttribute("title", "");
});





</script>
</body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<style>
.logo{
	width: 80px;
}

.image{
position: absolute;
top: 5px;
right: 10px;
width: 90px;
height: auto;
}

</style>
<div class="w3-bar w3-pale-yellow">
	<a class="menu w3-bar-item w3-button w3-hide-small" id="RegisterController" href=#> Registre </a> 
	<a class="menu w3-bar-item w3-button w3-hide-small" id="LoginController" href=#> Login </a> 
	<a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="stack()">&#9776;</a>
</div>

<div id="stack" class="w3-bar-block w3-pale-yellow w3-hide w3-hide-large w3-hide-medium">
	<a class="menu w3-bar-item w3-button" id="RegisterController" href=#> Registre </a> 
	<a class="menu w3-bar-item w3-button" id="LoginController" href=#> Login </a> 
</div>

<img src = "imgs/beehive.png" class="image"> 

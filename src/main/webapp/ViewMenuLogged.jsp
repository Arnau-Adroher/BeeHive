<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<nav class="navbar w3-pale-yellow navbar-expand-lg navbar-light bg-light" id = "navigation">
	<a class="w3-bar-item w3-button" href="MainController"> <i class="fa fa-home" aria-hidden="true"></i> </a> 
	<a class="menu w3-bar-item w3-button w3-hide-small" id="MyProfile" href=#> Perfil </a>
	<a class="menu w3-bar-item w3-button w3-hide-small" id="LogoutController" href=#> Logout </a>
	<a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="stack()">&#9776;</a>
</nav>

<div id="stack" class="w3-bar-block w3-pale-yellow w3-hide w3-hide-large w3-hide-medium">
	<a class="menu w3-bar-item w3-button w3-hide-small" id="MyProfile" href=#> Perfil </a>

	<a class="menu w3-button" id="LogoutController" href=#> Sortir </a>
</div>

<img src = "imgs/beehive.png" class="image"> 

<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Seoge UI", sans-serif}

.image{
position: absolute;
top: 5px;
right: 10px;
width: 90px;
height: auto;
}
</style>
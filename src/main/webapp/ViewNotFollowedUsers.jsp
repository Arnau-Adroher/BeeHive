<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
h5
{
    cursor: pointer;
}
h5:hover{
   text-decoration:underline;
}
</style>
<h3 style="margin-left:50px; margin-top:20px;">Suggeriments</h3>
<hr>
<c:forEach var="u" items="${users}">       
<div id="${u.id}" class="w3-container w3-card w3-round-xxlarge w3-white w3-center w3-section">
    <div><h5 id = "${u.userName}" class = "info">0x<b>${u.userName}</b></h5></div>
    <p>Seguidors: ${u.followers}</p>
   	<button type="button" class="followUser w3-row w3-button w3-round-xlarge w3-yellow w3-section">
   		<img src="imgs/follow.png" alt="follow icon" class="follow-icon" style="width: 25px; height: 25px;"> &nbsp;Seguir
   	</button>
   	<br>
   	
</div>
</c:forEach>
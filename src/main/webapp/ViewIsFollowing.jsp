<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose >
	<c:when test= "${anon == true}">
		<form action="LoadAnonimous" method = "POST">
			<br>
			<button class = "w3-button w3-round-xlarge w3-yellow "> Tornar </button>
		</form>
	</c:when>
	
	<c:otherwise>
		<c:choose>
		   <c:when test="${otherUser.isFollowed}">
		   		<button id = "${otherUser.id}" type="button" class="unfollowUserProfile w3-row w3-button w3-round-xlarge w3-yellow w3-section"><i class="fa fa-trash"></i> &nbsp;Deixar de seguir</button> 
		   </c:when>    
		   <c:otherwise>
		        <button id = "${otherUser.id}" type="button" class="followUserProfile w3-row w3-button w3-round-xlarge w3-yellow w3-section">
		  			<img src="imgs/follow.png" alt="follow icon" class="follow-icon" style="width: 25px; height: 25px;"> &nbsp;Seguir
		  		</button>
		   </c:otherwise>
		</c:choose>
	
	</c:otherwise>
</c:choose>


			

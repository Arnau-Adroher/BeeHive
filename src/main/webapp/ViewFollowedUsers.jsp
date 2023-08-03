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
<h3 style="margin-left:70px; margin-top:20px;">Abelles que segueixes</h3>
<hr>
<c:forEach var="u" items="${users}">       
 <div id="${u.id}" class="w3-container w3-card w3-round-xxlarge w3-section w3-white w3-center"><br>
   <h5 id = "${u.userName}" class = "info">0x<b>${u.userName}</b> </h5>
   <p>Seguidors: ${u.followers}</p>
   <hr class="w3-clear">
   <button type="button" class="unfollowUser w3-row w3-button w3-round-xlarge w3-yellow w3-section">
 			<img src="imgs/unfollow.png" alt="unfollow icon" class="unfollow-icon" style="width: 25px; height: 25px;"> &nbsp;Deixar de seguir
	</button>
   <br>
 
 </div>
</c:forEach>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.info
{
    cursor: pointer;
}
.info:hover{
   text-decoration:underline;
}
</style>


<c:forEach var="b" items="${brunzits}">

	<div id="${b.id}"
		class="w3-container w3-card w3-section w3-white w3-round-xxlarge w3-animate-opacity">
		<br> <span class="w3-right w3-opacity"> ${b.postDateTime}
			<c:if test="${b.isFlash}">
				<i class="fa fa-bolt flash-icon" style="color: #F4C404;"></i>
			</c:if>
		</span>
		<c:choose>
			<c:when test = "${b.userName == user.userName}">
				<h4  id = "${b.userName}" class = "notInfo">0x<b>${b.userName}</b></h4>
			</c:when>
			<c:otherwise>
				<h4  id = "${b.userName}" class = "info">0x<b>${b.userName}</b></h4>
			</c:otherwise>
		
		</c:choose>
		<hr class="w3-clear">
		<p>${b.content}</p>
		<c:choose>
  			<c:when test = "${b.isLiked}">
  				<button type="button"  class="dislikeBrunzit w3-button w3-round-xlarge w3-right" style = "color:red;">
					<img src="imgs/dislikee.png" alt="Like button" class="dislike-icon" style="width: 20px; height: 20px;"> &nbsp;<b>${b.likes}</b>
				</button>
  			</c:when>    
   			<c:otherwise>
   				<button type="button" class="likeBrunzit w3-button w3-round-xlarge w3-theme w3-right">
		    		<img src="imgs/likee.png" alt="Like button" class="like-icon" style="width: 20px; height: 20px;"> &nbsp;<b>${b.likes}</b>
				</button>
   			</c:otherwise>
		</c:choose>
		<button type="button"
			class="comments w3-button w3-round-xlarge w3-margin-bottom w3-right">
			<i class="fa fa-comment"></i>
		</button>
		<c:if test = "${user.isAdmin == 1}">
			<button type="button" id = "${b.id}" 
				class="delBrunzitAdmin w3-button w3-round-xlarge w3-margin-bottom w3-right">
				<i class="fa fa-trash"></i> &nbsp;
			</button>
		</c:if>
		
	</div>

</c:forEach>


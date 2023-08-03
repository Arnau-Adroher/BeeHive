<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
h4
{
    cursor: pointer;
}
h4:hover{
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
		<h4  id = "${b.userName}" class = "info">0x<b>${b.userName}</b></h4>
		<br>
		<hr class="w3-clear">
		<p>${b.content}</p>
		

	</div>
	
</c:forEach>


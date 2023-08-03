<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Els seus Brunzits</h3>
<c:forEach var="b" items="${brunzits}">

	<div id="${b.id}"
		class="w3-container w3-card w3-section w3-white w3-round-xxlarge w3-animate-opacity">
		<br> <span class="w3-right w3-opacity"> ${b.postDateTime}
			<c:if test="${b.isFlash}">
				<i class="fa fa-bolt flash-icon" style="color: #F4C404;"></i>
			</c:if>
		</span>
		<h4>0x<b>${b.userName}</b></h4>
		<hr class="w3-clear">
		<p>${b.content}</p>
		<c:if test = "${anon == false}">
			<c:choose>
	  			<c:when test="${b.isLiked}">
					<button type="button"  class="dislikeBrunzitOther w3-button w3-round-xlarge w3-right" style = "color:red;">
						<img src="imgs/dislikee.png" alt="Like button" class="dislike-icon" style="width: 20px; height: 20px;"> &nbsp;<b>${b.likes}</b>
					</button>
	  			</c:when>    
	   			<c:otherwise>
	   				<button type="button" class="likeBrunzitOther w3-button w3-round-xlarge w3-theme w3-right">
			    		<img src="imgs/likee.png" alt="Like button" class="like-icon" style="width: 20px; height: 20px;"> &nbsp;<b>${b.likes}</b>
					</button>
	   			</c:otherwise>
			</c:choose>
		</c:if>
		<button type="button"
			class="comments w3-button w3-margin-bottom w3-round-xlarge w3-right">
			<i class="fa fa-comment"></i>
		</button>
		<c:if test = "${user.isAdmin == 1}">
			<button type="button" id = "${b.id}" 
				class="delBrunzitAdminProfile w3-button w3-round-xlarge w3-margin-bottom w3-right">
				<i class="fa fa-trash"></i> &nbsp;
			</button>
		</c:if>
		
	</div>

</c:forEach>


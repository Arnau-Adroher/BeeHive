<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:forEach var="b" items="${brunzits}">


	<div id="${b.id}" 
		class="w3-container w3-card w3-section w3-white w3-round-xxlarge w3-animate-opacity" >
		<br> <span class="w3-right w3-opacity"> ${b.postDateTime}
			<c:if test="${b.isFlash}">
				<i class="fa fa-bolt flash-icon" style="color: #F4C404;"></i>
			</c:if>
		</span>
		<h4>0x<b>${b.userName}</b></h4>
		<hr class="w3-clear">
		<p>${b.content}</p>
		<c:choose>
  			<c:when test="${b.isLiked}">
					<button type="button"  class="dislikeBrunzitProfile w3-button w3-round-xlarge w3-right" style = "color:red;">
						<img src="imgs/dislikee.png" alt="Like button" class="dislike-icon" style="width: 20px; height: 20px;"> &nbsp;<b>${b.likes}</b>
					</button>
  			</c:when>    
   			<c:otherwise>
   				<button type="button" class="likeBrunzitProfile w3-button w3-round-xlarge w3-theme w3-right">
		    		<img src="imgs/likee.png" alt="Like button" class="like-icon" style="width: 20px; height: 20px;"> &nbsp;<b>${b.likes}</b>
				</button>
   			</c:otherwise>
		</c:choose>
		<button type="button" data-brunzit = "${b.id}"
			class="comments w3-button w3-round-xlarge w3-right">
			<i class="fa fa-comment"></i>
		</button>
		<button type="button" id = "trash-btn" 
			class="delBrunzit w3-button w3-margin-bottom  w3-round-xlarge w3-right">
			<i class="fa fa-trash"></i> &nbsp;
		</button>
		
		<!-- <div id = "iterator" >
			
			<p>comments</p>
		</div>-->
		
	</div>

</c:forEach>



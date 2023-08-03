<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.info
{
    cursor: pointer;
}
.info:hover{
   text-decoration:underline;
}
</style>

<div style="display: flex; align-items: center; margin-left: 50px; margin-top: 20px;">
  <h3 style="margin-right: 10px;">Top Melós</h3>
  <img src="imgs/pot_de_mel.png" style="width: 60px;">
</div>
<hr>
<c:forEach var="u" items="${users}" varStatus="status">
  <div id="${u.id}" class="w3-container w3-card w3-round-xxlarge w3-white w3-center w3-section">
    
    <br>
    <c:choose>
      <c:when test="${status.index == 0}">
        <img src="imgs/Bee_top1.png" style="width: 100px;">
      </c:when>
      <c:when test="${status.index == 1}">
        <img src="imgs/Bee_top2.png" style="width: 80px;">
      </c:when>
      <c:when test="${status.index == 2}">
        <img src="imgs/Bee_top3.png" style="width: 60px;">
      </c:when>
    </c:choose>
    
    <div><h5 id="${u.userName}" class="info">0x<b>${u.userName}</b></h5></div>
    <p>Likes totals: ${u.likes}</p>
  </div>
</c:forEach>

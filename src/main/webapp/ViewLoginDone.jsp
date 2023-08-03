 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <script type="text/javascript">
 $(document).ready(function(){
	$('#navigation').load('MenuController');
	$('#rcolumn').load('GetNotFollowedUsers');
	$('#lcolumn').load('GetTopMelos');
	$('#iterator').load('GetUserMainTimeline');
 });
</script>

<div class="w3-container w3-card w3-round-xxlarge w3-white w3-section">
    <h6 class="w3-opacity">${user.userName}, en què penses?</h6>
    <p id="tweetContent" contenteditable="true" class="w3-border w3-padding"></p>
    <button id="addBrunzit" type="button" class="w3-button w3-round-xlarge w3-theme w3-section" data-isflash="FALSE"><i class="fa fa-pencil"></i> &nbsp;Post</button>
    <button id="isFlash" type="button" class="w3-button w3-round-xlarge w3-theme w3-section" data-isflash="TRUE"><i class="fa fa-bolt"></i> &nbsp;Flash post</button>
</div>


 
<div id="iterator">
</div>

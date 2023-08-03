<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="imgs/bbe.png">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title> Beehive </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Seoge UI", sans-serif}
	.navigation {
		background-color: #FFFF8B;
	}
</style>
<script type="text/javascript">
$(document).ready(function(){
	
	$.ajaxSetup({ cache: false }); //Avoids Internet Explorer caching!	
	$(document).on("click",".menu",function(event) {
		$('#content').load($(this).attr('id'));
		event.preventDefault();
	});
	$(document).on("submit","form", function(event) {
		$('#content').load($(this).attr('action'),$(this).serialize());
	    event.preventDefault();
	});
	
	/* Add tweet from profile */
	$(document).on("click", "#addBrunzitProfile", function (event) {
		var tweetContent = $("#tweetContent").text();
		if (tweetContent !== ""){
		    $.post("AddBrunzit", { content: $("#tweetContent").text(), isFlash: false }, function (event) {
		        $("#content").load("LoadOwnTimeline");
		    });
		}
	    event.preventDefault();
	});
	 //Like brunzit profile
	$(document).on("click", ".likeBrunzitProfile", function (event) {
	    $.post("LikeBrunzit", { bid: $(this).parent().attr("id") }, function (event) {
	        $("#content").load("LoadOwnTimeline");
	    });
	    event.preventDefault();
	});
	 
	 //Like brunzit main timeline
	$(document).on("click", ".likeBrunzit", function (event) {
	    $.post("LikeBrunzit", { bid: $(this).parent().attr("id") }, function (event) {
	        $("#content").load("LoadMainTimeline");
	    });
	    event.preventDefault();
	});
	 
	 //Like brunzit from other profile
	$(document).on("click", ".likeBrunzitOther", function (event) {
	    $.post("LikeBrunzit", { bid: $(this).parent().attr("id") }, function (event) {
	        $("#content").load("LoadUserProfile");
	    });
	    event.preventDefault();
	});
	 
	 //dislike brunzit profile
	$(document).on("click", ".dislikeBrunzitProfile", function (event) {
	    $.post("DislikeBrunzit", { bid: $(this).parent().attr("id") }, function (event) {
	        $("#content").load("LoadOwnTimeline");
	    });
	    event.preventDefault();
	});
	 
	 //dislike brunzit main timeline
	$(document).on("click", ".dislikeBrunzit", function (event) {
	    $.post("DislikeBrunzit", { bid: $(this).parent().attr("id") }, function (event) {
	        $("#content").load("LoadMainTimeline");
	    });
	    event.preventDefault();
	});
	 
	 //dislike brunzit from other profile
	$(document).on("click", ".dislikeBrunzitOther", function (event) {
	    $.post("DislikeBrunzit", { bid: $(this).parent().attr("id") }, function (event) {
	        $("#content").load("LoadUserProfile");
	    });
	    event.preventDefault();
	});

	/* Add flash tweet from profile */
	$(document).on("click", "#isFlashProfile", function (event) {
		var tweetContent = $("#tweetContent").text();
		if (tweetContent !== ""){
		    $.post("AddBrunzit", { content: $("#tweetContent").text(), isFlash: true }, function (event) {
		        $("#content").load("LoadOwnTimeline");
		    });
		}
	    event.preventDefault();
	});

	/*Add Tweet From MainPage*/
	$(document).on("click","#addBrunzit",function(event){
		var tweetContent = $("#tweetContent").text();
		if (tweetContent !== ""){
			$.post( "AddBrunzit", { content: $("#tweetContent").text(), isFlash: false }, function(event) {
				$("#content").load("LoadMainTimeline");	
			});
		}
		
		event.preventDefault();
	});
	/*Add Flash Tweet From MainPage*/
	$(document).on("click", "#isFlash", function (event) {
		var tweetContent = $("#tweetContent").text();
		if (tweetContent !== ""){
		    $.post("AddBrunzit", { content: $("#tweetContent").text(), isFlash: true }, function (event) {
		        $("#content").load("LoadMainTimeline");
		    });
		}
	    event.preventDefault();
	});
	
	/* Delete user */
	$(document).on("click",".deleteUser",function(event){
		var brunzit = $(this).parent();
		$.post( "DelUser", { id: $(this).attr("id") } , function(event) {
			$("#content").load("LogoutController");				
		});
		event.preventDefault();
	});
	/* Delete user */
	$(document).on("click",".deleteUserAdmin",function(event){
		var brunzit = $(this).parent();
		$.post( "DelUser", { id: $(this).attr("id") } , function(event) {
			$("#content").load("LoadMainTimeline");				
		});
		event.preventDefault();
	});
	
	/* Delete tweet */
	$(document).on("click",".delBrunzit",function(event){
		var brunzit = $(this).parent();
		$.post( "DelBrunzit", { id: $(this).parent().attr("id") } , function(event) {
			$("#content").load("LoadOwnTimeline");				
		});
		event.preventDefault();
	});
	
	/* Delete brunzit admin*/
	$(document).on("click",".delBrunzitAdmin",function(event){
		var brunzit = $(this).parent();
		$.post( "DelBrunzit", { id: $(this).parent().attr("id") } , function(event) {
			$("#content").load("LoadMainTimeline");				
		});
		event.preventDefault();
	});
	
	/* Delete brunzit admin from user profile*/
	$(document).on("click",".delBrunzitAdminProfile",function(event){
		var brunzit = $(this).parent();
		$.post( "DelBrunzit", { id: $(this).attr("id") } , function(event) {
			$("#content").load("GetOtherUserBrunzits");				
		});
		event.preventDefault();
	});
	/* Follow user */
	$(document).on("click",".followUser",function(event){
		var user = $(this).parent();
		$.post( "FollowUser", { id: $(this).parent().attr("id") }, function(event) {
			$("#content").load("LoadMainTimeline");
			$("#rcolumn").load("GetNotFollowedUsers");
		});
		event.preventDefault();
	});
	
	/* Follow user from profile */
	$(document).on("click",".followUserProfile",function(event){
		var user = $(this).parent();
		$.post( "FollowUser", { id: $(this).attr("id") }, function(event) {
			$("#rcolumn").load("GetIsFollowing");
			$("#lcolumn").load("GetOtherUserInfo");
		});
		event.preventDefault();
	});
	
	/* UnFollow user */
	$(document).on("click",".unfollowUser",function(event) {
		var user = $(this).parent();
		$.post( "UnFollowUser", { id: $(this).parent().attr("id") }, function(event) {
			$("#rcolumn").load("GetFollowedUsers");
		});
		event.preventDefault();
	});
	/* UnFollow user from profile*/
	$(document).on("click",".unfollowUserProfile",function(event) {
		var user = $(this).parent();
		$.post( "UnFollowUser", { id: $(this).attr("id") }, function(event) {
			$("#rcolumn").load("GetIsFollowing");
			$("#lcolumn").load("GetOtherUserInfo");

		});
		event.preventDefault();
	});
	
	/* view user */
	$(document).on("click",".info",function(event) {
		var user = $(this).parent();
		$.post( "GetOtherUser", { userName: $(this).attr("id") }, function(event) {
			$("#content").load("LoadUserProfile");
		});
		event.preventDefault();
	});
	
	$(document).on("click",".editUser",function(event) {
		var user = $(this).parent();
		$.post( "LoadEdit", { userName: $(this).attr("id") }, function(event) {
			$("#content").load("LoadEdit");
		});
		event.preventDefault();
	});
	
});
</script>
</head>
<body>

 	<!-- Begin Navigation -->
 	<div class="w3-bar w3-pale-yellow" id="navigation">
    	<jsp:include page="${menu}" />
 	</div>
 	<!-- End Navigation -->
 
	<!-- Begin Content -->
	<!-- Begin Content -->
	<div class="w3-row-padding">
 	<!-- - Left Column--> 
	<div class="w3-container w3-col m3 w3-hide-small">
		<div id="lcolumn">
			<p></p>
		</div>
	</div>
	<!-- Middle Column -->	
	<div class="e3-container w3-col m6">
		<div id="content">
			<jsp:include page="${content}" />
		</div>
	</div>
	<!-- Right Column -->
	<div class="w3-container w3-col m3 w3-hide-small">
		<div id="rcolumn">
			<p></p>
		</div>
	</div>
	</div>
	<!-- End Content -->
	
	<script>
		function stack() {
  			var x = document.getElementById("stack");
  			if (x.className.indexOf("w3-show") == -1) {
    			x.className += " w3-show";
  			} else { 
    		x.className = x.className.replace(" w3-show", "");
  			}
		}
	</script>

  </body>
</html>
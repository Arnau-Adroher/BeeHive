 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>

 <script type="text/javascript">
 $(document).ready(function(){
	$('#navigation').load('MenuController');
	$('#lcolumn').load('GetOtherUserInfo');
	$('#rcolumn').load('GetIsFollowing');
	$('#iterator').load('GetOtherUserBrunzits');
 });
</script>
 
<div id="iterator">
</div>

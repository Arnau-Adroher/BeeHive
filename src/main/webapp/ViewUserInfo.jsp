<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
	.image-profile{
        width: 100px;
        height: 100px;
        object-fit: cover;
        border-radius: 50%;
        margin-top: 10px;
    }
</style>

<%
// Define an array of image URLs and corresponding source URLs
String[] imageUrls = { "https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/The_Lone_Pollinator.jpg/1200px-The_Lone_Pollinator.jpg",
		"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Bombus_lapidarius_-_Melilotus_officinalis_-_Tallinn.jpg/330px-Bombus_lapidarius_-_Melilotus_officinalis_-_Tallinn.jpg",
		"https://upload.wikimedia.org/wikipedia/commons/6/6c/Osmia_rufa_couple_%28aka%29.jpg",
		"https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Southern_Carpenter_Bee_%28Xylocopa_micans%29_%E2%99%80_%287995162522%29.jpg/330px-Southern_Carpenter_Bee_%28Xylocopa_micans%29_%E2%99%80_%287995162522%29.jpg",
		"https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Halictus_scabiosae_MHNT.jpg/1280px-Halictus_scabiosae_MHNT.jpg" };

String[] sourceUrls = { "https://en.wikipedia.org/wiki/Honey_bee", "https://en.wikipedia.org/wiki/Bumblebee",
		"https://en.wikipedia.org/wiki/Mason_bee", "https://en.wikipedia.org/wiki/Carpenter_bee",
		"https://en.wikipedia.org/wiki/Halictidae" };

String[] beeNames = {
        "Honey Bee",
        "Bumblebee",
        "Mason Bee",
        "Carpenter Bee",
        "Halictus Bee"
    };



// Generate a random index
int randomIndex = (int) (Math.random() * imageUrls.length);

// Get the random image URL and source URL
String randomImageUrl = imageUrls[randomIndex];
String randomSourceUrl = sourceUrls[randomIndex];
// Get the random bee name
String randomBeeName = beeNames[randomIndex];
%>

<div class="w3-container w3-card w3-round-xxlarge w3-white w3-section w3-center">
	<div style="display: flex; flex-direction: column; align-items: center;">
        <img src="<%=randomImageUrl%>" class="image-profile">
        <p><%=randomBeeName%></p>
        <a href="<%=randomSourceUrl%>" target="_blank">
            <button type="button" class="w3-row w3-button w3-round-xlarge w3-yellow w3-section">
                <i class="fas fa-bee"></i> &nbsp;Saber-ne mes
            </button>
        </a>
    </div>
    <hr>

	<h4>Perfil de 0x${user.userName}</h4>

	<hr>
	<p>Info</p>
	<p class="w3-left-align">
		<i class="fa fa-id-badge fa-fw w3-margin-right"></i> Nom:
		${user.name}
	</p>
	<p class="w3-left-align">
		<i class="fa fa-info-circle fa-fw w3-margin-right"></i> Any de neixament:
		${user.birthDate}
	</p>
	
	<button type="button"
		class="editUser w3-row w3-button w3-round-xlarge w3-yellow w3-section">
		<img src="imgs/edit.png" alt="edit" class="editUser" style="width: 40px; height: 40px;"> &nbsp;Editar
	</button>
	<br>
	<button type="button" id = "${user.id}" class="deleteUser w3-row w3-button w3-round-xlarge w3-red w3-section">Eliminar compte</button>
</div>
<br>
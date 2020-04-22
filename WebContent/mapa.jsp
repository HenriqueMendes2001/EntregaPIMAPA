<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Cliente" %>
<!DOCTYPE html>

<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Bonvinos</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		
		<style>
      		#map {
        	height: 600px;  /* Alterar altura do mapa*/
        	width: 100%;  /* Largura que ocupara na tela */
       		}
   		</style>
	</head>
	
	<body>
		<!-- Barra superior com os menus de navegação -->
		<c:import url="menu.jsp"/>
		
    	<!--Div com o mapa-->
    	<div id="map"></div>
    	<script>
		// Cria e instancia o mapa
		function initMap() {
  		// Pega a localizacao
  		var localizacao = {lat: -25.344, lng: 131.036};
  		// Exibe o mapa com a localizacao
  		var map = new google.maps.Map(document.getElementById('map'), {zoom: 4, center: localizacao});
  		// Cria um marcador no endereco
  		var marker = new google.maps.Marker({position: localizacao, map: map});
		}
   		</script>
   		
    	<script async defer
    	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD3wqQTDUilM21z4LUOKiFQQyypEraY-Ik&callback=initMap">
    	</script>
		
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/CPS298_Nba/resources/StyleSheets/HomeStyle.css">
<script src="/CPS298_Nba/resources/js/homeScript.js" defer></script>
<head>
<meta charset="ISO-8859-1">
<title>Analytics Home</title>
</head>
<body class= "body">

<div class="leftBox">
	<div class = "todayGameTitle">Yesterday's game results: ${yesterDate}</div>
	${yesterGamesHTML}
</div>

<div class="rightBox">

	<div class="topRightBox">
		<div class="todayGamesTitle">Today's games: ${todayDate}</div>
		<div id="game-carousel">
			${todayGamesHTML}
		</div>
		<a href="/CPS298_Nba/calender">
		<button class="calendar-button" type="submit">SEASON CALENDAR</button>
		</a>
	</div>
	
	<div class="botRightBox">
		<div class="todayGamesTitle">Top Player Stats</div>
		<div id="player-carousel">
			${playerStats}
		</div>
	</div>
</div>


</body>
</html>
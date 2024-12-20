<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Game Facts</title>
    <!-- Link to the external stylesheet -->
    <link rel="stylesheet" href="/CPS298_Nba/resources/StyleSheets/FactsStyle.css">
</head>
<body>
    <div class="container">
        <h1>Game Facts</h1>

        <!-- Main Content (Flexbox Layout) -->
        <div class="main-content">
            <!-- Left Section - Game Details -->
            <div class="cards-container">
                <c:if test="${not empty game}">
                    <div class="card shadow-lg">
                        <div class="card-body">
                            <!-- Venue Address -->
                            <h5 class="card-title">Venue Address: ${game.venueAddress}</h5>
                            <!-- Game Scheduled Date -->
                            <p><strong>Scheduled Date:</strong> ${game.scheduled}</p>
                            
                            <!-- Home vs Away teams -->
                            <div class="home-vs-away">
                                <h2>${game.home_team.name} vs ${game.away_team.name}</h2>
                            </div>
							
							
                            <!-- Home Team Players -->
                            <h3>Home Team Players</h3>
                            <ul class="team-players">
                                <c:forEach var="player" items="${homePlayers}">
                                    <li>${player.fullName}</li>
                                </c:forEach>
                            </ul>

                            <!-- Away Team Players -->
                            <h3>Away Team Players</h3>
                            <ul class="team-players">
                                <c:forEach var="player" items="${awayPlayers}">
                                    <li>${player.fullName}</li>
                                </c:forEach>
                            </ul>

                            <!-- Navigation Buttons -->
                            <div class="nav-buttons">
                                <a href="${pageContext.request.contextPath}/calender" class="btn btn-primary">Back to Game Schedule</a>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
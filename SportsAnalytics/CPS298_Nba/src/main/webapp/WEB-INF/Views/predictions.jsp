<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Game Prediction</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1e1e2f;
            color: #ffffff;
            margin: 0;
            padding: 0;
        }

        h1, h2, h3 {
            text-align: center;
            color: #ffcc00;
        }

        .match-heading {
            font-size: 28px;
            text-align: center;
            margin: 20px 0;
            font-weight: bold;
        }

        .match-heading span {
            color: #4caf50;
        }

        .message-box {
            background-color: #29293d;
            border-radius: 10px;
            padding: 15px;
            margin: 20px auto;
            width: 80%;
            text-align: center;
            color: #ffcc00;
            font-size: 18px;
        }

        .comparison-container {
            display: flex;
            justify-content: space-between;
            margin: 20px auto;
            width: 90%;
        }

        .team-section {
            flex: 1;
            background-color: #29293d;
            border-radius: 10px;
            padding: 20px;
            margin: 0 10px;
        }

        .team-section h2 {
            color: #ffcc00;
            text-align: center;
        }

        .team-stats {
            margin-top: 20px;
            background-color: #38384d;
            border-radius: 10px;
            padding: 15px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }

        .team-stats h3 {
            text-align: center;
            margin-bottom: 15px;
            color: #ffcc00;
            font-size: 18px;
            border-bottom: 2px solid #ffcc00;
            padding-bottom: 5px;
        }

        .stat-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 10px;
            background-color: #29293d;
            border: 1px solid #4caf50;
            border-radius: 5px;
            padding: 10px 15px;
        }

        .stat-item span {
            font-size: 16px;
            color: #ffffff;
        }

        .stat-item span.label {
            font-weight: bold;
            color: #ffcc00;
        }

        .stat-item span.value {
            text-align: right;
            color: #4caf50;
        }

        .players {
            margin-top: 20px;
        }

        .player-card {
            margin-bottom: 15px;
            background-color: #38384d;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }

        .player-card h4 {
            font-size: 18px;
            color: #ffcc00;
            text-align: center;
            margin-bottom: 10px;
            border-bottom: 2px solid #ffcc00;
            padding-bottom: 10px;
        }

        .player-stats {
            display: table;
            width: 100%;
            text-align: left;
        }

        .player-stats div {
            display: table-row;
        }

        .player-stats div span {
            display: table-cell;
            padding: 8px 15px;
            color: #fff;
        }

        .player-stats .label {
            font-weight: bold;
            color: #ffcc00;
            width: 220px;
        }

        .player-stats .value {
            color: #4caf50;
            text-align: right;
        }

        .win-prob-container {
            margin: 20px auto;
            width: 90%;
        }

        .win-prob-heading {
            text-align: center;
            font-size: 22px;
            margin-bottom: 20px;
        }

        .win-prob-bar {
            display: flex;
            align-items: center;
            position: relative;
        }

        .win-prob-bar span {
            font-size: 16px;
            margin: 0 10px;
        }

        .bar-container {
            flex: 1;
            height: 20px;
            background-color: #38384d;
            position: relative;
            border-radius: 10px;
            overflow: hidden;
        }

        .home-bar {
            position: absolute;
            left: 0;
            height: 100%;
            background-color: #4caf50;
        }

        .away-bar {
            position: absolute;
            right: 0;
            height: 100%;
            background-color: #f44336;
        }

        .scale-container {
            text-align: center;
            margin: 20px 0;
        }

        .scale {
            width: 80%;
            margin: 0 auto;
            position: relative;
            height: 40px;
            background: linear-gradient(to right, #f44336, #ffeb3b, #4caf50);
            border-radius: 20px;
        }

        .scale-number {
            position: absolute;
            top: -20px;
            color: #ffffff;
            font-weight: bold;
        }

        .scale-marker {
            position: absolute;
            height: 40px;
            width: 5px;
            background-color: #ffffff;
            border-radius: 2px;
        }

        .marker-label {
            text-align: center;
            color: #ffffff;
            font-size: 14px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>Game Prediction</h1>

    <div class="match-heading">
        <span>${gamePrediction.homeTeam.name}</span> vs <span>${gamePrediction.awayTeam.name}</span>
    </div>

    <!-- Win/Loss Prediction Bar -->
    <div class="win-prob-container">
        <h2 class="win-prob-heading">Win/Loss Prediction</h2>
        <div class="win-prob-bar">
            <span>${gamePrediction.homeTeam.name}: ${gamePrediction.homeWinProbability}%</span>
            <div class="bar-container">
                <div class="home-bar" style="width: ${gamePrediction.homeWinProbability}%;"></div>
                <div class="away-bar" style="width: ${gamePrediction.awayWinProbability}%;"></div>
            </div>
            <span>${gamePrediction.awayTeam.name}: ${gamePrediction.awayWinProbability}%</span>
        </div>
    </div>
    <br>

    <!-- Game Interest Rating -->
    <div class="scale-container">
        <div class="scale">
            <div class="scale-marker" style="left: calc(${gamePrediction.gameRating * 10}%);"></div>
            <div class="marker-label" style="left: calc(${gamePrediction.gameRating * 10}%);">
                ${gamePrediction.gameRating}
            </div>
            <div class="scale-number" style="left: 0;">1</div>
            <div class="scale-number" style="right: 0;">10</div>
        </div>
        <h2>Game Interest Rating: ${gamePrediction.gameRating}/10</h2>
        <div class="message-box">
            ${gamePrediction.message}
        </div>
    </div>

    <!-- Comparison Section -->
    <div class="comparison-container">
        <!-- Home Team Section -->
        <div class="team-section">
            <h2>${gamePrediction.homeTeam.name}</h2>
            <div class="team-stats">
                <h3>Team Stats</h3>
                <div class="stat-item">
                    <span class="label">Possessions:</span>
                    <span class="value">${gamePrediction.homeTeamStats.possessions}</span>
                </div>
                <div class="stat-item">
                    <span class="label">Offensive Rating:</span>
                    <span class="value">${gamePrediction.homeTeamStats.offensive_rating}</span>
                </div>
                <div class="stat-item">
                    <span class="label">Defensive Rating:</span>
                    <span class="value">${gamePrediction.homeTeamStats.defensive_rating}</span>
                </div>
                <div class="stat-item">
                    <span class="label">Net Rating:</span>
                    <span class="value">${gamePrediction.homeTeamStats.net_rating}</span>
                </div>
            </div>

            <!-- Top Players Section for Home Team -->
            <div class="players">
                <h3>Top 3 Players</h3>
                <c:forEach var="entry" items="${gamePrediction.homeTopPlayers}">
                    <div class="player-card">
                        <h4>${entry.key.fullName}</h4>
                        <div class="player-stats">
                            <div>
                                <span class="label">3-Point Efficiency:</span>
                                <span class="value">${entry.value.threePointerEff}</span>
                            </div>
                            <div>
                                <span class="label">2-Point Efficiency:</span>
                                <span class="value">${entry.value.twoPointerEff}</span>
                            </div>
                            <div>
                                <span class="label">Efficiency:</span>
                                <span class="value">${entry.value.efficieny}</span>
                            </div>
                            <div>
                                <span class="label">Assists:</span>
                                <span class="value">${entry.value.assists}</span>
                            </div>
                            <div>
                                <span class="label">Steals:</span>
                                <span class="value">${entry.value.steals}</span>
                            </div>
                            <div>
                                <span class="label">Blocks:</span>
                                <span class="value">${entry.value.blocks}</span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <!-- Away Team Section -->
        <div class="team-section">
            <h2>${gamePrediction.awayTeam.name}</h2>
            <div class="team-stats">
                <h3>Team Stats</h3>
                <div class="stat-item">
                    <span class="label">Possessions:</span>
                    <span class="value">${gamePrediction.awayTeamStats.possessions}</span>
                </div>
                <div class="stat-item">
                    <span class="label">Offensive Rating:</span>
                    <span class="value">${gamePrediction.awayTeamStats.offensive_rating}</span>
                </div>
                <div class="stat-item">
                    <span class="label">Defensive Rating:</span>
                    <span class="value">${gamePrediction.awayTeamStats.defensive_rating}</span>
                </div>
                <div class="stat-item">
                    <span class="label">Net Rating:</span>
                    <span class="value">${gamePrediction.awayTeamStats.net_rating}</span>
                </div>
            </div>

            <!-- Top Players Section for Away Team -->
            <div class="players">
                <h3>Top 3 Players</h3>
                <c:forEach var="entry" items="${gamePrediction.awayTopPlayers}">
                    <div class="player-card">
                        <h4>${entry.key.fullName}</h4>
                        <div class="player-stats">
                            <div>
                                <span class="label">3-Point Efficiency:</span>
                                <span class="value">${entry.value.threePointerEff}</span>
                            </div>
                            <div>
                                <span class="label">2-Point Efficiency:</span>
                                <span class="value">${entry.value.twoPointerEff}</span>
                            </div>
                            <div>
                                <span class="label">Efficiency:</span>
                                <span class="value">${entry.value.efficieny}</span>
                            </div>
                            <div>
                                <span class="label">Assists:</span>
                                <span class="value">${entry.value.assists}</span>
                            </div>
                            <div>
                                <span class="label">Steals:</span>
                                <span class="value">${entry.value.steals}</span>
                            </div>
                            <div>
                                <span class="label">Blocks:</span>
                                <span class="value">${entry.value.blocks}</span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>

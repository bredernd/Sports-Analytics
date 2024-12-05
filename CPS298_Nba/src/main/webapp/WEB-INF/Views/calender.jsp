<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Game Schedule</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
    <style>
        /* Dark Theme */
        body {
            background-color: #121212;
            color: #f8f9fa; /* Light text for readability */
            margin: 0;
            padding: 0;
            height: 100%;
            display: flex;
            flex-direction: column;
            overflow-y: auto; /* Entire page is scrollable */
        }

        /* Main Container */
        .container {
            margin-top: 50px;
            flex: 1;
            overflow-y: auto;
        }

        /* Header */
        h1 {
            color: #f1f1f1;
            text-align: left;
            padding-left: 20px; /* Align header with cards */
            margin-bottom: 30px;
            font-size: 2.5rem;
        }

        /* Flex layout for the main content */
        .main-content {
            display: flex;
            justify-content: flex-start;
        }

        /* Cards - Left Column */
        .cards-container {
            flex: 1 1 70%; /* Takes 70% width on large screens */
            max-width: 70%;
            margin-right: 20px;
            overflow-y: auto;
        }

        .card {
            background-color: #1e1e1e;
            border: none;
            margin-bottom: 20px;
            border-radius: 8px;
            transition: transform 0.2s;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            padding: 20px;
        }

        .card:hover {
            transform: scale(1.05);
        }

        .card-body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }

        .card-title {
            font-size: 2.5rem; /* Larger font size for better readability */
            text-align: center;
            margin-bottom: 20px; /* Space between title and buttons */
            color: #e0e0e0; /* Lighter text color for readability */
        }

        /* Button Styles */
        .btn {
            padding: 10px 30px; /* Increased width, decreased height */
            font-size: 1.4rem; /* Larger font size for better readability */
            border-radius: 5px;
            transition: background-color 0.3s ease;
            margin: 10px 15px; /* Adds space between buttons */
            width: auto;
        }

        .btn-primary {
            background-color: #0d6efd;
            border-color: #0d6efd;
        }

        .btn-primary:hover {
            background-color: #084298;
        }

        .btn-secondary {
            background-color: #6c757d;
            border-color: #6c757d;
        }

        .btn-secondary:hover {
            background-color: #5a6268;
        }

        /* Sidebar - Right Column (Empty) */
        aside {
            flex: 0 0 5%; /* Small vertical blank column */
            max-width: 5%;
            background-color: transparent;
        }

        /* For smaller screens */
        @media (max-width: 768px) {
            .cards-container {
                max-width: 100%;
                margin-right: 0;
            }
            aside {
                max-width: 100%;
                margin-top: 20px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>NBA Game Schedule</h1>

        <!-- Main Content (Flexbox Layout) -->
        <div class="main-content">
            <!-- Cards Section (Left Side) -->
            <div class="cards-container">
                <c:forEach var="game" items="${gameSchedules}">
                    <c:if test="${game.scheduled != prevScheduled}">
                        <!-- Display the Date as a Heading for Each Group (Only Once for each date) -->
                        <h2 style="text-align: center; font-size: 2rem; margin-top: 60px; margin-bottom: 30px; color: #e0e0e0;">
                            ${game.scheduled}
                        </h2>
                        <!-- Store the current date to avoid duplicate headings -->
                        <c:set var="prevScheduled" value="${game.scheduled}" />
                    </c:if>

                    <!-- Card for the Game -->
                    <div class="card shadow-lg">
                        <div class="card-body">
                            <!-- Home vs Away teams in center -->
                            <h5 class="card-title">
                                ${game.home_team.name} vs ${game.away_team.name}
                            </h5>
                            <!-- Buttons to view game facts or predictions (Horizontal layout) -->
                            <div class="d-flex justify-content-center w-100">
                                <!-- Game Facts Button -->
                                <form action="gameFacts" method="GET" class="mx-2">
                                    <input type="hidden" name="gameId" value="${game.game_id}">
                                    <button type="submit" class="btn btn-primary">Game Facts</button>
                                </form>

                                <!-- Predictions Button -->
                                <form action="predictions" method="GET" class="mx-2">
                                    <input type="hidden" name="gameId" value="${game.game_id}">
                                    <button type="submit" class="btn btn-secondary">Predictions</button>
                                </form>
                            </div>
                        </div>
                    </div>

                    <!-- Add space between the groups -->
                    <div style="margin-bottom: 30px;"></div>
                </c:forEach>
            </div>

            <!-- Sidebar Section (Right Side - Empty for advertisement) -->
            <aside></aside>
        </div>
    </div>
</body>
</html>

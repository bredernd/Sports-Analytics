<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calendar</title>

<style>

    .wrapper {
        display: flex;
        flex-direction: column;
        align-items: center;
        min-height: 100vh;
        justify-content: center;
    }

    .calTitle {
        text-align: center;
        font-size: 50px;
        margin-bottom: 20px; /* Space between title and calendar */
        width: 100%;
    }
    .calendar { 
        display: grid; 
        grid-template-columns: repeat(7, 1fr); 
        gap: 10px; 
        width: fit-content; 
    }
    .day { 
        border: 1px solid #ddd; 
        padding: 10px;
        width: 130px;
        height: 92px; 
        text-align: center;
    }
</style>
</head>
<body>


EACH CARD WILL HAVE THREE BUTTONS: THIRD BUTTON IS OPTIONAL
WE WILL PURSUE DEVELOPING THRID BUTTON ONLY WHEN WE HAVE TIME
GAME FACTS, PREDICTIONS, AND (LIVE SOCORE, OR SITE TO VIEW GAME)<br>

    <div class="wrapper">
        <div class="calTitle">${month} ${year}</div>
        <div class="calendar">
            ${calendarHtml}
        </div>
    </div>


</body>
</html>
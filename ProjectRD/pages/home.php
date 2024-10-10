<?php


function init(){
    $display = nbaDisplay();
    if(isset($_SESSION['orgSelect'])){
        if($_SESSION['orgSelect'] === 'NBA'){
            $display = nbaDisplay();
        }
        if($_SESSION['orgSelect'] === 'NFL'){
            $display = nflDisplay();
        }
        if($_SESSION['orgSelect'] === 'MLB'){
            $display = mlbDisplay();
        }
    }

    return[
    '
    <link rel="stylesheet" href="StyleSheets/home.css">
    </head>
    <body class="body">
    '
    ,
    '
    <form method="POST" action="index.php?page=home">
        <div class="container">
            <div class="orgCont">
                <div class="orgButtCont">
                    <button class="NBAButt" type="submit" name="NBAButt" id="NBAButt"></button>
                    <button class="NFLButt" type="submit" name="NFLButt" id="NFLButt"></button>
                    <button class="MLBButt" type="submit" name="MLBButt" id="MLBButt"></button>
                </div>
            </div>
            <div class="teamsCont">
                ' . $display . '
            </div>
        </div>
    '
    ,
    '
    </form>
    '];
}

function nbaDisplay(){
    $display = " ";
    for($i=0; $i < 10; $i++){
        $display .=   
        '<div class="teamCont">
        <div class="teamInfoCont">
            <div class="teamLogo">NBA LOGO</div>
            <div class="teamName">NBA TEAM NAME/INFO</div>
        </div>
        <div class="teamStatsCont">
            <div class="statBox">STAT 1</div>
            <div class="statBox">STAT 2</div>
            <div class="statBox">STAT 3</div>
            <div class="statBox">STAT 4</div>
        </div>
    </div>';
    }
    return $display;
}

function nflDisplay(){
    $display = " ";
    for($i=0; $i < 10; $i++){
        $display .=   
        '<div class="teamCont">
        <div class="teamInfoCont">
            <div class="teamLogo">NFL LOGO</div>
            <div class="teamName">NFL TEAM NAME/INFO</div>
        </div>
        <div class="teamStatsCont">
            <div class="statBox">STAT 1</div>
            <div class="statBox">STAT 2</div>
            <div class="statBox">STAT 3</div>
            <div class="statBox">STAT 4</div>
        </div>
    </div>';
    }
    return $display;
}

function mlbDisplay(){
    $display = " ";
    for($i=0; $i < 10; $i++){
        $display .=   
        '<div class="teamCont">
        <div class="teamInfoCont">
            <div class="teamLogo">MLB LOGO</div>
            <div class="teamName">MLB TEAM NAME/INFO</div>
        </div>
        <div class="teamStatsCont">
            <div class="statBox">STAT 1</div>
            <div class="statBox">STAT 2</div>
            <div class="statBox">STAT 3</div>
            <div class="statBox">STAT 4</div>
        </div>
    </div>';
    }
    return $display;
}

if(isset($_POST['NBAButt'])){
    $_SESSION['orgSelect'] = 'NBA';
}

if(isset($_POST['NFLButt'])){
    $_SESSION['orgSelect'] = 'NFL';
}

if(isset($_POST['MLBButt'])){
    $_SESSION['orgSelect'] = 'MLB';
}
?>
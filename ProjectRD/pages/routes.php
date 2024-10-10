<?php
$path = "index.php?page=home";
$nav="";

if(isset($_GET)){
    $page = $_GET['page'];
    switch($page){
        case 'home':
            require_once('pages/home.php');
            $result = init();
            $nav ="";
            break;
        default:
            header('location: '.$path);
            break;
    }
}


else{
    header('location: '.$path);
}
?>
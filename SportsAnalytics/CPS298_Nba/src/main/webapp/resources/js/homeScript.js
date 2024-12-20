document.addEventListener("DOMContentLoaded", () => {
    const games = document.querySelectorAll(".game");
    const players = document.querySelectorAll(".player");
    let currentIndex = 0;
    let index = 0;

    const cycleGames = () => {
        games[currentIndex].classList.remove("active");
        currentIndex = (currentIndex + 1) % games.length;
        games[currentIndex].classList.add("active");
    };
    
    const cyclePlayers = () =>{
		players[index].classList.remove("active");
		index = (index + 1) % players.length;
		players[index].classList.add("active");
	
	};

    games[currentIndex].classList.add("active");
    players[index].classList.add("active");


    setInterval(cycleGames, 6000);
    setInterval(cyclePlayers, 6500);
});
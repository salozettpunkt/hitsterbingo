async function loadBingoBoard() {
    try {
        const response = await fetch('http://localhost:3000/api/bingo-board');
        const bingoBoard = await response.json();
        displayBingoBoard(bingoBoard);
    } catch (error) {
        console.error("Fehler beim Laden des Bingo-Boards:", error);
    }
}

function displayBingoBoard(bingoBoard) {
    const boardDiv = document.getElementById('bingo-board');
    boardDiv.innerHTML = ''; // Vorherige Inhalte entfernen
    for (const row of bingoBoard) {
        for (const color of row) {
            const cell = document.createElement('div');
            cell.className = 'cell';
            cell.style.backgroundColor = color; // Setze die Hintergrundfarbe
            boardDiv.appendChild(cell);
        }
    }
}

// Lade das Bingo-Board beim Laden der Seite
loadBingoBoard();

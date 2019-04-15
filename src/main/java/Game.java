class Game {
    private Messages messages = new Messages();
    private Player playerCross = new Player("X");
    private Player playerNought = new Player("O");
    private Player currentPlayer = playerCross;
    private Board board = new Board();
    private Rules rules = new Rules(board);
    private Display display = new Display(board);
    private boolean gameOver = false;
    private String winner = "";

    void play() {
        intro();
        do {
            newTurn();
            processTurn();
        } while (!isGameOver());
        gameEnd();
    }

    private void intro() {
        Display.outMessage(messages.getIntro());
    }

    private void newTurn() {
        display.showBoard();
        Display.outMessage(messages.announcePlayerTurn(currentPlayer));
        int playerInput = currentPlayer.getNextMove();
        board.addMoveToBoard(playerInput, currentPlayer);
    }

    private void processTurn() {
        gameOver = rules.gameIsOver();
        boolean hasWon = rules.hasWinningMove(currentPlayer);
        if (hasWon) {
            winner = currentPlayer.getSymbol();
            gameOver = true;
            return;
        }
        switchPlayer();
    }

    private void switchPlayer() {
        if (currentPlayer == playerCross) {
            currentPlayer = playerNought;
        } else {
            currentPlayer = playerCross;
        }
    }

    private void gameEnd() {
        display.showBoard();
        if (aPlayerHasWon()) {
            Display.outMessage(messages.playerWin(currentPlayer));
        } else {
            Display.outMessage(messages.playersDraw());
        }
    }

    private boolean aPlayerHasWon() { return this.gameOver && !this.winner.isEmpty(); }

    private boolean isGameOver() {
        return gameOver;
    }
}

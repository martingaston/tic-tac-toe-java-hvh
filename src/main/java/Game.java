import java.io.IOException;

class Game {
    private static Board board;
    private static Players players;

    static void play(State state) throws IOException {
        board = state.board();
        players = state.players();

        intro();
        instructions();
        do {
            newTurn();
            processTurn(state);
        } while (!board.isGameOver());
    }

    private static void processTurn(State state) throws IOException {
        IO.gameOut(state);
        if (board.isGameOver()) {
            IO.closeGame();
            gameEnd();
        } else {
            players.nextTurn();
        }
    }

    private static void intro() {
        Display.outMessage(Messages.getIntro());
    }

    private static void instructions() {
        Display.outMessage(Messages.getInstructions(board.sideLength()));
    }

    private static void newTurn() {
        Display.showBoard(board);
        Display.outMessage(Messages.announcePlayerTurn(currentPlayer()));
        int playerInput = currentPlayer().getNextMove(board);
        board.add(playerInput, currentPlayer().symbol());
    }

    private static Player currentPlayer() {
        return players.getCurrentPlayer();
    }

    private static void gameEnd() {
        Display.showBoard(board);

        if (board.hasWinner()) {
            Display.outMessage(Messages.playerWin(currentPlayer()));
        } else {
            Display.outMessage(Messages.playersDraw());
        }
    }
}

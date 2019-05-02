import java.util.Scanner;

public class Players {
    private Player playerCross;
    private Player playerNought;
    private Player currentPlayer;

    Players(Rules rules, Board board) {
        Scanner input = new Scanner(System.in);
        int modeNumber = input.nextInt();
        switch(modeNumber) {
            case 1:
                this.playerCross = new PlayerHuman("X", rules);
                this.playerNought = new PlayerHuman("O", rules);
                break;
            case 2:
                this.playerCross = new PlayerHuman("X", rules);
                this.playerNought = new PlayerCPU("O", rules, board);
                break;
            case 3:
                this.playerCross = new PlayerCPU("X", rules, board);
                this.playerNought = new PlayerCPU("O", rules, board);
                break;
            case 4:
                this.playerCross = new PlayerHuman("X", rules);
                this.playerNought = new PlayerMinimax("O", rules, board, playerCross);
        }
        this.currentPlayer = playerCross;
    }

    public Players(Player playerCross, Player playerNought) {
        this.playerCross = playerCross;
        this.playerNought = playerNought;
        this.currentPlayer = this.playerCross;
    }

    public void nextTurn() {
        if (currentPlayer == playerCross) {
            currentPlayer = playerNought;
        } else {
            currentPlayer = playerCross;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}

public class PlayerMinimax implements Player {
    private String symbol;
    private Minimax minimax;


    PlayerMinimax(String symbol, Rules rules, Board board, Player opponent) {
        this.symbol = symbol;
        minimax = new Minimax(board, rules, this, opponent);
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int getNextMove() {
        oneSecondSleep();
        return minimax.optimal();
    }

    private void oneSecondSleep() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
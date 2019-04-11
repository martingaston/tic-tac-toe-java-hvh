import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RulesTest {
    private Rules rules;
    private Player player;

    @Before
    public void setUp() {
        rules = new Rules();
        player = new Player("X");
    }

    @Test
    public void CheckForBoardStateFromBoardClass() {
        String[] boardState = {
                "X", "X", "",
                "", "", "",
                "", "", ""
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        int boardPositionToUpdate = 2;
        board.updateBoard(boardPositionToUpdate, player);
        assertTrue(rules.hasWinningMove(player));

    }

    @Test
    public void CheckForBoardStateWithSpacesFromBoardClass() {
        String[] boardState = {
                "X", "X", " ",
                " ", " ", " ",
                " ", " ", " "
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        int boardPositionToUpdate = 2;
        board.updateBoard(boardPositionToUpdate, player);
        assertTrue(rules.hasWinningMove(player));

    }

    @Test
    public void CheckForWinningDiagonalLeftMove() {
        String[] boardState = {
                "X", " ", " ",
                " ", "X", " ",
                " ", " ", "X"
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void CheckForWinningDiagonalRightMove() {
        String[] boardState = {
                " ", " ", "X",
                " ", "X", " ",
                "X", " ", " "
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void CheckForWinningHorizontalTopMove() {
        String[] boardState = {
                "X", "X", "X",
                " ", " ", " ",
                " ", " ", " "
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void CheckForWinningHorizontalMiddleMove() {
        String[] boardState = {
                " ", " ", " ",
                "X", "X", "X",
                " ", " ", " "
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void CheckForWinningHorizontalBottomMove() {
        String[] boardState = {
                " ", " ", " ",
                " ", " ", " ",
                "X", "X", "X"
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void CheckForWinningVerticalLeftMove() {
        String[] boardState = {
                "X", " ", " ",
                "X", " ", " ",
                "X", " ", " "
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void CheckForWinningVerticalCenterMove() {
        String[] boardState = {
                " ", "X", " ",
                " ", "X", " ",
                " ", "X", " "
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void CheckForWinningVerticalRightMove() {
        String[] boardState = {
                " ", " ", "X",
                " ", " ", "X",
                " ", " ", "X"
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void CheckThatNoWinningVerticalMoveReturnsFalse() {
        String[] boardState = {
                "O", "X", "O",
                " ", "X", "O",
                "O", "O", "X"
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertFalse(rules.hasWinningMove(player));
    }

    @Test
    public void CheckThatNoWinningHorizontalMoveReturnsFalse() {
        String[] boardState = {
                "O", " ", "O",
                "X", "X", "O",
                "O", "O", "X"
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertFalse(rules.hasWinningMove(player));
    }

    @Test
    public void CheckThatWinningMovesIsFalseIfOtherPlayerShouldWin() {
        String[] boardState = {
                "O", "O", "O",
                "X", "X", "O",
                "O", "O", "X"
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertFalse(rules.hasWinningMove(player));
    }

    @Test
    public void CheckThatBoardStateThatIsNotFullReturnsFalseOnGameIsOver() {
        String[] boardState = {
                " ", "X", " ",
                "O", " ", " ",
                " ", "X", " "
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertFalse(rules.gameIsOver());
    }

    @Test
    public void CheckThatBoardStateThatIsFullReturnsTrueOnGameIsOverWithBoardClass() {
        String[] boardState = {
                "X", "X", "O",
                "O", "O", "X",
                "X", "X", "O"
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.gameIsOver());
    }

    @Test
    public void CheckThatBoardStateThatIsFullReturnsTrueOnGameIsOver() {
        String[] boardState = {
                "X", "X", "O",
                "O", "O", "X",
                "X", "X", "O"
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.gameIsOver());
    }

    @Test
    public void CheckThatBoardOfSpacesReturnsFalseOnGameIsOver() {
        String[] boardState = {
                " ", " ", " ",
                " ", " ", " ",
                " ", " ", " "
        };
        Board board = new Board(boardState);
        rules = new Rules(board);
        assertFalse(rules.gameIsOver());
    }
}
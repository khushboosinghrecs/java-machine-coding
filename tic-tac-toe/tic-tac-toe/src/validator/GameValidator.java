package validator;
import java.util.HashMap;

import model.Board;

public class GameValidator {
    Board board;
    HashMap<Integer, Boolean> playerCheck;

    public GameValidator(Board board, HashMap<Integer, Boolean> playerCheck){
        this.board = board;
        this.playerCheck = playerCheck;
    }

    public boolean validateCoordinates(int x, int y){
        return x < board.getBoard().length && y< board.getBoard().length && x>=0 && y>=0;
    }
// validateIsBoardPositionEmpty
    public boolean validateIsBoardPositionEmpty(int x, int y){
        return board.getposition(x, y).equals("_");
    }

}

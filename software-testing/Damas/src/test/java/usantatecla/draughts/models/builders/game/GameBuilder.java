package usantatecla.draughts.models.builders.game;

import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import usantatecla.draughts.models.Board;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Draught;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.Pawn;
import usantatecla.draughts.models.Piece;

public class GameBuilder {
    
    private Color color;
    private String[] gameRows;

    public GameBuilder() {
        this.color = null;
        this.gameRows = new String[Coordinate.getDimension()];               
    }

    public GameBuilder color(Color color){
        this.color = color;
        return this;
    }

    public GameBuilder rows (Set<Entry<Integer, String>> set){
        for (Entry<Integer,String> row : set){
            assert row.getKey() < Coordinate.getDimension() && row.getKey() >= 0;
            gameRows[row.getKey()] = row.getValue();
        }
        return this;
    }

    public GameBuilder row (int row, String gameRow) {
        int gameDimension = Coordinate.getDimension();
        assert Pattern.matches("[bBnN ]{" + gameDimension + "}", gameRow);
        assert row < gameDimension && row >= 0;
        
        gameRows[row] = gameRow;

        return this;
    }

    public Game build() {
        if (this.gameRowsAreEmpty())
            return new Game();
        Board board = new Board();
        Game game = new Game(board);
        this.setColor(game, board);
        this.setRows(game, board);
        return game;
    }

    private boolean gameRowsAreEmpty() {
        for (String row : this.gameRows)
            if(row != null)
                return false;
        return true;
    }

    private void setColor(Game game, Board board) {
        if (this.color == Color.BLACK) {
            board.put(new Coordinate(7, 0), new Pawn(Color.WHITE));
            game.move(new Coordinate(7, 0), new Coordinate(6, 1));
            board.remove(new Coordinate(6, 1));
        }
    }

    private void setRow(Board board, int row, String gameRow){
        for (int i = 0; i < gameRow.length(); i++) {
            Color color = this.getColor(gameRow.charAt(i));
            if (color != null) {
                Piece piece = new Pawn(color);
                if (Character.isUpperCase(gameRow.charAt(i)))
                    piece = new Draught(color);
                board.put(new Coordinate(row, i), piece);
            }
        }
    }

    private void setRows(Game game, Board board) {
        for (int row = 0; row < this.gameRows.length; row++){
            if (this.gameRows[row] != null) {
                this.setRow(board, row, this.gameRows[row]);     
            }
        }
    }

    private Color getColor(char character) {
        switch (character) {
        case 'b':
        case 'B':
            return Color.WHITE;
        case 'n':
        case 'N':
            return Color.BLACK;
        default:
            return null;
        }
    }



}

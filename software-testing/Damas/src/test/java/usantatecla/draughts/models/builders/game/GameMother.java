package usantatecla.draughts.models.builders.game;

import java.util.regex.Pattern;

import org.apache.commons.lang3.tuple.Pair;

import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Game;

public class GameMother {
    
    private GameBuilder gameBuilder;
    
    public Game initial() {
        return new Game();
    }

	public Game blackRowWithTurn(Integer row, String draughtRow) {
        return this.rowAndTurn(row, draughtRow, Color.BLACK);
    }
    
    public Game blackRowWithChangeTurn(Integer row, String draughtRow) {
        return this.rowAndTurn(row, draughtRow, Color.WHITE);
    }
    
    public Game whiteRowWithTurn(Integer row, String draughtRow) {
        return this.rowAndTurn(row, draughtRow, Color.WHITE);
    }
    
    public Game whiteRowWithChangeTurn(Integer row, String draughtRow) {
        return this.rowAndTurn(row, draughtRow, Color.BLACK);
	}

	public Game whiteEating(Pair<Integer, String>... rows) {
        return this.eating(Color.WHITE, rows);
	}

	public Game blackEating(Pair<Integer, String>... rows) {
        return this.eating(Color.BLACK, rows);
    }
    
    public Game canceledGame() {
        this.gameBuilder = new GameBuilder();
        return this.gameBuilder
                .row(0, " n n n n")
                .row(1, "n n n n ")
                .row(2, " n n n n")
                .color(Color.BLACK)
                .build();
    }

    public Game blackRowWithWrongTurn(Integer row, String draughtRow) {
        return this.rowAndTurn(row, draughtRow, Color.WHITE);
    }
    
    public Game whiteRowWithWrongTurn(Integer row, String draughtRow) {
        return this.rowAndTurn(row, draughtRow, Color.BLACK);
    }

	public Game rowsWithBlackTurn(Pair<Integer, String>... rows) {
		return this.rowsAndTurn(Color.BLACK, rows);
    }

    public Game rowsWithWhiteTurn(Pair<Integer, String>... rows) {
		return this.rowsAndTurn(Color.WHITE, rows);
	}
    
    private Game eating( Color color, Pair<Integer, String>... rows){
        this.gameBuilder = new GameBuilder();
        for (Pair<Integer,String> row : rows)        
            this.gameBuilder.row(row.getLeft(), row.getRight());
                
        return this.gameBuilder
            .color(color)
            .build();
    }

    private Game rowAndTurn(Integer row, String draughtRow, Color color){
        this.gameBuilder = new GameBuilder();
        return this.gameBuilder
                .color(color)
                .row(row, draughtRow)
                .build();
    }

    private Game rowsAndTurn(Color color, Pair<Integer, String>... rows){
        this.gameBuilder = new GameBuilder();
        for (Pair<Integer,String> row : rows)        
            this.gameBuilder.row(row.getLeft(), row.getRight());
        return this.gameBuilder
                .color(color)
                .build();
    }

	

    
}

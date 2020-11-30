package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;

public class Logic {
    private Game game;
    private StartController startController;

    public Logic() {
        this.game = new Game();
        this.startController = new StartController(this.game);
    }

    public void setUsers(int users) {
        this.startController.setUsers(users);
    }

    public int getMaxPlayers() {
        return this.startController.getMaxPlayers();
    }

    public boolean isBoardComplete() {
        return false;
    }

    public boolean isTicTacToe() {
        return false;
    }

    public Token getToken() {
        return null;
    }

    public boolean isUser() {
        return false;
    }

    public Error put() {
        return null;
    }

    public Error move() {
        return null;
    }

    public void resume() {
        System.out.println("resume()");
    }
}

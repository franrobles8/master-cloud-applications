package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;

public class Logic {
    private Game game;
    private StartController startController;
    private PlayController playController;

    public Logic() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
    }

    public void setUsers(int users) {
        this.startController.setUsers(users);
    }

    public int getMaxPlayers() {
        return this.startController.getMaxPlayers();
    }

    public boolean isBoardComplete() {
        return this.playController.isBoardComplete();
    }

    public boolean isTicTacToe() {
        return this.playController.isTicTacToe();
    }

    public Token getToken() {
        return this.playController.getToken();
    }

    public boolean isUser() {
        return this.playController.isUser();
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

package usantatecla.mastermind.models;

public class GameMemento {
    private Game game;

    GameMemento(Game game) {
        this.game = game;
    }

    Game getGame() {
        return this.game;
    }
}

package usantatecla.draughts.controllers;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.allOf;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.Piece;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

public class CancelControllerTest {
    @Test
    public void givenGameAndStateWhenCancelThenChangesTurnColorAndRemovesColors() {
        Game game = new GameBuilder().build();
        State state = new State();
        CancelController cancelController = new CancelController(game, state);
        Color initialTurnColor = game.getTurnColor();
        List<Piece> matchingPieces = new ArrayList<>();

        cancelController.cancel();

        for (int i = 0; i < Coordinate.getDimension(); i++) {
            for (int j = 0; j < Coordinate.getDimension(); j++) {
                Piece piece = game.getPiece(new Coordinate(i, j));
                if (piece != null && piece.getColor() == initialTurnColor)
                    matchingPieces.add(piece);
            }
        }

        assertThat(game.getTurnColor(), allOf(not(is(initialTurnColor)), is(Color.BLACK)));
        assertThat(matchingPieces.size(), is(0));
        assertThat(state.getValueState(), is(StateValue.IN_GAME));
    }
}

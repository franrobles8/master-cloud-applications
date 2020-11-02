package usantatecla.mastermind.views;

import java.util.List;

import usantatecla.mastermind.controllers.ActionController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;

public class ProposalCommand extends Command {
    ProposalCommand(ActionController actionController) {
        super(MessageView.PROPOSAL_COMMAND.getMessage(), actionController);
    }

    @Override
    protected void execute() {
        if (!this.actionController.isFinished()) {
            this.propose();
        } else {
            if (this.actionController.isWinner()) {
                MessageView.WINNER.writeln();
            } else {
                MessageView.LOOSER.writeln();
            }
        }
    }

    private void propose() {
        Error error;
        Console console = new Console();
        do {
            List<Color> colors = new ProposedCombinationView(actionController).read();
            actionController.addProposedCombination(colors);
            error = actionController.getProposedCombinationError(colors);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        console.writeln();
        new AttemptsView(actionController).writeln();
        new SecretCombinationView(actionController).writeln();
        for (int i = 0; i < actionController.getAttempts(); i++) {
            new ProposedCombinationView(actionController).write(i);
            new ResultView(actionController).writeln(i);
        }
        if (actionController.isWinner()) {
            console.writeln(MessageView.WINNER.getMessage());
        } else if (actionController.isLooser()) {
            console.writeln(MessageView.LOOSER.getMessage());
        }
    }

    @Override
    protected boolean isActive() {
        return true;
    }
}

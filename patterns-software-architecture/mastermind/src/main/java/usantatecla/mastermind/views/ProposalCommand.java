package usantatecla.mastermind.views;

import java.util.List;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;

public class ProposalCommand extends Command {
    ProposalCommand(ProposalController proposalController) {
        super(MessageView.PROPOSAL_COMMAND.getMessage(), proposalController);
    }

    @Override
    protected void execute() {
        if (!this.proposalController.isFinished()) {
            this.propose();
        } else {
            if (this.proposalController.isWinner()) {
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
            List<Color> colors = new ProposedCombinationView(proposalController).read();
            proposalController.addProposedCombination(colors);
            error = proposalController.getProposedCombinationError(colors);
            if (error != Error.NULL) {
                new ErrorView(error).writeln();
            }
        } while (error != Error.NULL);
        console.writeln();
        new AttemptsView(proposalController).writeln();
        new SecretCombinationView(proposalController).writeln();
        for (int i = 0; i < proposalController.getAttempts(); i++) {
            new ProposedCombinationView(proposalController).write(i);
            new ResultView(proposalController).writeln(i);
        }
        if (proposalController.isWinner()) {
            console.writeln(MessageView.WINNER.getMessage());
        } else if (proposalController.isLooser()) {
            console.writeln(MessageView.LOOSER.getMessage());
        }
    }

    @Override
    protected boolean isActive() {
        return true;
    }
}

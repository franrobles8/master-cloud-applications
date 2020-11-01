package usantatecla.mastermind.controllers;

import java.util.List;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;


public abstract class PlayController extends AcceptorController {
	
	public PlayController(Session session) {
		super(session);
	}

	public abstract void addProposedCombination(List<Color> colors);
	
	public abstract boolean isWinner();
	
	public abstract boolean isLooser();
	
	public abstract boolean isFinished();
	
	public abstract int getAttempts();

	public abstract List<Color> getColors(int position);
	
	public abstract int getBlacks(int position);

	public abstract int getWhites(int position);

	public abstract void continueState();

	public abstract void undo();

	public abstract boolean undoable();

	public abstract void redo();

	public abstract boolean redoable();
	
	public abstract Error getProposedCombinationError(List<Color> colors);
	
	@Override
	public void accept(ControllersVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}

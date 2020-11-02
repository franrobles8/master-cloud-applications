package usantatecla.mastermind.controllers;

import java.util.List;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionImplementation;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

public class ActionController extends Controller {

	private SessionImplementation sessionImplementation;

	public ActionController(Session session) {
		super(session);
		this.sessionImplementation = ((SessionImplementation) this.session);
	}

	public void addProposedCombination(List<Color> colors) {
		this.sessionImplementation.addProposedCombination(colors);
	}

	public boolean isWinner() {
		return this.sessionImplementation.isWinner();
	}

	public boolean isLooser() {
		return this.sessionImplementation.isLooser();
	}

	public boolean isFinished() {
		return this.sessionImplementation.isFinished();
	}
	
	public int getAttempts() {
		return this.sessionImplementation.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.sessionImplementation.getColors(position);
	}

	public int getBlacks(int position) {
		return this.sessionImplementation.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.sessionImplementation.getWhites(position);
	}

	public void redo() {
		this.sessionImplementation.redo();
	}

	public void undo() {
		this.sessionImplementation.undo();
	}

	public boolean redoable() {
		return this.sessionImplementation.redoable();
	}

	public boolean undoable() {
		return this.sessionImplementation.undoable();
	}	

	public Error getProposedCombinationError(List<Color> colors){
		return this.sessionImplementation.getProposedCombinationError(colors);
	}

	public int getWidth() {
		return this.sessionImplementation.getWidth();
	}

	public void continueState() {
		this.sessionImplementation.next();
	}
}

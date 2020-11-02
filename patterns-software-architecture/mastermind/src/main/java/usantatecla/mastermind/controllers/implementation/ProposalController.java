package usantatecla.mastermind.controllers.implementation;

import java.util.List;

import usantatecla.mastermind.controllers.ActionController;
import usantatecla.mastermind.controllers.RedoController;
import usantatecla.mastermind.controllers.UndoController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;



public class ProposalController extends usantatecla.mastermind.controllers.ProposalController {

	private ActionController actionController;
	private UndoController undoController;
	private RedoController redoController;
	
	public ProposalController(Session session) {
		super(session);
		this.actionController = new ActionController(this.session);
		this.undoController = new UndoController(this.session);
		this.redoController = new RedoController(this.session);
	}
	
	@Override
	public void addProposedCombination(List<Color> colors) {
		this.actionController.addProposedCombination(colors);
	}
	
	@Override
	public boolean isWinner() {
		return this.actionController.isWinner();
	}

	@Override
	public boolean isLooser() {
		return this.actionController.isLooser();
	}
	
	@Override
	public boolean isFinished() {
		return this.actionController.isFinished();
	}
	
	@Override
	public int getAttempts() {
		return this.actionController.getAttempts();
	}
	
	@Override
	public List<Color> getColors(int position) {
		return this.actionController.getColors(position);
	}
	
	@Override
	public int getBlacks(int position) {
		return this.actionController.getBlacks(position);
	}

	@Override
	public int getWhites(int position) {
		return this.actionController.getWhites(position);
	}

	@Override
	public void undo() {
		this.undoController.undo();
	}

	@Override
	public boolean undoable() {
		return this.undoController.undoable();
	}

	@Override
	public void redo() {
		this.redoController.redo();
	}

	@Override
	public boolean redoable() {
		return this.redoController.redoable();
	}

	@Override
	public void continueState() {
		this.actionController.continueState();

	}

	@Override
	public Error getProposedCombinationError(List<Color> colors) {
		return this.actionController.getProposedCombinationError(colors);
	}

	@Override
	public int getWidth() {
		return this.actionController.getWidth();
	}
}

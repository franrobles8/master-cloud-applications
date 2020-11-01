package usantatecla.mastermind.controllers.implementation;

import java.util.List;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.controllers.RedoController;
import usantatecla.mastermind.controllers.UndoController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;



public class PlayController extends usantatecla.mastermind.controllers.PlayController {

	private ProposalController proposalController;
	private UndoController undoController;
	private RedoController redoController;
	
	public PlayController(Session session) {
		super(session);
		this.proposalController = new ProposalController(this.session);
		this.undoController = new UndoController(this.session);
		this.redoController = new RedoController(this.session);
	}
	
	@Override
	public void addProposedCombination(List<Color> colors) {
		this.proposalController.addProposedCombination(colors);
	}
	
	@Override
	public boolean isWinner() {
		return this.proposalController.isWinner();
	}

	@Override
	public boolean isLooser() {
		return this.proposalController.isLooser();
	}
	
	@Override
	public boolean isFinished() {
		return this.proposalController.isFinished();
	}
	
	@Override
	public int getAttempts() {
		return this.proposalController.getAttempts();
	}
	
	@Override
	public List<Color> getColors(int position) {
		return this.proposalController.getColors(position);
	}
	
	@Override
	public int getBlacks(int position) {
		return this.proposalController.getBlacks(position);
	}

	@Override
	public int getWhites(int position) {
		return this.proposalController.getWhites(position);	
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
		this.proposalController.continueState();

	}

	@Override
	public Error getProposedCombinationError(List<Color> colors) {
		return this.proposalController.getProposedCombinationError(colors);
	}

	@Override
	public int getWidth() {
		return this.proposalController.getWidth();
	}
}

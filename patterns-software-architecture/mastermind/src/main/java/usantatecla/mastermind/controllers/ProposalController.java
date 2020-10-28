package usantatecla.mastermind.controllers;

import java.util.List;

import usantatecla.mastermind.models.Combination;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

public class ProposalController extends Controller {

	public ProposalController(Session session) {
		super(session);
	}

	public Error addProposedCombination(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getWidth()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i+1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}				
			}
		}
		if (error == null){
			this.session.addProposedCombination(colors);
			if (this.session.isFinished()) {
				this.session.next();
			}
		}
		return error;	
	}

	public boolean isWinner() {
		return this.session.isWinner();
	}

	public boolean isLooser() {
		return this.session.isLooser();
	}

	public boolean isFinished() {
		return this.session.isFinished();
	}
	
	public int getAttempts() {
		return this.session.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.session.getColors(position);
	}

	public int getBlacks(int position) {
		return this.session.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.session.getWhites(position);
	}

	public void redo() {
		this.session.redo();
	}

	public void undo() {
		this.session.undo();
	}

	public boolean redoable() {
		return this.session.redoable();
	}

	public boolean undoable() {
		return this.session.undoable();
	}
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}

package usantatecla.mastermind.distributed;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

public class ProposalControllerProxy extends ProposalController {
    private TCPIP tcpip;

    ProposalControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void undo() {
        this.tcpip.send(FrameType.UNDO.name());
    }

    @Override
    public void redo() {
        this.tcpip.send(FrameType.REDO.name());
    }

    @Override
    public boolean undoable() {
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean redoable() {
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public void addProposedCombination(List<Color> colors) {

        this.tcpip.send(FrameType.PROPOSAL.name());
        for (Color color: colors) {
            this.tcpip.send(color);
        }
    }

    @Override
    public boolean isWinner() {
        this.tcpip.send(FrameType.WINNER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean isLooser() {
        this.tcpip.send(FrameType.LOOSER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean isFinished() {
		this.tcpip.send(FrameType.FINISHED.name());
        return this.tcpip.receiveBoolean();
	}
    
    @Override
	public int getAttempts() {
		this.tcpip.send(FrameType.ATTEMPTS.name());
        return this.tcpip.receiveInt();
	}

    @Override
    public List<Color> getColors(int position) {
        int combinationWidth = this.getWidth();
        this.tcpip.send(FrameType.COLORS.name());
        List<Color> colors = new ArrayList<Color>();
        for (int i=0; i< combinationWidth; i++) {
            colors.add(this.tcpip.receiveColor());
        }
        return colors;
    }

    @Override
	public int getBlacks(int position) {
		this.tcpip.send(FrameType.BLACKS.name());
        return this.tcpip.receiveInt();
	}

    @Override
    public int getWhites(int position) {
		this.tcpip.send(FrameType.WHITES.name());
        return this.tcpip.receiveInt();
    }
    
    @Override
    public Error getProposedCombinationError(List<Color> colors){
		this.tcpip.send(FrameType.PROPOSED_COMBINATION_ERROR.name());
        return this.tcpip.receiveError();
	}

    @Override
	public int getWidth() {
		this.tcpip.send(FrameType.WIDTH.name());
        return this.tcpip.receiveInt();
	}

    @Override
	public void continueState() {
        this.tcpip.send(FrameType.CONTINUE.name());
    }
}

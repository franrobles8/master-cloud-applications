package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.implementation.Logic;
import usantatecla.mastermind.distributed.dispatchers.AttemptsDispatcher;
import usantatecla.mastermind.distributed.dispatchers.BlacksDispatcher;
import usantatecla.mastermind.distributed.dispatchers.CloseDispatcher;
import usantatecla.mastermind.distributed.dispatchers.ContinueStateDispatcher;
import usantatecla.mastermind.distributed.dispatchers.DispatcherPrototype;
import usantatecla.mastermind.distributed.dispatchers.FinishedDispatcher;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.LoserDispatcher;
import usantatecla.mastermind.distributed.dispatchers.MastermindDispatcher;
import usantatecla.mastermind.distributed.dispatchers.ProposalDispatcher;
import usantatecla.mastermind.distributed.dispatchers.ProposedCombinationErrorDispatcher;
import usantatecla.mastermind.distributed.dispatchers.RedoDispatcher;
import usantatecla.mastermind.distributed.dispatchers.RedoableDispatcher;
import usantatecla.mastermind.distributed.dispatchers.ResumeDispatcher;
import usantatecla.mastermind.distributed.dispatchers.StartDispatcher;
import usantatecla.mastermind.distributed.dispatchers.StateDispatcher;
import usantatecla.mastermind.distributed.dispatchers.UndoDispatcher;
import usantatecla.mastermind.distributed.dispatchers.UndoableDispatcher;
import usantatecla.mastermind.distributed.dispatchers.WhitesDispatcher;
import usantatecla.mastermind.distributed.dispatchers.WidthDispatcher;
import usantatecla.mastermind.distributed.dispatchers.WinnerDispatcher;

public class LogicImplementationServer extends Logic {
    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startController));
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.CLOSE, new CloseDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.MASTERMIND, new MastermindDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.PROPOSAL, new ProposalDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.WINNER, new WinnerDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.LOOSER, new LoserDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.FINISHED, new FinishedDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.ATTEMPTS, new AttemptsDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.BLACKS, new BlacksDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.WHITES, new WhitesDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.PROPOSED_COMBINATION_ERROR, new ProposedCombinationErrorDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.WIDTH, new WidthDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.CONTINUE, new ContinueStateDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.RESUME, new ResumeDispatcher(this.resumeController));
    }
}

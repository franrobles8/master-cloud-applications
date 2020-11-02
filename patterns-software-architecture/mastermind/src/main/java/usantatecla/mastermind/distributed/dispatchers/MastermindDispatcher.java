package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;

public class MastermindDispatcher extends Dispatcher {
    public MastermindDispatcher(PlayController playController) {
		super(playController);
	}

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayController) this.acceptorController).isFinished());
    }
}

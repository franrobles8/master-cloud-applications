package usantatecla.mastermind.distributed.dispatchers;

public abstract class Dispatcher {
    protected AcceptorController acceptorController;

    protected TCPIP tcpip;

    protected Dispatcher(AcceptorController acceptorController) {
        this.acceptorController = acceptorController;
    }

    public abstract void dispatch();

    public void associate(TCPIP tcpip) {
        this.tcpip = tcpip;
    }
}

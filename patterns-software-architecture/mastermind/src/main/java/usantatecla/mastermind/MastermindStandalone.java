package usantatecla.mastermind;

import usantatecla.mastermind.controllers.implementation.Logic;

public class MastermindStandalone extends Mastermind {

    public static void main(String[] args) {
        new MastermindStandalone().play();
    }

    @Override
    protected usantatecla.mastermind.controllers.Logic createLogic() {
        return new Logic();
    }

}
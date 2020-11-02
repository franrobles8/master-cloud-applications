package usantatecla.mastermind.distributed.dispatchers;

public enum FrameType {
    START, STATE, UNDO, REDO, UNDOABLE, REDOABLE, CLOSE, MASTERMIND, PROPOSAL, WINNER, LOOSER, FINISHED, ATTEMPTS,
    BLACKS, WHITES, RESUME, PROPOSED_COMBINATION_ERROR, WIDTH, CONTINUE, COLORS;

    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}

package usantatecla.mastermind.distributed.dispatchers;

public enum FrameType {
    START, STATE, UNDO, REDO, UNDOABLE, REDOABLE, CLOSE, MASTERMIND, PROPOSAL;

    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}

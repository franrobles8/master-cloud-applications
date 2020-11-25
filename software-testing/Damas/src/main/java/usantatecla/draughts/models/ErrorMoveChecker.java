package usantatecla.draughts.models;

public abstract class ErrorMoveChecker {
    private ErrorMoveChecker next;

    public ErrorMoveChecker link(ErrorMoveChecker next) {
        this.next = next;
        return this;
    }

    public abstract Error check(int pair, Coordinate... coordinates);

    protected Error checkNext(int pair, Coordinate... coordinates) {
        if(this.next == null) {
            return null;
        }
        return this.next.check(pair, coordinates);
    }
}

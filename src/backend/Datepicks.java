package backend;


public class Datepicks {

    private long diffMinutesStart;
    private long diffMinutesEnd;

    public long getDiffMinutesStart() {
        return diffMinutesStart;
    }

    public void setDiffMinutesStart(long diffMinutesStart) {
        this.diffMinutesStart = diffMinutesStart;
    }

    public long getDiffMinutesEnd() {
        return diffMinutesEnd;
    }

    public void setDiffMinutesEnd(long diffMinutesEnd) {
        this.diffMinutesEnd = diffMinutesEnd;
    }

    public Datepicks(long diffMinutesStart, long diffMinutesEnd) {
        this.diffMinutesStart = diffMinutesStart;
        this.diffMinutesEnd = diffMinutesEnd;
    }
    public Datepicks() {

    }

}

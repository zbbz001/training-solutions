package activity;

public enum ActivityType {
    BIKING(true), HIKING(true), RUNNING(true), BASKETBALL(false);

    private final boolean isTrackActivity;

    ActivityType(boolean isTrackActivity) {
        this.isTrackActivity = isTrackActivity;
    }

    public boolean isTrackActivity() {
        return isTrackActivity;
    }
}
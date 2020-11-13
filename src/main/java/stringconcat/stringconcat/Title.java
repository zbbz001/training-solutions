package stringconcat.stringconcat;

public enum Title {
    MR("Mr."), MRS("Mrs."), MISS("Miss"), DR("Dr."), PROF("Prof.");

    private String titleString;

    Title(String titleString) {
        this.titleString = titleString;
    }

    public String getTitleString() {
        return titleString;
    }
}

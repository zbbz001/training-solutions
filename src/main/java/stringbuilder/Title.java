package stringbuilder;

public enum Title {
    MR("Mr."), MRS("Mrs."), MISS("Miss"), DR("Dr."), PROF("Prof.");

    public String writtenFormat;

    Title(String writtenFormat) {
        this.writtenFormat = writtenFormat;
    }
}

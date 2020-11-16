package schoolrecords;

public class Mark {
    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        if (isEmpty(subject) || isEmpty(tutor)) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }

        this.markType = markType;
        this.subject = subject;
        this.tutor = tutor;
    }

    public Mark(String markType, Subject subject, Tutor tutor) {
        this(MarkType.valueOf(markType), subject, tutor);
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(markType.getDescription());
        sb.append("(");
        sb.append(markType.getValue());
        sb.append(")");

        return sb.toString();
    }

    private boolean isEmpty(Object str) {
        return str == null;
    }
}

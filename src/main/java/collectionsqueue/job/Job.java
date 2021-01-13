package collectionsqueue.job;

public class Job implements Comparable<Job> {

    private int priority;
    private String jobDescription;
    boolean urgent = false;

    public Job(int priority, String jobDescription) {
        this.priority = priority;
        this.jobDescription = jobDescription;
        if (priority < 5) {
            urgent = true;
        }
    }

    public int getPriority() {
        return priority;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    @Override
    public int compareTo(Job o) {
        return priority - o.getPriority();
    }
}

package collectionsqueue.collectionsdeque;

import collectionsqueue.job.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class JobQueue {

    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> jobQueue = new ArrayDeque<>();
        for (Job job : jobs) {
            if (job.getPriority() < 5) {
                jobQueue.addFirst(job);
            } else {
                jobQueue.addLast(job);
            }
        }

        return jobQueue;
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }

        return jobs.getFirst();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }

        return jobs.getLast();
    }
}

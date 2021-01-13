package collectionsqueue.collectionspriorityqueue;

import collectionsqueue.job.*;

import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    public Queue<Job> addJob(Job... jobs) {
        Queue<Job> jobQueue = new PriorityQueue<>();
        for (Job job : jobs) {
            jobQueue.add(job);
        }

        return jobQueue;
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.poll();
    }
}

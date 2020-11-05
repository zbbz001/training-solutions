package introconstructors;

import java.time.LocalDateTime;

public class Task {
    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private int duration;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void start() {
        startDateTime = LocalDateTime.now();
    }

    public static void main(String[] args) {
        Task task = new Task("Mai első feladat", "Aktiválni kell a rutinos stratégiai célokat, illetve ösztönözni a súrlódásmentes piaci megjelenést.");
        task.start();
        task.setDuration(30);

        System.out.println(task.getStartDateTime());
        System.out.println(task.getTitle());
        System.out.println(task.getDescription());
        System.out.println(task.getDuration());
    }
}

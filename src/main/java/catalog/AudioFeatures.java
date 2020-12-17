package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {
    private List<String> composer;
    private int length;
    private List<String> performers;
    private String title;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("The title cannot be empty.");
        }
        if (!Validators.isPositive(length)) {
            throw new IllegalArgumentException("The length must be positive number.");
        }
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("The performers cannot be empty.");
        }

        this.length = length;
        this.performers = performers;
        this.title = title;
        composer = new ArrayList<String>();
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("The title cannot be empty.");
        }
        if (!Validators.isPositive(length)) {
            throw new IllegalArgumentException("The length must be positive number.");
        }
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("The performers cannot be empty.");
        }
        if (Validators.isEmpty(composer)) {
            throw new IllegalArgumentException("The composer cannot be empty.");
        }

        this.composer = composer;
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>(composer);
        contributors.addAll(performers);
        return new ArrayList<>(contributors);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}

package week15d03;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PostFinder {
    private List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPosts(String user) {
        return posts.stream()
                .filter(post -> post.getDeletedAt() == null || post.getDeletedAt().isAfter(LocalDate.now()))
                .filter(post -> post.getPublishedAt().isBefore(LocalDate.now()) || post.getOwner().equals(user))
                .filter(post -> post.getContent() != null && !post.getContent().isBlank())
                .filter(post -> post.getTitle() != null && !post.getTitle().isBlank())
                .collect(Collectors.toList());
    }
}

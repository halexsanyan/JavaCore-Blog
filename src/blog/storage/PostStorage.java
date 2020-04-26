package blog.storage;

import blog.model.Post;
import blog.model.PostCategory;

import java.util.ArrayList;
import java.util.List;

public class PostStorage {
    private List<Post> posts;


    public PostStorage(int length) {
        posts = new ArrayList<>(length);
    }

    public PostStorage() {
        posts = new ArrayList<>();
    }

    public void addPsot(Post volue) {
        posts.add(volue);
    }

    public void printAllPosts() {
        System.out.println("------------------------");
        for (Post post : posts) {
            System.out.println(post);
        }
        System.out.println("------------------------");
    }

    public void searchPostsByKeyword(String keyword) {
        for (Post post : posts) {
            if (post.getTitle().contains(keyword) && post.getText().contains(keyword)) {
                System.out.println(post);
            }
        }
    }

    public void printPostsByCategory(PostCategory category) {
        for (Post post : posts) {
            if (post.getCategory().equals(category)) {
                System.out.println(post);
            }
        }
    }

    public boolean isEmpty() {
        return posts.isEmpty();
    }
}

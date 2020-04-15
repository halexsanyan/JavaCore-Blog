package blog.storage;


import blog.exception.PostNotFoundException;
import blog.model.Post;

public interface PostStorage {

    void add(Post post);
    Post getPostByTitle(String title) throws PostNotFoundException;
    Post searchPostsByKeyword(String keyword);
    void printAllPosts();
    Post printPostsByCategory(String category);
    boolean isEmpty();
}

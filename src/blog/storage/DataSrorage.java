package blog.storage;

import blog.exception.ModelNodFoundException;
import blog.model.PostCategory;
import blog.model.User;

public interface DataSrorage<T> {
    void add(T volue);
    User getUserByEmailAndPassword(String email, String password) throws ModelNodFoundException;
    User getUserByEmail(String email) throws ModelNodFoundException;
    void searchPostsByKeyword(String keyword);
    void printAllPosts();
    void printPostsByCategory(PostCategory category);
    boolean isEmpty();
}

package blog.storage;

import blog.exception.ModelNodFoundException;
import blog.model.Post;
import blog.model.PostCategory;
import blog.model.User;

public class DataStorageImpl<T> implements DataSrorage<T> {
    private Object[] array;
    private int size;

    public DataStorageImpl() {
        array = new Object[15];
    }

    public void add(T volue) {
        if (size == array.length) {
            exstend();
        }
        array[size++] = volue;
    }

    private void exstend() {
        Object[] tmp = new Object[array.length + 10];
        System.arraycopy(array, 0, tmp, 0, array.length);
        array = tmp;
    }

    public User getUserByEmailAndPassword(String email, String password) throws ModelNodFoundException {
        for (int i = 0; i < size; i++) {
            User user = (User) array[i];
            if (user.getEmail().equals(email) && user.getPassvord().equals(password)) {
                return user;
            }
        }
        throw new ModelNodFoundException(String.format("User whit %s email and %s password does not exist", email, password));
    }

    public User getUserByEmail(String email) throws ModelNodFoundException {
        for (int i = 0; i < size; i++) {
            User user = (User) array[i];
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new ModelNodFoundException(String.format("User whit %s email does not exist", email));
    }

    public void searchPostsByKeyword(String keyword) {
        for (int i = 0; i < size; i++) {
            Post post = (Post) array[i];
            if (keyword.contains(post.getTitle()) && keyword.contains(post.getText())) {
                System.out.println(post);
            }
        }
    }

    public void printAllPosts() {
        System.out.println("------------------------");
        for (int i = 0; i < size; i++) {
            Post post = (Post) array[i];
            System.out.println(post);
        }
        System.out.println("------------------------");
    }

    public void printPostsByCategory(PostCategory category) {
        for (int i = 0; i < size; i++) {
            Post post = (Post) array[i];
            if (post.getCategory().equals(category)) {
                System.out.println(post);
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

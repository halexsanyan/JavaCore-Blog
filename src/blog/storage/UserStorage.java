package blog.storage;

import blog.exception.ModelNodFoundException;
import blog.model.User;

public interface UserStorage {
    void add(User user);
    User getUserByEmailAndPassword(String email, String password) throws ModelNodFoundException;
    User getUserByEmail(String email) throws ModelNodFoundException;
}

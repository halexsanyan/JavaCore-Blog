package blog.storage;

import blog.exception.ModelNodFoundException;
import blog.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    private Map<String, User> users;

    public UserStorage() {
        users = new HashMap<>();
    }

    public UserStorage(int capacity) {
        users = new HashMap<>(capacity);
    }

    public void addUser(String key, User user) {
        users.put(key, user);
    }

    public User getUserByEmailAndPassword(String email, String password) throws ModelNodFoundException {
        User user = users.get(email);
        if (user.getPassvord().equals(password)) {
            return user;
        }
        throw new ModelNodFoundException(String.format("User whit %s email and %s password does not exist", email, password));
    }

    public User getUserByEmail(String email) {
          return  users.get(email);

    }
}


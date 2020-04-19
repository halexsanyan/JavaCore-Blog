package blog.storage;

import blog.exception.ModelNodFoundException;
import blog.model.Post;
import blog.model.User;

public class UserStorageImpl implements UserStorage {
    User[] users = new User[15];
    int size = 0;

    @Override
    public void add(User user) {
        if (size == users.length) {
            exstand();
        } else {
            users[size++] = user;
        }

    }

    private void exstand() {
        User[] tmp = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) throws ModelNodFoundException {
        for (int i = 0; i < size; i++) {
            User user = users[i];
            if (user.getEmail().equals(email) && user.getPassvord().equals(password)) {
                return user;
            }
        }
        throw new ModelNodFoundException(String.format("User whit %s email and %s password does not exist", email, password));
    }

    public User getUserByEmail(String email) throws ModelNodFoundException {
        for (int i = 0; i < size; i++) {
            User user = users[i];
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new ModelNodFoundException(String.format("User whit %s email does not exist", email));
    }
}

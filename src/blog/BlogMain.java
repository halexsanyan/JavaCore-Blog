package blog;


import blog.exception.ModelNodFoundException;
import blog.model.Post;
import blog.model.PostCategory;
import blog.model.User;
import blog.storage.PostStorage;
import blog.storage.UserStorage;

import java.util.Date;
import java.util.Scanner;

public class BlogMain implements Commands {
    public static final UserStorage USER_STORAGE = new UserStorage();
    public static final PostStorage POST_STORAGE = new PostStorage();
    public static final Scanner SCANNER = new Scanner(System.in);
    public static User currentUser = null;

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            POST_STORAGE.printAllPosts();
            Commands.printMainCommands();
            String comandsStr = SCANNER.nextLine();
            int command;
            try {
                command = Integer.parseInt(comandsStr);
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                case SEARCH_POST:
                    searchPost();
                    break;
                case POST_BY_CATEGORY:
                    postByCategory();
                    break;
                case ALL_POSTS:
                    allPost();
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    private static void login() {
        System.out.println("Please input: email, passwotd ");
        String userStr = SCANNER.nextLine();
        String[] userData = userStr.split(",");
        try {
            currentUser = USER_STORAGE.getUserByEmailAndPassword(userData[0], userData[1]);
            loginUser();
        } catch (ModelNodFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("please try again");
            login();
        }
    }

    private static void loginUser() {
        boolean isRun = true;
        while (isRun) {
            Commands.printUserCommands();
            String comandsStr = SCANNER.nextLine();
            int command;
            try {
                command = Integer.parseInt(comandsStr);
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    isRun = false;
                    break;
                case ADD_POST:
                    addPost();
                    break;
                case All_POSTS:
                    allPost();
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
    }

    private static void register() {
        System.out.println("Please input your data: name, surname, email, password");
        try {
            String userStr = SCANNER.nextLine();
            String[] userData = userStr.split(",");
            User user = new User();
            user.setName(userData[0]);
            user.setSurname(userData[1]);
            user.setEmail(userData[2]);
            user.setPassvord(userData[3]);

            User userByEmail = USER_STORAGE.getUserByEmail(userData[2]);
            if (userByEmail != null) {
                System.out.println("This email is already registered");
            } else {
                USER_STORAGE.addUser(userData[2], user);
                System.out.println("Thank you!");
            }

        } catch (Exception e) {
            System.out.println("Wrong imput");
            register();
        }
    }

    private static void addPost() {
        System.out.println("Please input Post data: title, text, categoty(IT,ART,SOCIAL)");
        try {
            String postDataStr = SCANNER.nextLine();
            String[] postData = postDataStr.split(",");
            Post post = new Post();
            post.setTitle(postData[0]);
            post.setText(postData[1]);
            post.setCategory(PostCategory.valueOf(postData[2]));
            post.setUser(currentUser);
            post.setCreatedDate(new Date());
            if (postData.length > 3) {
                System.out.println("Incorrect value! Please try again");
                addPost();
            } else {
                POST_STORAGE.addPsot(post);
                System.out.println("Post was added!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect value! Please try again");
            addPost();
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong category try again");
            addPost();
        }
    }

    private static void searchPost() {
        if (POST_STORAGE.isEmpty()) {
            System.out.println("Nothing added!");
            return;
        } else {
            System.out.println("Please input data of post");
        }
        String keyword = SCANNER.nextLine();
        POST_STORAGE.searchPostsByKeyword(keyword);
    }

    private static void postByCategory() {
        if (POST_STORAGE.isEmpty()) {
            System.out.println("Nothing added!");
            return;
        } else {
            System.out.println("Please input categptry (IT,ART,SOCIAL)");
        }
        String category = SCANNER.nextLine();
        PostCategory postCategory = PostCategory.valueOf(category);
        POST_STORAGE.printPostsByCategory(postCategory);
    }

    private static void allPost() {
        if (POST_STORAGE.isEmpty()) {
            System.out.println("Nothing added!");
            return;
        }
        POST_STORAGE.printAllPosts();
    }

}




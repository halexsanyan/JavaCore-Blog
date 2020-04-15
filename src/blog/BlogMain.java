package blog;


import blog.exception.PostNotFoundException;
import blog.model.Post;
import blog.storage.PostStorageImpl;

import java.util.Date;
import java.util.Scanner;

public class BlogMain implements Commands {
    public static PostStorageImpl postStorage = new PostStorageImpl();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            printCommands();
            String comandsStr = scanner.nextLine();
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
                case ADD_POST:
                    addPost();
                    break;
                case SEARCH_POST:
                    searchPost();
                    break;
                case POST_BY_TITLE:
                    postByTitle();
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

    private static void addPost() {
        System.out.println("Please input Post data: title, text, categoty");
        try {
            String postDataStr = scanner.nextLine();
            String[] postData = postDataStr.split(",");
            Post post = new Post();
            post.setTitle(postData[0]);
            post.setText(postData[1]);
            post.setCategory(postData[2]);
            Date date = new Date();
            post.setCreatedDate(date);
            if (postData.length > 3) {
                System.out.println("Incorrect value! Please try again");
                addPost();
            } else {
                postStorage.add(post);
                System.out.println("Post was added!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect value! Please try again");
            addPost();
        }
    }

    private static void searchPost() {
        if (postStorage.isEmpty()) {
            System.out.println("Nothing added!");
            return;
        } else {
            System.out.println("Please input data of post");
        }
        String keyword = scanner.nextLine();
        Post post = postStorage.searchPostsByKeyword(keyword);
        if (post != null) {
            System.out.println(post);
        } else {
            System.out.println("There is not that post!");
        }
    }

    private static void postByTitle() {
        if (postStorage.isEmpty()) {
            System.out.println("Nothing added!");
            return;
        }
        postStorage.printAllPosts();
        System.out.println("Please input post title");
        String title = scanner.nextLine();
        try {
            Post postByTitle = postStorage.getPostByTitle(title);
            System.out.println(postByTitle);

        } catch (PostNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void postByCategory() {
        if (postStorage.isEmpty()) {
            System.out.println("Nothing added!");
            return;
        } else {
            System.out.println("Please input category");
        }
        String category = scanner.nextLine();
        Post post = postStorage.printPostsByCategory(category);
        if (post != null) {
            System.out.println(post);
        } else {
            System.out.println("There is not that post!");
        }
    }

    private static void allPost() {
        if (postStorage.isEmpty()) {
            System.out.println("Nothing added!");
            return;
        }
        postStorage.printAllPosts();
    }


    public static void printCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + ADD_POST + " for ADD POST");
        System.out.println("Please input " + SEARCH_POST + " for SEARCH POST");
        System.out.println("Please input " + POST_BY_TITLE + " for POST BY TITLE");
        System.out.println("Please input " + POST_BY_CATEGORY + " for POST BY CATEGORY");
        System.out.println("Please input " + ALL_POSTS + " for ALL POSTS");
    }
}


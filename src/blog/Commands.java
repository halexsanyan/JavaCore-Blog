package blog;

public interface Commands {
    // main commannds
    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;
    int SEARCH_POST = 3;
    int POST_BY_CATEGORY = 4;
    int ALL_POSTS = 5;

    //users commands

    int LOGOUT = 0;
    int ADD_POST = 1;
    int All_POSTS = 2;


    static void printMainCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + LOGIN + " for LOGIN");
        System.out.println("Please input " + REGISTER + " for REGISTER");
        System.out.println("Please input " + SEARCH_POST + " for SEARCH POST");
        System.out.println("Please input " + POST_BY_CATEGORY + " for POST BY CATEGORY");
        System.out.println("Please input " + ALL_POSTS + " for ALL POSTS");
    }

    static void printUserCommands() {
        System.out.println("Please input " + LOGOUT + " for LOGOUT");
        System.out.println("Please input " + ADD_POST + " for ADD POST");
        System.out.println("Please input " + All_POSTS + " for ALL POSTS");
    }

}
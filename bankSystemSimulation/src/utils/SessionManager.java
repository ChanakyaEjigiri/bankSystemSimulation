package utils;


import java.util.ArrayList;
import java.util.List;


import entity.User;

public class SessionManager {

    private static User currentUser;
    private static List<Integer> accountIds = new ArrayList<>();

    // Set user after login
    public static void setUser(User user) {
        currentUser = user;
    }

    // Get logged-in user
    public static User getUser() {
        return currentUser;
    }

    // Set account IDs
    public static void setAccountIds(List<Integer> ids) {
        accountIds = ids;
    }

    public static List<Integer> getAccountIds() {
        return accountIds;
    }

    // Clear session (logout)
    public static void clearSession() {
        currentUser = null;
        accountIds.clear();
    }

    // Check login
    public static boolean isLoggedIn() {
        return currentUser != null;
    }
}
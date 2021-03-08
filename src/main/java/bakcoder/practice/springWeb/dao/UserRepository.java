package bakcoder.practice.springWeb.dao;

import bakcoder.practice.springWeb.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public List<User> getAllUsers() {
        return this.users;
    }

    public User getUserById(Integer userId) {
        return users.stream()
                .filter(x -> x.getUserId().equals(userId))
                .findAny()
                .orElse(new User(0, "Not Available"));
    }

    public void registUser(Integer userId, String username) {
        User user = new User(userId, username);
        this.users.add(user);
    }

    public void modifyUser(Integer userId, String username) {
        users.stream()
                .filter(x -> x.getUserId().equals(userId))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Item not found"))
                .setUsername(username);
    }

    public void removeUser(Integer userId) {
        users.removeIf((User u) -> u.getUserId().equals(userId));
    }

    // Dummy users
    public static List<User> users;
    public UserRepository() {
        users = new ArrayList<User>();
        users.add(new User(100, "Kim"));
        users.add(new User(101, "Na"));
        users.add(new User(102, "Bak"));
        users.add(new User(102, "Lee"));
    }
}

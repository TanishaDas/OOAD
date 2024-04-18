////package com.example.application;
////
////import com.vaadin.flow.component.button.Button;
////import com.vaadin.flow.component.grid.Grid;
////import com.vaadin.flow.component.orderedlayout.VerticalLayout;
////import com.vaadin.flow.component.textfield.PasswordField;
////import com.vaadin.flow.component.textfield.TextField;
////import com.vaadin.flow.router.Route;
////
////import java.util.ArrayList;
//import java.util.*;
//impor
////
////@Route("admin-dashboard")
////public class AdminDashboardView extends VerticalLayout {
////
////    private List<User> userList = new ArrayList<>();
////    private Grid<User> grid = new Grid<>(User.class);
////    private TextField usernameField = new TextField("Username");
////    private PasswordField passwordField = new PasswordField("Password");
////    private Button addButton = new Button("Add");
////    private Button deleteButton = new Button("Delete");
////    private Button updateButton = new Button("Update");
////
////    public AdminDashboardView() {
////        // Set up grid
////        grid.setColumns("username", "password");
////        grid.setItems(userList);
////
////        // Add event listeners
////        addButton.addClickListener(e -> addUser());
////        deleteButton.addClickListener(e -> deleteUser());
////        updateButton.addClickListener(e -> updateUser());
////
////        // Add components to layout
////        add(grid, usernameField, passwordField, addButton, deleteButton, updateButton);
////    }
////
////    private void addUser() {
////        String username = usernameField.getValue();
////        String password = passwordField.getValue();
////        if (!username.isEmpty() && !password.isEmpty()) {
////            User user = new User(username, password);
////            userList.add(user);
////            grid.setItems(userList);
////            clearFields();
////        }
////    }
////
////    private void deleteUser() {
////        String username = usernameField.getValue();
////        String password = passwordField.getValue();
////        User selectedUser = grid.asSingleSelect().getValue();
////        if (selectedUser != null) {
////            userList.remove(selectedUser);
////            grid.setItems(userList);
////        }
////    }
////
////    private void updateUser() {
////        User selectedUser = grid.asSingleSelect().getValue();
////        if (selectedUser != null) {
////            String username = usernameField.getValue();
////            String password = passwordField.getValue();
////            if (!username.isEmpty() && !password.isEmpty()) {
////                selectedUser.setUsername(username);
////                selectedUser.setPassword(password);
////                grid.getDataProvider().refreshItem(selectedUser);
////                clearFields();
////            }
////        }
////    }
////
////    private void clearFields() {
////        usernameField.clear();
////        passwordField.clear();
////    }
////
////    public static class User {
////        private String username;
////        private String password;
////
////        public User(String username, String password) {
////            this.username = username;
////            this.password = password;
////        }
////
////        public String getUsername() {
////            return username;
////        }
////
////        public void setUsername(String username) {
////            this.username = username;
////        }
////
////        public String getPassword() {
////            return password;
////        }
////
////        public void setPassword(String password) {
////            this.password = password;
////        }
////    }
////}
//
//package com.example.application;
//
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.textfield.PasswordField;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.router.Route;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Route("admin-dashboard")
//public class AdminDashboardView extends VerticalLayout {
//
//    // Database connection details
//    private static final String DB_URL = "jdbc:h2:mem:testdb";
//    private static final String DB_USER = "sa";
//    private static final String DB_PASSWORD = "";
//
//    private List<User> userList = new ArrayList<>();
//    private Grid<User> grid = new Grid<>(User.class);
//    private TextField usernameField = new TextField("Username");
//    private PasswordField passwordField = new PasswordField("Password");
//    private Button addButton = new Button("Add");
//    private Button deleteButton = new Button("Delete");
//    private Button updateButton = new Button("Update");
//
//    public AdminDashboardView() {
//        // Set up grid
//        grid.setColumns("username", "password");
//        grid.setItems(userList);
//
//        // Add event listeners
//        addButton.addClickListener(e -> addUser());
//        deleteButton.addClickListener(e -> deleteUser());
//        updateButton.addClickListener(e -> updateUser());
//
//        // Add components to layout
//        add(grid, usernameField, passwordField, addButton, deleteButton, updateButton);
//    }
//
//    // Database connection method
//    private Connection getConnection() throws SQLException {
//        System.out.println("here");
//        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//    }
//
//    private void addUser() {
//        String username = usernameField.getValue();
//        String password = passwordField.getValue();
//        if (!username.isEmpty() && !password.isEmpty()) {
//            User user = new User(username, password);
//            addUserToDatabase(user);
//            userList.add(user);
//            grid.setItems(userList);
//            clearFields();
//        }
//    }
//
//    private void deleteUser() {
//        User selectedUser = grid.asSingleSelect().getValue();
//        if (selectedUser != null) {
//            deleteUserFromDatabase(selectedUser);
//            userList.remove(selectedUser);
//            grid.setItems(userList);
//        }
//    }
//
//    private void updateUser() {
//        User selectedUser = grid.asSingleSelect().getValue();
//        if (selectedUser != null) {
//            String username = usernameField.getValue();
//            String password = passwordField.getValue();
//            if (!username.isEmpty() && !password.isEmpty()) {
//                selectedUser.setUsername(username);
//                selectedUser.setPassword(password);
//                updateUserInDatabase(selectedUser);
//                grid.getDataProvider().refreshItem(selectedUser);
//                clearFields();
//            }
//        }
//    }
//
//    private void clearFields() {
//        usernameField.clear();
//        passwordField.clear();
//    }
//
//    // Database operations
//
//    private void addUserToDatabase(User user) {
//        try (Connection conn = getConnection()) {
//            PreparedStatement statement = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
//            statement.setString(1, user.getUsername());
//            statement.setString(2, user.getPassword());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle exceptions appropriately
//        }
//    }
//
//    private void deleteUserFromDatabase(User user) {
//        try (Connection conn = getConnection()) {
//            PreparedStatement statement = conn.prepareStatement("DELETE FROM users WHERE username = ?");
//            statement.setString(1, user.getUsername());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle exceptions appropriately
//        }
//    }
//
//    private void updateUserInDatabase(User user) {
//        try (Connection conn = getConnection()) {
//            PreparedStatement statement = conn.prepareStatement("UPDATE users SET password = ? WHERE username = ?");
//            statement.setString(1, user.getPassword());
//            statement.setString(2, user.getUsername());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle exceptions appropriately
//        }
//    }
//
//    // User class
//    public static class User {
//        private String username;
//        private String password;
//
//        public User(String username, String password) {
//            this.username = username;
//            this.password = password;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//    }
//}
//

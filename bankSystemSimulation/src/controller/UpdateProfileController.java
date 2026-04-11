package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import entity.User;
import service.UserService;
import utils.SessionManager;

public class UpdateProfileController {

    @FXML
    private TextField txtUsername,txtAddress;

    @FXML
    private TextField txtFullName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblMessage;

    private UserService userService = new UserService();

    // Automatically called when FXML loads
    @FXML
    public void initialize() {
        User user = SessionManager.getUser();

        if (user != null) {
            txtUsername.setText(user.getUserName());
            txtFullName.setText(user.getFullName());
            txtAddress.setText(user.getAdress());
            txtPassword.setText(user.getPassword()); // optional (can skip for security)
        }
    }

    @FXML
    public void handleUpdateProfile() {
        try {
            User currentUser = SessionManager.getUser();
            

            String username = txtUsername.getText();
            String fullName = txtFullName.getText();
            String password = txtPassword.getText();
            String Adress=txtAddress.getText();

            // Update user object
            
            
            currentUser.setUserName(username);
            currentUser.setFullName(fullName);
            currentUser.setPassword(password);
            currentUser.setAdress(Adress);

            boolean isUpdated = userService.UpdateUser(currentUser);

            if (isUpdated) {
                lblMessage.setText("Profile updated successfully!");
                SessionManager.setUser(currentUser); 
            } else {
                lblMessage.setText("Update failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            lblMessage.setText("Error occurred!");
        }
    }
}
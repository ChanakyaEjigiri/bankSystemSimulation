package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UserService;
import utils.SessionManager;
import entity.User;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblMessage;

    private UserService userService=new UserService();;

    @FXML
    public void handleLogin() {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        User user = userService.LoginService(username, password);
        
        if(user!=null) {
        	//System.out.println("logged in");
            lblMessage.setText("Login Successful");
			SessionManager.setLoggedInUserid(user.getUserId());
			SessionManager.setUserName(user.getUserName());
            
            try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashBoard.fxml"));
	            Parent root = loader.load();
	            
	            DashboardController controller = loader.getController();
	            controller.setUser(user); 

	            Stage stage = (Stage) txtUsername.getScene().getWindow();
	            stage.setScene(new Scene(root));
	            stage.setTitle("Register");
	            stage.show();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
        } else {
            lblMessage.setText("Invalid Credentials");
        }
    }

    @FXML
    public void openRegister() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Register.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) txtUsername.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Register");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
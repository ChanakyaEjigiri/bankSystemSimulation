package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.AccountServices;
import service.UserService;
import utils.SessionManager;

import java.awt.Button;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Account;
import entity.User;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private Button btnLogout;

    @FXML
    private Label lblMessage;

    private UserService userService=new UserService();;

    @FXML
    public void handleLogin() {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        User user = userService.LoginService(username, password);
        
        
        
        if(user!=null) {
        	SessionManager.setUser(user);
            
            AccountServices accountService=new AccountServices(); 
//            System.out.println(user.getUserId());
//            System.out.println(accountService.getAccounts(2));
            List<Account> accounts = accountService.getAccounts(user.getUserId());
            List<Integer> accountIds = new ArrayList<>();
            for(Account acc: accounts ) {
            	accountIds.add(acc.getAccountId());
            }
            
            SessionManager.setAccountIds(accountIds);
        	//System.out.println("logged in");
            lblMessage.setText("Login Successful");
			
            
            try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashBoard.fxml"));
	            Parent root = loader.load();
	            
//	            DashboardController controller = loader.getController();
//	            controller.setUser(user); 

	            Stage stage = (Stage) txtUsername.getScene().getWindow();
	            stage.setScene(new Scene(root,800,600));
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
    
        
//        DashboardController controller = loader.getController();
//        controller.setUser(user); 

    
}
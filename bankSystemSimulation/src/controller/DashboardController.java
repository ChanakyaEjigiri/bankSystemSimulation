package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.SessionManager;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;

import entity.User;

public class DashboardController {

    @FXML
    private Label lblWelcome;

    @FXML
    private StackPane contentArea;

    private User user=SessionManager.getUser();

//    public void setUser(User user) {
//        this.user = user;
//        lblWelcome.setText("Welcome, " + user.getFullName());
//    }
    
    
    public void loadUI(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/" + fxml));
            Node node = loader.load();

            
            if (fxml.equals("profile.fxml")) {
            	ProfileController controller = loader.getController();
                controller.setUser();
                
            }

            contentArea.getChildren().setAll(node);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    @FXML
    private void showProfile() {
        loadUI("profile.fxml");
        
    }

    @FXML
    private void showUpdateProfile() {
        loadUI("updateProfile.fxml");
    }

    @FXML
    private void showDeposit() {
        loadUI("deposit.fxml");
    }

    @FXML
    private void showWithdraw() {
        loadUI("withdraw.fxml");
    }

    @FXML
    private void showTransfer() {
        loadUI("transfer.fxml");
    }

    @FXML
    private void showBalance() {
        loadUI("CheckBalance.fxml");
    }

    @FXML
    private void showTransactions() {
        loadUI("transactions.fxml");
    }

    @FXML
    private void showCreateAccount() {
        loadUI("createAccount.fxml");
    }


    @FXML
    private void deleteAccount() {
        System.out.println("Delete Account clicked");
        
    }

    @FXML
    private void deleteUser() {
        System.out.println("Delete User clicked");
    }
    

    @FXML
    private void handleLogout() {
    	SessionManager.clearSession();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
        
		try {
			Parent root = loader.load();
			Stage stage = (Stage) contentArea.getScene().getWindow();
	        stage.setScene(new Scene(root,800,600));
	        stage.setTitle("Register");
	        stage.show();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
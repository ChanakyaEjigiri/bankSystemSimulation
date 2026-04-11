package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import utils.SessionManager;
import entity.User;

public class ProfileController {

    @FXML private Label lblUserId;
    @FXML private Label lblUsername;
    @FXML private Label lblFullName;
    @FXML private VBox formBox, resultBox;
    
    @FXML private ListView<Integer> accountList;
    
    public void setUser() {
    	System.out.println("this"+SessionManager.getUser().getUserId());
    	

        resultBox.setVisible(true);
        resultBox.setManaged(true);
        lblUserId.setText("User ID: " + SessionManager.getUser().getUserId());
        lblUsername.setText("Username: " + SessionManager.getUser().getUserName());
        lblFullName.setText("Name: " + SessionManager.getUser().getFullName());

        // Example accounts
        accountList.getItems().addAll(SessionManager.getAccountIds());
    }
}
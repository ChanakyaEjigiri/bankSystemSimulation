package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import service.UserService;
import daoImplementation.UsersDaoImpl;
import entity.User;

public class RegisterController {

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextArea txtAddress;

//    @FXML
//    private ComboBox<String> cmbAccountType;

    @FXML
    private Label lblMessage;
    
    
    private UserService userService=new UserService();

//    @FXML
//    public void initialize() {
//        cmbAccountType.getItems().addAll("SAVINGS", "CURRENT");
//    }

    @FXML
    public void handleRegister() {
    	String userName = txtUsername.getText();
        String password = txtPassword.getText();
        String fullName = txtFullName.getText();
        String mobileNumber = txtMobile.getText();
        String address = txtAddress.getText();

        User user = new User(fullName, userName, password,mobileNumber,address);
        
		boolean isRegistered=userService.RegisterService(user);
		
		if(isRegistered) {
			System.out.println("Registerd Successfully");
			try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
	            Parent root = loader.load();
	            
	            

	            Stage stage = (Stage) txtUsername.getScene().getWindow();
	            stage.setScene(new Scene(root));
	            stage.setTitle("Register");
	            stage.show();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		else {
			System.out.println("Enter Valid Details");
		}       
    }
}
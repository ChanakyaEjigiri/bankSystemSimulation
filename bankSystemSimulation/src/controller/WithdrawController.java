package controller;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import service.AccountServices;
import service.TransactionalServices;
import utils.SessionManager;

public class WithdrawController {

    @FXML private TextField txtAmount;

    @FXML private Label lblMessage;
    @FXML private Label lblAmount;
    @FXML private Label lblBalance;

    @FXML private VBox formBox;
    @FXML private VBox resultBox;
    @FXML private ComboBox<Integer> accountDropdown;
 
    
    @FXML
    public void initialize() {
    	
        List<Integer> userAccounts = SessionManager.getAccountIds();;
        System.out.println("done"+ userAccounts);
        accountDropdown.getItems().setAll(userAccounts);
    }
    
    @FXML
    private void handleWithdraw() {

        String amountText = txtAmount.getText();

        if (amountText.isEmpty()) {
            lblMessage.setText("Please enter amount");
            return;
        }

        double amount;

        try {
            amount = Double.parseDouble(amountText);
        } catch (Exception e) {
            lblMessage.setText("Invalid amount");
            return;
        }

        if (amount <= 0) {
            lblMessage.setText("Amount must be greater than 0");
            return;
        }

        
        //int userId = SessionManager.getLoggedInUserid();
        //int accountNum=SessionManager.getAccountIds();
        int accountNum=accountDropdown.getValue();
        
        AccountServices depositService=new AccountServices();
        
        
        boolean isWithdrawn=depositService.Withdraw(amount, accountNum);
        
        if(isWithdrawn) {
        	TransactionalServices insertTransaction=new TransactionalServices();
        	insertTransaction.saveTransaction(accountNum,0,amount,"WITHDRAW");
        	
        	formBox.setVisible(false);
            formBox.setManaged(false);

            resultBox.setVisible(true);
            resultBox.setManaged(true);

            lblMessage.setText("Withdraw Successful");
            lblAmount.setText("Amount Withdrawn: ₹" + amount);
            lblBalance.setText("Remaining Balance: ₹" + " *****");
        }


        
    }
    


    @FXML
    private void handleNewTransaction() {

        
        formBox.setVisible(true);
        formBox.setManaged(true);

        resultBox.setVisible(false);
        resultBox.setManaged(false);

        
        txtAmount.clear();
        lblMessage.setText("");
        lblAmount.setText("");
        lblBalance.setText("");
    }
}
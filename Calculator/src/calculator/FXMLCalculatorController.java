/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author chris
 */
public class FXMLCalculatorController implements Initializable {
    
    @FXML
    private Label output;
    
    private long number1 = 0;
    
    private String operator = "";
    
    private boolean start = true;
    
    private Model model = new Model();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void processNumPad(ActionEvent event) {
        
        if(start) {
            output.setText("");
            start = false;
        }
        
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
        
    }

    @FXML
    private void processOperator(ActionEvent event) {
        
        String value = ((Button)event.getSource()).getText();
        
        if (!"=".equals(value)) {
            if(!operator.isEmpty())
                return;
            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        }
        else {
            if (operator.isEmpty())
                return;
            
            output.setText(String.valueOf(model.calculate(number1, Long.parseLong(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }
    
}

package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Text previousOperandElement;
    @FXML
    private Text currentOperandElement;
    @FXML
    private Button Btn0;
    @FXML
    private Button Btn1;
    @FXML
    private Button Btn2;
    @FXML
    private Button Btn3;
    @FXML
    private Button Btn4;
    @FXML
    private Button Btn5;
    @FXML
    private Button Btn6;
    @FXML
    private Button Btn7;
    @FXML
    private Button Btn8;
    @FXML
    private Button Btn9;
    @FXML
    private Button Dot;
    @FXML
    private Button Divide;
    @FXML
    private Button Multiple;
    @FXML
    private Button Negative;
    @FXML
    private Button Plus;
    @FXML
    private Button AllClear;
    @FXML
    private Button Del;
    @FXML
    private Button Equals;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Calculator calculator = new Calculator(previousOperandElement, currentOperandElement);

        Button[] numbers = { Btn0,Btn1,Btn2,Btn3,Btn4,Btn5,Btn5,Btn6,Btn7,Btn8,Btn9,Dot};
        Button[] operations = { Divide, Multiple, Negative, Plus};

        for (int i = 0; i < numbers.length; i++){
            Button number = numbers[i];
            number.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    calculator.appendNumber(number.getText());
                    calculator.update();
                }
            });
        }
        for (int i = 0; i < operations.length; i++){
            Button operation = operations[i];
            operation.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    calculator.selectOperation(operation.getText());
                    calculator.update();
                }
            });
        }
        AllClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculator.clear();
                calculator.update();
            }
        });
        Del.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculator.delete();
                calculator.update();
            }
        });
        Equals.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculator.compute();
                calculator.update();
            }
        });
    }
}

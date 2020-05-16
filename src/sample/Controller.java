package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Stack;

public class Controller {

    Stack<Double> stack = new Stack<>();
    private double displayValue;
    private boolean buildingDisplayValue;
    private double firstValue;
    private double secondValue;
    @FXML
    private TextField textField;
    @FXML
    private TextField textField2;
    @FXML
    private Button buttonPoint;

    @FXML
    public void handleAction(){

    }
    @FXML
    public void numberPressed(ActionEvent e){
        String value = ((Button) e.getSource()).getText();
        textField.setText(textField.getText() + value);

    }
    @FXML
    public void pointPressed(ActionEvent e){
        if (e.getSource() == buttonPoint){
            if(textField.getText().contains(".")){

            } else {
                textField.setText(textField.getText() + ".");
            }

        }
    }
    @FXML
    public void chsPressed(ActionEvent e){
        double displayValue = toDouble(textField.getText());
        displayValue = -displayValue;
        textField.setText("" + displayValue);
    }
    @FXML
    public void clearPressed(){
        textField.clear();
        textField2.clear();
        stack.empty();
    }
    @FXML
    public void plusPressed(){
        stack.push(toDouble(textField.getText()));
        firstValue = stack.pop();
        secondValue = stack.pop();
        displayValue = firstValue + secondValue;
        textField.setText(toString(displayValue));
        stack.push(displayValue);
    }
    @FXML
    public void minusPressed(){
        stack.push(toDouble(textField.getText()));
        firstValue = stack.pop();
        secondValue = stack.pop();
        displayValue = secondValue - firstValue;
        textField.setText(toString(displayValue));
        stack.push(displayValue);
    }
    @FXML
    public void multiplyPressed(){
        stack.push(toDouble(textField.getText()));
        firstValue = stack.pop();
        secondValue = stack.pop();
        displayValue = firstValue * secondValue;
        textField.setText(toString(displayValue));
        stack.push(displayValue);
    }
    @FXML
    public void dividePressed(){
        stack.push(toDouble(textField.getText()));
        firstValue = stack.pop();
        secondValue = stack.pop();
        displayValue = secondValue / firstValue;
        textField.setText(toString(displayValue));
        stack.push(displayValue);
    }
    @FXML
    public void enterPressed(){
        if (textField.getText().matches("\\d{0,7}([\\.]\\d{0,4})?") && (!textField.getText().isEmpty())){
            stack.push(toDouble(textField.getText()));
            textField2.setText(textField.getText());
            textField.setText("");
        } else {
            System.out.println("Wrong input");
        }

    }
    @FXML
    public void getDisplayValue(){

    }

    public double toDouble(String text){
        return displayValue = Double.parseDouble(text);
    }

    public String toString(double number){
        String text;
        return text = Double.toString(number);
    }
}

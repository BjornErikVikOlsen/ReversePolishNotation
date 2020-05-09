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
    private Label label;
    @FXML
    private Button buttonZero;
    @FXML
    private Button buttonOne;
    @FXML
    private Button buttonTwo;
    @FXML
    private Button buttonThree;
    @FXML
    private Button buttonFour;
    @FXML
    private Button buttonFive;
    @FXML
    private Button buttonSix;
    @FXML
    private Button buttonSeven;
    @FXML
    private Button buttonEight;
    @FXML
    private Button buttonNine;
    @FXML
    private Button buttonPoint;

    @FXML
    public void handleAction(){

    }
    @FXML
    public void numberPressed(ActionEvent e){
        if(e.getSource() == buttonOne){
            textField.setText(textField.getText() + "1");
        } else if (e.getSource() == buttonTwo){
            textField.setText(textField.getText() + "2");
        } else if(e.getSource() == buttonThree){
            textField.setText(textField.getText() + "3");
        } else if(e.getSource() == buttonFour){
            textField.setText(textField.getText() + "4");
        } else if(e.getSource() == buttonFive){
            textField.setText(textField.getText() + "5");
        } else if(e.getSource() == buttonSix){
            textField.setText(textField.getText() + "6");
        } else if(e.getSource() == buttonSeven){
            textField.setText(textField.getText() + "7");
        } else if(e.getSource() == buttonEight){
            textField.setText(textField.getText() + "8");
        } else if(e.getSource() == buttonNine){
            textField.setText(textField.getText() + "9");
        } else if(e.getSource() == buttonZero){
            textField.setText(textField.getText() + "0");
        }
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
        stack.push(toDouble(textField.getText()));
        textField.setText("");
    }
    @FXML
    public void getDisplayValue(){

    }
    @FXML
    public void getVersion(){
        label.setText("0.1");
    }

    public double toDouble(String text){
        return displayValue = Double.parseDouble(text);
    }

    public String toString(double number){
        String text;
        return text = Double.toString(number);
    }
}

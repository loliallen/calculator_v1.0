package sample;
import javafx.scene.text.Text;

public class Calculator {
    public String previousOperand;
    public String currentOperand;
    public String operation;
    public Text previousOperandTextElement;
    public Text currentOperandTextElement;

    public Calculator(Text previousOperandTextElement, Text currentOperandTextElement){
        this.previousOperandTextElement = previousOperandTextElement;
        this.currentOperandTextElement = currentOperandTextElement;
        this.clear();
    }

    public void clear() {
        this.previousOperand = "";
        this.currentOperand = "";
        this.operation = null;
        this.update();
    }
    public void delete() {
        this.currentOperand = slice(this.currentOperand, 0, this.currentOperand.length() - 1);
    }
    public void appendNumber(String number) {
        if(number.equals("\\.") && this.currentOperand.contains("\\.")) return;
        this.currentOperand += number;
    }
    public void selectOperation(String operation) {
        if(this.currentOperand.equals("")) return;
        if (!this.previousOperand.equals("")) {
            this.compute();
        }
        this.operation = operation;
        this.previousOperand = this.currentOperand;
        this.currentOperand = "";
    }
    public void update() {
        this.currentOperandTextElement.setText(this.getDisplayNumber(this.currentOperand));
        if(operation != null){
            this.previousOperandTextElement.setText(this.getDisplayNumber(this.previousOperand)+" "+operation);
        } else {
            this.previousOperandTextElement.setText("");
        }
    }
    public void compute() {
        float computation;
        if(this.previousOperand.isEmpty() || this.currentOperand.isEmpty()) return;

        float prev = Float.parseFloat(this.previousOperand);
        float current = Float.parseFloat(this.currentOperand);
        switch (this.operation){
            case "+":
                computation = prev + current;
                break;
            case "-":
                computation = prev - current;
                break;
            case "*":
                computation = prev * current;
                break;
            case "÷":
                computation = prev / current;
                break;
            default: return;
        }
        this.currentOperand = String.valueOf(computation);
        this.operation = null;
        this.previousOperand = "";
    }

    private String getDisplayNumber(String number){
        if(number.isEmpty()) return "";
        if(!number.contains("\\.")) return number;

        String[] splitNumber = number.split("\\.");
        String integerDisplay;
        int integer = Integer.parseInt(splitNumber[0]);
        int decimal = Integer.parseInt(splitNumber[1]);


        if(Float.isNaN(integer))
            integerDisplay = "";
        else
            integerDisplay = String.valueOf(integer);

        if(Float.isNaN(decimal) || decimal == 0)
            return integerDisplay;
        else
            return String.valueOf(Float.parseFloat(integerDisplay+'.'+decimal));
    }


    private String slice(String str, int begin, int end){
        String string = "";
        for (int i = begin; i < end; i++){
            string += str.charAt(i);
        }
        return string;
    }


}

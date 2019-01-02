package com.example.wachayathorn.appcal;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private double firstOperand = 0;
    private double secondOperand = 0;
    private double previousAnswer;

    private String operator = "";
    private int mode = 1;
    private boolean isOnAnswer = false;
    private String first = "";
    private String second = "";

    EditText editText = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.textinput);

    }

    public void onClick (View view){

        switch (view.getId()){
            case R.id.bt0:
                setTextShow("0", "operand");
                break;
            case R.id.bt1:
                setTextShow("1", "operand");
                break;
            case R.id.bt2:
                setTextShow("2", "operand");
                break;
            case R.id.bt3:
                setTextShow("3", "operand");
                break;
            case R.id.bt4:
                setTextShow("4", "operand");
                break;
            case R.id.bt5:
                setTextShow("5", "operand");
                break;
            case R.id.bt6:
                setTextShow("6", "operand");
                break;
            case R.id.bt7:
                setTextShow("7", "operand");
                break;
            case R.id.bt8:
                setTextShow("8", "operand");
                break;
            case R.id.bt9:
                setTextShow("9", "operand");
                break;
            case R.id.btdot:
                setTextShow(".", "operand");
                break;

            case R.id.btplus:
                setTextShow("+", "operator");
                break;
            case R.id.btminus:
                setTextShow("-", "operator");
                break;
            case R.id.btmultiply:
                setTextShow("*", "operator");
                break;
            case R.id.btdivide:
                setTextShow("/", "operator");
                break;

            case R.id.btequal:
                if(first.isEmpty() || second.isEmpty()) return;
                else {
                    calculate(first, second);
                }
                break;

            case R.id.btclear:
                clearData();
                break;
        }
    }

    public void setTextShow (String text , String type){
        switch (type) {
            case "operand":
                if (mode == 1) {
                    first += text;
                    editText.setText(first);
                } else {
                    second += text;
                    editText.setText(second);
                }
                break;
            case "operator":
                operator = text;
                mode = 2;
                break;
        }
    }

    private void calculate(String first, String second) {
        double answer = 0;
            isOnAnswer = true;
            firstOperand = Double.parseDouble(first);
            secondOperand = Double.parseDouble(second);


            switch (operator) {
                case "+":
                    answer = firstOperand + secondOperand;
                    break;
                case "-":
                    answer = firstOperand - secondOperand;
                    break;
                case "*":
                    answer = firstOperand * secondOperand;
                    break;
                case "/":
                    answer = firstOperand / secondOperand;
                    break;
            }
        afterStepAnswer(answer);
    }


    private void clearData() {
        previousAnswer = 0;
        firstOperand = 0;
        secondOperand = 0;
        operator = "";
        mode = 1;
        isOnAnswer = false;
        first = "";
        second = "";
        editText.setText("");
    }

    private void afterStepAnswer(double answer) {
        previousAnswer = answer;
        firstOperand = 0;
        secondOperand = 0;
        first = "";
        second = "";
        editText.setText(String.valueOf(answer));
    }



}

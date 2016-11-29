package com.programmer.dilip.coolcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textResult;
    String runningNumber = "";
    String leftValueStr = "";
    String rightValueStr = "";

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    Operation currentOperations;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(this);

        Button button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(this);

        Button button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener(this);

        Button button7 = (Button) findViewById(R.id.button_7);
        button7.setOnClickListener(this);

        Button button8 = (Button) findViewById(R.id.button_8);
        button8.setOnClickListener(this);

        Button button9 = (Button) findViewById(R.id.button_9);
        button9.setOnClickListener(this);

        Button button0 = (Button) findViewById(R.id.button_0);
        button0.setOnClickListener(this);

        ImageView imageEquals = (ImageView) findViewById(R.id.image_equals);
        imageEquals.setOnClickListener(this);

        ImageView imageAddition = (ImageView) findViewById(R.id.image_add);
        imageAddition.setOnClickListener(this);

        ImageView imageSubtraction = (ImageView) findViewById(R.id.image_substract);
        imageSubtraction.setOnClickListener(this);

        ImageView imageMultiply = (ImageView) findViewById(R.id.image_multiply);
        imageMultiply.setOnClickListener(this);

        ImageView imageModulus = (ImageView) findViewById(R.id.image_modulus);
        imageModulus.setOnClickListener(this);

        Button buttonClear = (Button) findViewById(R.id.button_clear);
        buttonClear.setOnClickListener(this);

        textResult = (TextView) findViewById(R.id.text_result);
        textResult.setText("");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_0:
                numberPressed(0);
                break;
            case R.id.button_1:
                numberPressed(1);
                break;
            case R.id.button_2:
                numberPressed(2);
                break;
            case R.id.button_3:
                numberPressed(3);
                break;
            case R.id.button_4:
                numberPressed(4);
                break;
            case R.id.button_5:
                numberPressed(5);
                break;
            case R.id.button_6:
                numberPressed(6);
                break;
            case R.id.button_7:
                numberPressed(7);
                break;
            case R.id.button_8:
                numberPressed(8);
                break;
            case R.id.button_9:
                numberPressed(9);
                break;
            case R.id.button_clear:
                leftValueStr = "";
                rightValueStr = "";
                runningNumber = "";
                currentOperations = null;
                result = 0;
                textResult.setText("");
                break;
            case R.id.image_add:
                processOperation(Operation.ADD);
                break;
            case R.id.image_substract:
                processOperation(Operation.SUBTRACT);
                break;
            case R.id.image_multiply:
                processOperation(Operation.MULTIPLY);
                break;
            case R.id.image_modulus:
                processOperation(Operation.DIVIDE);
                break;
            case R.id.image_equals:
                processOperation(Operation.EQUAL);
                break;
        }
    }

    void processOperation(Operation operation) {
        if (currentOperations != null) {
            if (!runningNumber.isEmpty()) {
                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperations) {
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                }

                leftValueStr = String.valueOf(result);
                textResult.setText(leftValueStr);
            }
        } else {
            leftValueStr = runningNumber;
            textResult.setText(leftValueStr);
        }

        currentOperations = operation;
    }

    void numberPressed(int number) {
        runningNumber += String.valueOf(number);
        textResult.setText(runningNumber);
    }
}

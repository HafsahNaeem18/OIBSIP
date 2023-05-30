package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView inputTextView;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTextView = findViewById(R.id.inputTextView);
        outputTextView = findViewById(R.id.outputTextView);

        Button button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("0");
            }
        });

        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("1");
            }
        });

        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("2");
            }
        });

        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("3");
            }
        });

        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("4");
            }
        });

        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("5");
            }
        });

        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("6");
            }
        });

        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("7");
            }
        });

        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("8");
            }
        });

        Button button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("9");
            }
        });

        Button buttonEquals = findViewById(R.id.button_equals);
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });

        Button buttonClear = findViewById(R.id.button_clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputTextView();
            }
        });

        Button buttonBackspace = findViewById(R.id.button_backspace);
        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteLastCharacter();
            }
        });

        Button buttonAdd = findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("+");
            }
        });

        Button buttonSubtract = findViewById(R.id.button_subtract);
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("-");
            }
        });

        Button buttonMultiply = findViewById(R.id.button_multiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("*");
            }
        });

        Button buttonDivide = findViewById(R.id.button_divide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("/");
            }
        });

        Button buttonLeftBracket = findViewById(R.id.button_left_bracket);
        buttonLeftBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView("(");
            }
        });

        Button buttonRightBracket = findViewById(R.id.button_right_bracket);
        buttonRightBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView(")");
            }
        });

        Button buttonDot = findViewById(R.id.button_dot);
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputTextView(".");
            }
        });

    }

    private void appendToInputTextView(String text) {
        String currentInput = inputTextView.getText().toString();
        currentInput += text;
        inputTextView.setText(currentInput);
    }

    private void clearInputTextView() {
        inputTextView.setText("");
        outputTextView.setText("");
    }

    private void deleteLastCharacter() {
        String currentInput = inputTextView.getText().toString();
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            inputTextView.setText(currentInput);
        }
    }

    private void calculateResult() {
        String input = inputTextView.getText().toString();

        try {
            ExpressionBuilder builder = new ExpressionBuilder(input);
            double result = builder.build().evaluate();
            outputTextView.setText(Double.toString(result));
        } catch (Exception e) {
            // Handle invalid expression error
            e.printStackTrace();
        }
    }
}

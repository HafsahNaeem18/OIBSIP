package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextValue;
    private Button buttonConvert;
    private TextView textViewResult;
    private Spinner spinnerInputUnit;
    private Spinner spinnerOutputUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValue = findViewById(R.id.editTextValue);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);
        spinnerInputUnit = findViewById(R.id.spinnerInputUnit);
        spinnerOutputUnit = findViewById(R.id.spinnerOutputUnit);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertValue();
            }
        });
    }

    private void convertValue() {
        String input = editTextValue.getText().toString().trim();

        if (input.isEmpty()) {
            textViewResult.setText("Please enter a value");
            return;
        }

        double value = Double.parseDouble(input);

        String selectedInputUnit = spinnerInputUnit.getSelectedItem().toString();
        String selectedOutputUnit = spinnerOutputUnit.getSelectedItem().toString();

        double result;
        String resultText;

        // Perform the conversions based on selectedInputUnit and selectedOutputUnit
        if (selectedInputUnit.equals("Grams") && selectedOutputUnit.equals("Grams")) {
            result = value;
            resultText = String.valueOf(result);
        } else if (selectedInputUnit.equals("Kilograms") && selectedOutputUnit.equals("Kilograms")) {
            result = value;
            resultText = String.valueOf(result);
        } else if (selectedInputUnit.equals("Centimeters") && selectedOutputUnit.equals("Centimeters")) {
            result = value;
            resultText = String.valueOf(result);
        } else if (selectedInputUnit.equals("Meters") && selectedOutputUnit.equals("Meters")) {
            result = value;
            resultText = String.valueOf(result);
        } else if (selectedInputUnit.equals("Grams") && selectedOutputUnit.equals("Kilograms")) {
            result = ConvertUnit.gramsToKilograms(value);
            resultText = String.valueOf(result);
        } else if (selectedInputUnit.equals("Kilograms") && selectedOutputUnit.equals("Grams")) {
            result = ConvertUnit.kilogramsToGrams(value);
            resultText = String.valueOf(result);
        } else if (selectedInputUnit.equals("Centimeters") && selectedOutputUnit.equals("Meters")) {
            result = ConvertUnit.centimetersToMeters(value);
            resultText = String.valueOf(result);
        } else if (selectedInputUnit.equals("Meters") && selectedOutputUnit.equals("Centimeters")) {
            result = ConvertUnit.metersToCentimeters(value);
            resultText = String.valueOf(result);
        } else {
            resultText = "Invalid conversion";
        }

        textViewResult.setText(resultText);
    }

}
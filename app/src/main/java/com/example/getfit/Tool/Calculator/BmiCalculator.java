package com.example.getfit.Tool.Calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getfit.R;

import java.text.DecimalFormat;

public class BmiCalculator extends AppCompatActivity {

    EditText editTextWeight, editTextHeight;
    Button buttonCalculate;
    TextView textViewResult, textViewPersonalMeasurement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);
        textViewPersonalMeasurement = findViewById(R.id.textViewPersonalMeasurement);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            textViewResult.setText("Please fill in the fields");
            return;
        }

        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr) / 100; // Convert height to meters

        float bmi = calculateBMIValue(weight, height);
        String bmiStatus = interpretBMI(bmi);
        String personalMeasurement = getPersonalMeasurementResults(bmi, height);

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        textViewResult.setText(String.format("%s\n%s", decimalFormat.format(bmi), bmiStatus));
        textViewPersonalMeasurement.setText(personalMeasurement);
    }

    private float calculateBMIValue(float weight, float height) {
        return weight / (height * height);
    }

    private String interpretBMI(float bmi) {
        if (bmi < 16) {
            return "Severely Underweight";
        } else if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal Weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    private String getPersonalMeasurementResults(float bmi, float height) {
        String bmiCategory;
        if (bmi < 16) {
            bmiCategory = "Severely Underweight";
        } else if (bmi < 18.5) {
            bmiCategory = "Underweight";
        } else if (bmi < 25) {
            bmiCategory = "Normal Weight";
        } else if (bmi < 30) {
            bmiCategory = "Overweight";
        } else {
            bmiCategory = "Obese";
        }

        float lowerPreferredWeight = 18.5f * height * height;
        float upperPreferredWeight = 25f * height * height;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return String.format("Current BMI: %.1f kg/m²\nHealthy BMI range: 18.5 kg/m² - 25 kg/m²\nHealth Status: %s\nIt is preferred for your weight to be between %.1f kg/m² - %.1f kg/m²",
                bmi, bmiCategory, lowerPreferredWeight, upperPreferredWeight);
    }

}
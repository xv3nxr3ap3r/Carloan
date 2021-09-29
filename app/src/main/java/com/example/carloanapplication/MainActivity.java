package com.example.carloanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonLease;
    private Button buttonLoan;
    private EditText editMonthlyPayment;
    private EditText editLength;
    private EditText editInterestRate;
    private EditText editDownPayment;
    private EditText editPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLease = findViewById(R.id.buttonLease);
        buttonLoan = findViewById(R.id.buttonLoan);
        editMonthlyPayment = findViewById(R.id.editMonthlyPayment);
        editLength = findViewById(R.id.editLength);
        editInterestRate = findViewById(R.id.editInterestRate);
        editDownPayment = findViewById(R.id.editDownPayment);
        editPrice = findViewById(R.id.editPrice);


        buttonLease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double Price = Double.parseDouble(editPrice.getText().toString())/3;
                double Length = Double.parseDouble(editLength.getText().toString());
                double InterestRate = Double.parseDouble(editInterestRate.getText().toString());
                double MR = ((InterestRate /100)/12);
                double DownPayment = Double.parseDouble(editDownPayment.getText().toString());
                double L = Price - DownPayment;
                double sum2 = (MR*L)/( 1 - (Math.pow((1+MR), -Length)));
                editMonthlyPayment.setText("the number is :" +sum2);

            }
        });
        buttonLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Price = Double.parseDouble(editPrice.getText().toString());
                double Length = Double.parseDouble(editLength.getText().toString());
                double InterestRate = Double.parseDouble(editInterestRate.getText().toString());
                double MR = ((InterestRate /100)/12);
                double DownPayment = Double.parseDouble(editDownPayment.getText().toString());
                double L = Price - DownPayment;
                double sum1 = (MR* L );
                double ugh = 1 + MR;
                double sum2 = (Math.pow((ugh), -Length));
                double sum4 = 1-sum2;
                double sum3 = sum1/sum4;

                editMonthlyPayment.setText("the number is :" +sum3);
            }
        });
    }

    //double num = Integer.parseInt(editMonthlyPayment.getText().toString());
    //        double Price = Double.parseDouble(editPrice.getText().toString());
    //        double Length = Double.parseDouble(editLength.getText().toString());
    //        double InterestRate = Double.parseDouble(editInterestRate.getText().toString());
    //        double MR = InterestRate / 12;
    //        double Downpayment = Double.parseDouble(editDownPayment.getText().toString());
    //        double sum = (MR * Length) / 1 - Math.pow(1 + MR, 12);
}

package com.example.currencyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot, btnc, btndel;
    Button btnchange;
    TextView tvsrc, tvdst, tvwordsrc, tvworddst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDot = findViewById(R.id.btndot);

        btnc = findViewById(R.id.btnc);
        btndel = findViewById(R.id.btndel);

        btnchange = findViewById(R.id.btnchange);

        tvsrc = findViewById(R.id.tvsrc);
        tvdst = findViewById(R.id.tvdst);
        tvwordsrc = findViewById(R.id.tvwordsrc);
        tvworddst = findViewById(R.id.tvworddst);

        View.OnClickListener numbersListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button temp = (Button) view;
                String s = temp.getText().toString();
                String total = tvsrc.getText().toString();

                if (total.equals("0")) { //if number is already zero (empty)
                    total = s;
                    tvsrc.setText(total);
                    calc();
                    return;
                }
                //any other digit
                if (total.length() < 10) {
                    total += s;
                    tvsrc.setText(total);
                    calc();
                } else
                    Toast.makeText(getApplicationContext(), "Maximum Length reached", Toast.LENGTH_LONG);
            }
        };

        tvsrc.setText("0");
        tvdst.setText("0");
        btn9.setOnClickListener(numbersListner);
        btn8.setOnClickListener(numbersListner);
        btn7.setOnClickListener(numbersListner);
        btn6.setOnClickListener(numbersListner);
        btn5.setOnClickListener(numbersListner);
        btn4.setOnClickListener(numbersListner);
        btn3.setOnClickListener(numbersListner);
        btn2.setOnClickListener(numbersListner);
        btn1.setOnClickListener(numbersListner);
        btn0.setOnClickListener(numbersListner);

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvwordsrc.getText().toString().equals("EGP")) {
                    tvwordsrc.setText("USD");
                    tvworddst.setText("EGP");
                } else {
                    tvwordsrc.setText("EGP");
                    tvworddst.setText("USD");
                }
            }
        });

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvsrc.setText("0");
                calc();
            }
        });

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = tvsrc.getText().toString();
                if (s.length() > 1) {
                    s = s.substring(0, s.length() - 1);
                    tvsrc.setText(s);
                    calc();
                } else if (s.length() == 1) {
                    tvsrc.setText("0");
                    calc();
                }
            }
        });
    }

    void calc() {
        String s = tvsrc.getText().toString();
        if (tvwordsrc.getText().toString().equals("EGP")) {
            float n = Float.parseFloat(s);
            n = n / (float) 16.3;
            tvdst.setText(Float.toString(n));
        } else {
            float n = Float.parseFloat(s);
            n = n * (float) 16.3;
            tvdst.setText(Float.toString(n));
        }
    }
}

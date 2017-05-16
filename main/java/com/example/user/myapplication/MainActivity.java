package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button add, sub, mul, div, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bDec, equalTo, tenPow, ans, del, ac;
    EditText display;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.plus);
        sub = (Button) findViewById(R.id.minus);
        mul = (Button) findViewById(R.id.multiply);
        div = (Button) findViewById(R.id.divide);
        display = (EditText) findViewById(R.id.display);
        b0 = (Button) findViewById(R.id.b0);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        bDec = (Button) findViewById(R.id.bDecimal);
        equalTo = (Button) findViewById(R.id.equalTo);
        tenPow = (Button) findViewById(R.id.tenPower);
        ans = (Button) findViewById(R.id.ans);
        del = (Button) findViewById(R.id.delete);
        ac = (Button) findViewById(R.id.AC);
        add.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + "+");
                    }
                }
        );
        sub.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + "-");

                    }
                }
        );
        b0.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + "0");
                    }
                }
        );
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + "1");
                    }
                }
        );
        b2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + "2");
                    }
                }
        );
        b3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + "3");
                    }
                }
        );
        b4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + "4");
                    }
                }
        );
        b5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + "5");
                    }
                }
        );
        b6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + "6");
                    }
                }
        );
        b7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + "7");
                    }
                }
        );
        b8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + "8");
                    }
                }
        );
        b9.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + "9");
                    }
                }
        );
        bDec.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        display.setText(s + ".");
                    }
                }
        );
        equalTo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String a = display.getText().toString();
                        int ans1 = Integer.parseInt(a);
                        display.setText(ans1);
                    }
                }
        );
    }
}

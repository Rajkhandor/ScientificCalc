package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button add, sub, mul, div, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bDec, equalTo, tenPow, ans, del, ac;
    EditText display;
    TextView ansDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //  setContentView(R.layout.activity_main);

        //-------------------------------------------------------

        //Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

//Remove notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//set content view AFTER ABOVE sequence (to avoid crash)
        setContentView(R.layout.activity_main);

        //--------------------------------------------------------

        add = (Button) findViewById(R.id.plus);
        sub = (Button) findViewById(R.id.minus);
        mul = (Button) findViewById(R.id.multiply);
        div = (Button) findViewById(R.id.divide);
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

        display = (EditText) findViewById(R.id.display);

        ansDisplay = (TextView) findViewById(R.id.ansDisplay);

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
        add.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        String finalString="";
                        char check=s.charAt(s.length()-1);
                        if(check=='+' || check=='-' || check=='X' || check=='/')
                        {
                            for(int i=0;i<s.length()-1;i++)
                                finalString+=s.charAt(i);
                            finalString+="+";
                        }
                        else
                            finalString=s+"+";
                        display.setText(finalString);
                    }
                }
        );
        sub.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        String finalString="";
                        char check=s.charAt(s.length()-1);
                        if(check=='+' || check=='-' || check=='X' || check=='/')
                        {
                            for(int i=0;i<s.length()-1;i++)
                                finalString+=s.charAt(i);
                            finalString+="-";
                        }
                        else
                            finalString=s+"-";
                        display.setText(finalString);

                    }
                }
        );
        mul.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s = display.getText().toString();
                        String finalString="";
                        char check=s.charAt(s.length()-1);
                        if(check=='+' || check=='-' || check=='X' || check=='/')
                        {
                            for(int i=0;i<s.length()-1;i++)
                                finalString+=s.charAt(i);
                            finalString+="X";
                        }
                        else
                            finalString=s+"X";
                        display.setText(finalString);
                    }
                }
        );
        div.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s =display.getText().toString();
                        String finalString="";
                        char check=s.charAt(s.length()-1);
                        if(check=='+' || check=='-' || check=='X' || check=='/')
                        {
                            for(int i=0;i<s.length()-1;i++)
                                finalString+=s.charAt(i);
                            finalString+="/";
                        }
                        else
                            finalString=s+"/";
                        display.setText(finalString);
                    }
                }
        );
        equalTo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = display.getText().toString();

                        ansDisplay.setText(s);
                    }
                }
        );
        del.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String a=display.getText().toString();
                        String finalString="";
                        int len= a.length();
                        for(int i=0;i<len-1;i++)
                            finalString=finalString+a.charAt(i);
                        display.setText(finalString);
                    }
                }
        );
        ac.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        display.setText("");
                    }
                }
        );
        tenPow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // ** NOT COMPLETED **
                        String input=display.getText().toString();
                        input+="X10";
                        int check=input.length();
                        while(check==input.length())
                        {
                            //do nothing
                        }
                        input=display.getText().toString();
                        display.setText(Html.fromHtml(input+"<sup><small>2</small></sup>"));
                    }
                }
        );
    }
}


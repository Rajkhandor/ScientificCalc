package com.example.user.myapplication;

import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add, sub, mul, div ;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Button bDec, equalTo, tenPow, ans, del, ac;
    Button openBrac,closeBrac,sqrt,sin,cos,tan;
    Button Square,xn,log10,loge,xInverse,factorial;
    Button shift,pi,e,hyp,sd,integration;

    EditText display;

    TextView ansDisplay,show;

    double answer = 0;
    int count=0;
    boolean hypFlag=false;

    public static double factorial(double n)
    {
        if (n==1)
            return 1;
        else
            return n*factorial(n-1);
    }

    public static boolean isTopHigh(char a, char b) {
        if(b=='s' || b=='c' || b=='t' || b=='r' || b=='l' || b=='e' || b=='x' || b=='y' || b=='z' || b=='a' || b=='b' || b=='d' || b=='f' ||b=='g' || b=='h' || b=='!')
            return true;
        else if ((b == 'X' || b == '/' )&& !(a=='s' || a=='c' || a=='t' ||a=='r' || a=='l' || a=='e' || a=='x' || a=='y' || a=='z' || a=='a' || a=='b' || a=='d' ||  a=='f' || a=='g' || a=='h' || a=='!') )
            return true;
        else if ((a == '+' || a == '-') && (b == '+' || b == '-'))
            return true;
        else
            return false;
    }


    public static boolean isOperator(char a) {
        if (a == '+' || a == '-' || a == 'X' || a == '/' || a=='^')
            return true;
        else
            return false;
    }

    public static double oper( double a , double b, char op  ) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case 'X':
                return a * b;
            case '/':
                return a / b;
            case '^':
                return Math.pow(a,b);
        }
        return 0;
    }

    public static boolean isFunction(char a)
    {
        return (a=='s' || a=='c' || a=='t' || a=='r' || a=='l' || a=='e'|| a=='x' || a=='y' || a=='z' || a=='a' || a=='b' || a=='d' || a=='f' || a=='g' || a=='h' || a=='!');
    }

    public static double oper(double a,char op)
    {
        switch(op)
        {
            case 's':
                return Math.sin(Math.toRadians(a));
            case 'c':
                return Math.cos(Math.toRadians(a));
            case 't':
                return Math.tan(Math.toRadians(a));

            case 'x':
                return Math.toDegrees(Math.asin(a));
            case 'y':
                return Math.toDegrees(Math.acos(a));
            case 'z':
                return Math.toDegrees(Math.atan(a));

            case 'r':
                return Math.sqrt(a);
            case 'l':
                return Math.log10(a);
            case 'e':
                return Math.log(a);

            case 'a':
                return Math.log(a+Math.sqrt(a*a+1));   //sin Hyperbolic inverse
            case 'b':
                return Math.log(a+Math.sqrt(a*a-1));   //cos Hyperbolic inverse
            case 'd':
                return 0.5*(Math.log(1+a)-Math.log(1-a));  //tan Hyperbolic inverse

            case 'f':
                return Math.sinh(a);
            case 'g':
                return Math.cosh(a);
            case 'h':
                return Math.tanh(a);

            case '!':
                return factorial(a);
        }
        return 0;
    }

    public void insertMiddle(String a) {
        String input = display.getText().toString();
        int location = display.getSelectionStart();
        display.setText(input.substring(0, location) + a + input.substring(location, input.length()));
        display.setSelection(location + a.length());
    }

    public static long gcd(long m ,long n )
    {
        if(m!=n)
        {
            if(m>n)
            {
                return gcd(m-n,n);
            }
            else
            {
                return gcd(n-m,m);
            }
        }
        else
        {
            return m;
        }
    }
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

        openBrac = (Button) findViewById(R.id.openBrac);
        closeBrac = (Button) findViewById(R.id.closeBrac);
        sqrt = (Button) findViewById(R.id.sqRoot);

        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan  = (Button) findViewById(R.id.tan);

        Square = (Button) findViewById(R.id.square);
        xn = (Button) findViewById(R.id.xn);

        log10 = (Button) findViewById(R.id.log10);
        loge = (Button) findViewById(R.id.loge);

        xInverse = (Button) findViewById(R.id.xInverse);
        factorial = (Button) findViewById(R.id.factorial);
        shift= (Button) findViewById(R.id.shift);

        pi= (Button) findViewById(R.id.pi);
        e= (Button) findViewById(R.id.e);
        hyp= (Button) findViewById(R.id.hyperbolic);
        sd= (Button) findViewById(R.id.fraction);
        integration = (Button) findViewById(R.id.Integrate);

        display = (EditText) findViewById(R.id.display);

        ansDisplay = (TextView) findViewById(R.id.ansDisplay);
        show = (TextView) findViewById(R.id.show);

        b0.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertMiddle("0");
                    }
                }
        );
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertMiddle("1");
                    }
                }
        );
        b2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertMiddle("2");
                    }
                }
        );
        b3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertMiddle("3");
                    }
                }
        );
        b4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertMiddle("4");
                    }
                }
        );
        b5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertMiddle("5");
                    }
                }
        );
        b6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertMiddle("6");
                    }
                }
        );
        b7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertMiddle("7");
                    }
                }
        );
        b8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertMiddle("8");
                    }
                }
        );
        b9.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertMiddle("9");
                    }
                }
        );
        bDec.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertMiddle(".");
                    }
                }
        );
        add.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        int location = display.getSelectionStart();
                        if (location == s.length() && location!=0) {
                            String finalString = "";
                            char check = s.charAt(s.length() - 1);
                            if (isOperator(check)) {
                                finalString = s.substring(0, s.length() - 1);
                                finalString += "+";
                            } else
                                finalString = s + "+";
                            display.setText(finalString);
                            display.setSelection(finalString.length());
                        } else
                            insertMiddle("+");
                    }
                }
        );
        sub.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        String s = display.getText().toString();
                        int location = display.getSelectionStart();
                        if (location == s.length() && location !=0) {
                            String finalString = "";
                            char check = s.charAt(s.length() - 1);
                            if (isOperator(check)) {
                                finalString = s.substring(0, s.length() - 1);
                                finalString += "-";
                            } else
                                finalString = s + "-";
                            display.setText(finalString);
                            display.setSelection(finalString.length());
                        } else
                            insertMiddle("-");
                    }
                }
        );
        mul.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s = display.getText().toString();
                        int location = display.getSelectionStart();
                        if (location == s.length() && location!=0) {
                            String finalString = "";
                            char check = s.charAt(s.length() - 1);
                            if (isOperator(check)) {
                                finalString = s.substring(0, s.length() - 1);
                                finalString += "X";
                            } else
                                finalString = s + "X";
                            display.setText(finalString);
                            display.setSelection(finalString.length());
                        } else
                            insertMiddle("X");
                    }
                }
        );
        div.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s = display.getText().toString();
                        int location = display.getSelectionStart();
                        if (location == s.length() && location!=0) {
                            String finalString = "";
                            char check = s.charAt(s.length() - 1);
                            if (isOperator(check)) {
                                finalString = s.substring(0, s.length() - 1);
                                finalString += "/";
                            } else
                                finalString = s + "/";
                            display.setText(finalString);
                            display.setSelection(finalString.length());
                        } else
                            insertMiddle("/");
                    }
                }
        );
        openBrac.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        insertMiddle("(");
                    }
                }
        );
        closeBrac.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        insertMiddle(")");
                    }
                }
        );
        sqrt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        insertMiddle("\u221a"+"(");
                    }
                }
        );
        sin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(count%2==0) {
                            if(hypFlag)
                                 insertMiddle("sinh(");
                            else
                                insertMiddle("sin(");
                        }
                        else {
                            if(hypFlag)
                               insertMiddle("asinh(");
                            else
                                insertMiddle("asin(");
                        }
                    }
                }
        );
        cos.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(count%2==0) {
                            if(hypFlag)
                                insertMiddle("cosh(");
                            else
                                insertMiddle("cos(");
                        }
                        else {
                            if(hypFlag)
                                insertMiddle("acosh(");
                            else
                                insertMiddle("acos(");
                        }
                    }
                }

        );
        tan.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(count%2==0) {
                            if(hypFlag)
                                insertMiddle("tanh(");
                            else
                                insertMiddle("tan(");
                        }
                        else {
                            if(hypFlag)
                                insertMiddle("atanh(");
                            else
                                insertMiddle("atan(");
                        }
                    }
                }
        );
        Square.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(count%2==0)
                            insertMiddle("^2");
                        else
                            insertMiddle("^3");
                    }
                }
        );
        xn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        insertMiddle("^(");
                    }
                }
        );
        log10.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        insertMiddle("log(");
                    }
                }
        );
        loge.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        insertMiddle("ln(");
                    }
                }
        );
        xInverse.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int i;
                        int location=display.getSelectionStart();
                        String input=display.getText().toString();
                        String finalString="";
                        for(i=location-1;i>=0;i--)
                        {
                            if(isOperator(input.charAt(i)) || input.charAt(i)=='(' )
                                break;
                        }
                        finalString=input.substring(0,i+1)+"("+input.substring(i+1,location)+")";
                        display.setText(finalString + "^(-1)");
                        display.setSelection(location+7);
                    }
                }
        );
        factorial.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        insertMiddle("!");
                    }
                }
        );
        shift.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        count++;
                        if(count%2!=0) {
                            if (hypFlag) {
                                sin.setText("asinh");
                                cos.setText("acosh");
                                tan.setText("atanh");
                                Square.setText(Html.fromHtml("x" + "<sup><small>3</small></sup>"));
                                show.setText("Shift hyp");
                            } else {
                                sin.setText("asin");
                                cos.setText("acos");
                                tan.setText("atan");
                                Square.setText(Html.fromHtml("x" + "<sup><small>3</small></sup>"));
                                show.setText("Shift");
                            }
                        }
                        else {
                            if (hypFlag) {
                                sin.setText("sinh");
                                cos.setText("cosh");
                                tan.setText("tanh");
                                Square.setText(Html.fromHtml("x" + "<sup><small>2</small></sup>"));
                                show.setText("      hyp");
                            } else {
                                sin.setText("sin");
                                cos.setText("cos");
                                tan.setText("tan");
                                Square.setText(Html.fromHtml("x" + "<sup><small>2</small></sup>"));
                                show.setText("");
                            }
                        }
                    }
                }
        );
        hyp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        hypFlag=!hypFlag;
                        if(count%2!=0) {
                            if (hypFlag) {
                                sin.setText("asinh");
                                cos.setText("acosh");
                                tan.setText("atanh");
                                Square.setText(Html.fromHtml("x" + "<sup><small>3</small></sup>"));
                                show.setText("Shift hyp");
                            } else {
                                sin.setText("asin");
                                cos.setText("acos");
                                tan.setText("atan");
                                Square.setText(Html.fromHtml("x" + "<sup><small>3</small></sup>"));
                                show.setText("Shift");
                            }
                        }
                        else {
                            if (hypFlag) {
                                sin.setText("sinh");
                                cos.setText("cosh");
                                tan.setText("tanh");
                                Square.setText(Html.fromHtml("x" + "<sup><small>2</small></sup>"));
                                show.setText("      hyp");
                            } else {
                                sin.setText("sin");
                                cos.setText("cos");
                                tan.setText("tan");
                                Square.setText(Html.fromHtml("x" + "<sup><small>2</small></sup>"));
                                show.setText("");
                            }
                        }
                    }
                }
        );
        pi.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        insertMiddle("\u03C0");
                    }
                }
        );
        e.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        insertMiddle("e");
                    }
                }
        );
        sd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String input = ansDisplay.getText().toString();
                        double ans = Double.parseDouble(input);
                        long num =(long) (ans*10000);
                        long den = 10000;
                        long factor = gcd( num , den );
                        num = num / factor ;
                        den = den / factor ;
                        ansDisplay.setText(num+"/"+den);
                    }
                }
        );
        equalTo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int end = 0;
                        char[] operator = new char[20];
                        char check;
                        String input = display.getText().toString();
                        input = input.replaceAll("\\s", "");

                        input = input.replaceAll("asinh", "a");
                        input = input.replaceAll("acosh", "b");
                        input = input.replaceAll("atanh", "d");

                        input = input.replaceAll("sinh", "f");
                        input = input.replaceAll("cosh", "g");
                        input = input.replaceAll("tanh", "h");

                        input = input.replaceAll("asin", "x");
                        input = input.replaceAll("acos", "y");
                        input = input.replaceAll("atan", "z");

                        input = input.replaceAll("sin", "s");
                        input = input.replaceAll("cos", "c");
                        input = input.replaceAll("tan", "t");

                        input = input.replaceAll("\u03C0", String.valueOf(Math.PI));
                        input = input.replaceAll("e", String.valueOf(Math.E));

                        input = input.replaceAll("\u221a", "r");
                        input = input.replaceAll("log", "l");
                        input = input.replaceAll("ln", "e");

                        input = input.replaceAll("Ans", String.valueOf(answer));
                        // input = input.replaceAll("-+", "-");
                        // input = input.replaceAll("--", "+");
                        // input=input.replaceAll("+-","-");
                        // input=input.replaceAll("++","+");
            /*
                      For Ans Button(Not Completed yet) :
                        input=input.replaceAll("Ans","("+ansDisplay.getText().toString()+")");
                        display.setText(input);
                        display.setSelection(input.length());
             */
                        try {
                            String finalString = "";
                            for (int i = 0; i < input.length(); i++) {
                                check = input.charAt(i);
                                if ((check >= '0' && check <= '9') || check == '.') {
                                    finalString += check;
                                } else if (check == '(') {
                                    if (isOperator(input.charAt(i + 1)))
                                        finalString += "0";
                                    operator[++end] = check;
                                    finalString += " ";
                                } else if (check == ')') {
                                    while (operator[end] != '(') {
                                        finalString += " " + operator[end];
                                        end--;
                                    }
                                    end--;
                                } else {
                                    if (isTopHigh(check, operator[end])) {
                                        finalString += " " + operator[end--];
                                    }
                                    operator[++end] = check;
                                    finalString += " ";
                                }
                            }
                            while (end >= 0) {
                                finalString += " " + operator[end--];
                            }

                            //Till now expression is converted into postfix form

                            double[] stack1 = new double[20];
                            end = -1;
                            double num1, num2;
                            String n;
                            String a = finalString;
                            for (int i = 0; i < a.length(); i++) {
                                if ((a.charAt(i) >= '0' && a.charAt(i) <= '9') || a.charAt(i) == '.') {
                                    n = "";
                                    while (a.charAt(i) != ' ') {
                                        n += a.charAt(i);
                                        i++;
                                    }
                                    stack1[++end] = Double.parseDouble(n);
                                } else if (isFunction(a.charAt(i))) {
                                    num1 = stack1[end--];
                                    stack1[++end] = oper(num1, a.charAt(i));
                                } else if (isOperator(a.charAt(i))) {
                                    num1 = stack1[end--];
                                    if (end >= 0)
                                        num2 = stack1[end--];
                                    else
                                        num2 = 0;
                                    stack1[++end] = oper(num2, num1, a.charAt(i));
                                }
                            }
                            answer = stack1[end];
                            finalString = String.valueOf(stack1[end]);
                            ansDisplay.setText(finalString);
                            if (finalString == "Infinity")
                                ansDisplay.setText("\u221E");
                            if (finalString == "NaN")
                                ansDisplay.setText(" Impossible !! ");
                            else if (finalString.contains("E")) {
                                String tenPower = "";
                                for (int i = finalString.indexOf("E") + 1; i < finalString.length(); i++)
                                    tenPower += finalString.charAt(i);
                                ansDisplay.setText(finalString.substring(0, finalString.indexOf("E")) + " X 10^" + tenPower);

                            }
                        }catch(StringIndexOutOfBoundsException e ){
                            ansDisplay.setText("Invalid Expression");
                            e.printStackTrace();
                        }catch (NumberFormatException e){
                            ansDisplay.setText("Invalid Expression");
                            e.printStackTrace();
                        }catch (ArrayIndexOutOfBoundsException e){
                            ansDisplay.setText("Invalid Expression");
                            e.printStackTrace();
                        }
                    }
                }
        );
        del.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String input = display.getText().toString();
                        int location = display.getSelectionStart();
                        if (location > 0) {
                            display.setText(input.substring(0, location - 1) + input.substring(location, input.length()));
                            display.setSelection(location - 1);
                        } else
                            display.setText(input);
                        ansDisplay.setText("");
                    }
                }
        );
        ac.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        display.setText("");
                        ansDisplay.setText("");
                    }
                }
        );
        ans.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        insertMiddle("(Ans)");
                    }
                }
        );
        tenPow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                           insertMiddle("X10^");
                    }
                }
        );
    }

}


package com.example.da08.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txt;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    Button btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
    String str;
    Integer res;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt = (TextView) findViewById(R.id.txt);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn10 = (Button) findViewById(R.id.btn10);
        btn11 = (Button) findViewById(R.id.btn11);
        btn12 = (Button) findViewById(R.id.btn12);
        btn13 = (Button) findViewById(R.id.btn13);
        btn14 = (Button) findViewById(R.id.btn14);
        btn15 = (Button) findViewById(R.id.btn15);
        btn16 = (Button) findViewById(R.id.btn16);


        txt.setText("");
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1 :
                txt.setText("1");
                break;
            case R.id.btn2 :
                txt.setText("2");
                break;
            case R.id.btn3 :
                txt.setText("3");
                break;
            case R.id.btn4 :
                txt.setText("+");
                break;
            case R.id.btn5 :
                txt.setText("4");
                break;
            case R.id.btn6 :
                txt.setText("5");
                break;
            case R.id.btn7 :
                txt.setText("6");
                break;
            case R.id.btn8 :
                txt.setText("-");
                break;
            case R.id.btn9 :
                txt.setText("7");
                break;
            case R.id.btn10 :
                txt.setText("8");
                break;
            case R.id.btn11 :
                txt.setText("9");
                break;
            case R.id.btn12 :
                txt.setText("*");
                break;
            case R.id.btn13 :
                txt.setText("");
                break;
            case R.id.btn14 :
                txt.setText("0");
                break;
            case R.id.btn15 :
                txt.setText("");
                Toast.makeText(this, "계산이 완료되었습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn16 :
                txt.setText("/");
                break;
        }

    }




}

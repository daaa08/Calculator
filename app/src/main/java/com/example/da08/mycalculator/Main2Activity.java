package com.example.da08.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    TextView txtres, preView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btn10).setOnClickListener(this);
        findViewById(R.id.btn11).setOnClickListener(this);
        findViewById(R.id.btn12).setOnClickListener(this);
        findViewById(R.id.btn13).setOnClickListener(this);
        findViewById(R.id.btn14).setOnClickListener(this);
        findViewById(R.id.btn15).setOnClickListener(this);
        findViewById(R.id.btn16).setOnClickListener(this);

        txtres = (TextView) findViewById(R.id.txtres);
        preView = (TextView) findViewById(R.id.preView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1 : setPreView(1); break;
            case R.id.btn2 : setPreView(2); break;
            case R.id.btn3 : setPreView(3); break;
            case R.id.btn4 :  //+
                setPreView("+"); break;
            case R.id.btn5 : setPreView(4); break;
            case R.id.btn6 : setPreView(5); break;
            case R.id.btn7 : setPreView(6); break;
            case R.id.btn8 :  // -
                setPreView("-");
                break;
            case R.id.btn9 : setPreView(7); break;
            case R.id.btn10 : setPreView(8); break;
            case R.id.btn11 : setPreView(9); break;
            case R.id.btn12 :   // *
                setPreView("*");
                break;
            case R.id.btn13 :  // c
                clear();
                break;
            case R.id.btn14 : setPreView(7); break;
            case R.id.btn15 :  // =
                result();
                break;
            case R.id.btn16 : // /
                setPreView("/"); break;
        }

    }

    private void result(){
        String current = preView.getText().toString();
        preView.setText(calculate(current));

    }
    private String calculate(String preview){
        String res = "";
        // 1.문자열을 정규식으로 +=*/을 이용해서 배열로 자른다
        String splited[] = preview.split("(?<=[*/+-])|(?=[*/+-])");
        /* ex 123 * 45 +67 / 89
        * 결과값 : splited[0] = 123
        *       splited[1] = *
        *       splited[2] = 45
        *       splited[3] = +
        *       splited[4] = 67
        *       splited[5] = /
        *       splited[6] = 89
         */
        // 배열을 중간에 삭제하기 위해서 컬렉션을 사용한다

        ArrayList<String > list = new ArrayList<>();
        for(String temp : splited){
            list.add(temp);
        }

        // 반복문이 split을 돌면서 * /먼저 연산

        for( int i = 0 ;  i < list.size() ; i++ ){
            String temp = list.get(i);
            int restemp = 0;
            if(temp.equals("*") || temp.equals("/")){
             int before = Integer.parseInt(list.get(i-1));
              int after = Integer.parseInt(list.get(i+1));
                if(temp.equals("*"))
                    restemp = before * after;
                else
                    restemp = before / after;

                // 결과값 저장
                list.set(i, restemp+"");
                list.remove(i+1);
                list.remove(i-1);
                i--;
            }
        }

        // 반복문이 splitted 을 돌면서 + 와 - 만 먼저 연산해준다
        for(int i=0; i<list.size() ; i++){
            String temp = list.get(i);
            int restemp = 0;
            if(temp.equals("+") || temp.equals("-")){
                int before = Integer.parseInt(list.get(i-1));
                int after = Integer.parseInt(list.get(i+1));
                if(temp.equals("+"))
                    restemp = before + after;
                else
                    restemp = before - after;
                // 결과값 저장
                list.set(i, restemp+"");
                // 필요없는 배열 뒤, 앞 두개 삭제
                list.remove(i+1);
                list.remove(i-1);
                i--;
            }
           // log에러 표시 해 줌 (하단의 안드로이드 모니터에)
            Log.w("MainActivity","i"+i+",value i="+list.get(i)+",value i+i="+list.get(i+1));

        }

        return list.get(0);
    }

    private void setPreView(int number){  // 중복된것들 함수로 만들어줌
        String current = preView.getText().toString();
        preView.setText(current + number);
    }

    private void setPreView(String str){   // +,-...등 보여줄것들
        String current = preView.getText().toString();
        preView.setText(current + str);
    }

    private  void clear(){
        preView.setText("0");
        txtres.setText("0");
    }
}

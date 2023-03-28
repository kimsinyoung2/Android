package com.example.practice01;

import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText Edit1,Edit2;
    Button  btn11, btn12, btn13, btn14;
    TextView textResult;
    String num1, num2;
    Integer result;

    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = { R.id.Btn0, R.id.Btn1, R.id.Btn2,
            R.id.Btn3, R.id.Btn4, R.id.Btn5, R.id.Btn6,
            R.id.Btn7, R.id.Btn8, R.id.Btn9 };
    int i;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        Edit1 = (EditText) findViewById(R.id.Edit1);
        Edit2 = (EditText) findViewById(R.id.Edit2);

        btn11 = (Button) findViewById(R.id.Btn11);
        btn12 = (Button) findViewById(R.id.Btn12);
        btn13 = (Button) findViewById(R.id.Btn13);
        btn14 = (Button) findViewById(R.id.Btn14);

        textResult = (TextView) findViewById(R.id.Result);

        btn11.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btn12.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btn13.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btn14.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });



        for (i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }
        for (i = 0; i < numBtnIDs.length; i++) {

            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (Edit1.isFocused() == true) {
                        num1 = Edit1.getText().toString()
                                + numButtons[index].getText().toString();
                        Edit1.setText(num1);
                    } else if (Edit2.isFocused() == true) {
                        num2 = Edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        Edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "먼저 에디트텍스트를 선택하세요",Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }

    }

}
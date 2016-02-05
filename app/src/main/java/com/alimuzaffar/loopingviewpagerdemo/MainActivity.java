package com.alimuzaffar.loopingviewpagerdemo;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(this);

        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);

        mButton3 = (Button) findViewById(R.id.button3);
        mButton3.setOnClickListener(this);

        mButton4 = (Button) findViewById(R.id.button4);
        mButton4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = null;
        if (v == mButton1) {
            intent = new Intent(this, InitialApproachActivity.class);
        } else if (v == mButton2) {
            intent = new Intent(this, SecondApproachActivity.class);
        } else if (v == mButton3) {
            intent = new Intent(this, ThirdApproachActivity.class);
        } else if (v == mButton4) {
            intent = new Intent(this, DiyApproachActivity.class);
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}

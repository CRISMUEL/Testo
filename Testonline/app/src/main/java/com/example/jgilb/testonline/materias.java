package com.example.jgilb.testonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class materias extends AppCompatActivity {

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);

        radio1 = findViewById(R.id.rdb1);
        radio2 = findViewById(R.id.rdb2);
        radio3 = findViewById(R.id.rdb3);
        radio4 = findViewById(R.id.rdb4);

    }

    public void radio1(View view) {

        if(radio1.isClickable()){
            Intent i = new Intent(this, language.class);
            startActivity(i);
        }
    }

    public void radio2(View view) {

        if(radio2.isClickable()){
            Intent i = new Intent(this, maths.class);
            startActivity(i);
        }
    }

    public void radio3(View view) {

        if(radio3.isClickable()){
            Intent i = new Intent(this, social.class);
            startActivity(i);
        }
    }

    public void radio4(View view) {

        if(radio4.isClickable()){
            Intent i = new Intent(this, nature.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            Toast.makeText(getApplicationContext(), "No puede regresar, realice un examen", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

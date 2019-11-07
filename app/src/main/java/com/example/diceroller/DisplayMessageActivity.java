package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DisplayMessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void on_button_click (View view) {
        DisplayMessageActivity.this.finish();

    }

    public void save_click(View view) {
       EditText editText2 = (EditText) findViewById(R.id.editText2);
        Intent resultIntent = new Intent();
        String result = editText2.getText().toString();
        MainActivity ma = new MainActivity();
        ma.question.add(result);
        setResult(RESULT_OK, resultIntent);
        finish();


    }
}

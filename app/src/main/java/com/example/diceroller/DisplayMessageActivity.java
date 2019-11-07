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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void save_click(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String message = editText2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

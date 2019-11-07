package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.TextureView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    static int count = 0;
    static int score = 0;
    public static final String EXTRA_MESSAGE  = "";
    static ArrayList<String> question = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        question.add("Q1. If you could go anywhere in the world, where would you go?");
        question.add("Q2. If you were stranded on a desert island, what three things would you want to take with you?");
        question.add("Q3. If you could eat only one food for the rest of your life, what would that be?");
        question.add("Q4. If you won a million dollars, what is the first thing you would buy?");
        question.add("Q5. If you could spaned the day with one fictional character, who would it be?");
        question.add("Q6. If you found a magic lantern and a genie gave you three wishes, what would you wish?");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_button_click (View view) {
        TextView tv = this.findViewById(R.id.textView);
        EditText num_input = this.findViewById(R.id.editText);
        TextView tv2 = this.findViewById(R.id.textView2);
        TextView tv3 = this.findViewById(R.id.textView3);

        String input_number = num_input.getText().toString();
        if(input_number.matches("")) {
            tv.setText("Please input a number");
            return;
        }

        Random r = new Random();
        int num = r.nextInt(6) + 1;
        count = count + 1;

        tv.setText("The random number is " + Integer.toString(num));
        tv2.setText("You guess " + count + " times");

        int input = Integer.valueOf(num_input.getText().toString());
        if(input == num)
        {
            tv.setText("Congratulations! You guess correct.");
            score = score + 1;
            tv3.setText("Score: " + score);
            count = 0;
        }
    }

    public void roll_the_dice (View view) {
        TextView tv = this.findViewById(R.id.textView);
        Random r = new Random();

        int num = r.nextInt(question.size());

        String Q = question.get(num);
        tv.setText(Q);

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivityForResult(intent,1);
    }

    public void onclick_finish(View view) {
        Intent intent = new Intent(this, Score_on_slack.class);
        String message = String.valueOf(score);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}
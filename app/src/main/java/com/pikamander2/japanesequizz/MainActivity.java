package com.pikamander2.japanesequizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_QUIZ_ID = "com.example.myfirstapp.MODE_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupListeners();
    }


    private void setupListeners() {
        Button buttonHiragana = findViewById(R.id.buttonHiragana);
        Button buttonKatakana = findViewById(R.id.buttonKatakana);
        Button buttonMixture =  findViewById(R.id.buttonMixture);

        buttonHiragana.setOnClickListener(hiraganaButtonPressed);

        buttonKatakana.setOnClickListener(katakanaButtonPressed);

        buttonMixture.setOnClickListener(mixtureButtonPressed);
    }

    public View.OnClickListener hiraganaButtonPressed = new View.OnClickListener() {
        public void onClick(View view) {
            switchActivity(view, 1);
        }
    };

    public View.OnClickListener katakanaButtonPressed = new View.OnClickListener() {
        public void onClick(View view) {
            switchActivity(view, 2);
        }
    };

    public View.OnClickListener mixtureButtonPressed = new View.OnClickListener() {
        public void onClick(View view) {
            switchActivity(view, 4);
        }
    };

    public void switchActivity(View view, int quizID) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra(EXTRA_QUIZ_ID, quizID);
        startActivity(intent);
    }

    public void mixtureButtonPressed(View view) {
        switchActivity(view, 4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            //intent.putExtra(EXTRA_QUIZ_ID);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

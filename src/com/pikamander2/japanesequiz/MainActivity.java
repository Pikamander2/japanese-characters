package com.pikamander2.japanesequiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.pikamander2.japanesequiz.R;

public class MainActivity extends Activity 
{
	public final static String EXTRA_QUIZ_ID = "com.example.myfirstapp.MODE_ID";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setupListeners();
    }

    
    private void setupListeners()
    {
    	Button buttonHiragana = (Button)findViewById(R.id.buttonHiragana);
    	Button buttonKatakana = (Button)findViewById(R.id.buttonKatakana);
    	Button buttonMixture = (Button)findViewById(R.id.buttonMixture);
    	
    	buttonHiragana.setOnClickListener(hiraganaButtonPressed);
    	
    	buttonKatakana.setOnClickListener(katakanaButtonPressed);
    	
    	buttonMixture.setOnClickListener(mixtureButtonPressed);
    }
    
	public OnClickListener hiraganaButtonPressed = new OnClickListener() 
	{
	    public void onClick(View view) 
	    {
	    	switchActivity(view, 1);
	    }
	};
	
	public OnClickListener katakanaButtonPressed = new OnClickListener() 
	{
	    public void onClick(View view) 
	    {
	    	switchActivity(view, 2);
	    }
	};
	
	public OnClickListener mixtureButtonPressed = new OnClickListener() 
	{
	    public void onClick(View view) 
	    {
	    	switchActivity(view, 4);
	    }
	};
	
    
    public void switchActivity(View view, int quizID)
    {
    	Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra(EXTRA_QUIZ_ID, quizID);
        startActivity(intent);
    }
    
    public void mixtureButtonPressed(View view)
    {
    	switchActivity(view, 4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        int id = item.getItemId();
        
        if (id == R.id.action_settings) {
            return true;
        }
   
        return super.onOptionsItemSelected(item);
    }
}

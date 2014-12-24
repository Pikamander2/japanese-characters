package com.pikamander2.testhelloworldapp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Random;

public class QuizActivity extends Activity 
{
	Random random = new Random();
	TextView textViewRomaji;
	TextView textViewScore;
	GridView gridViewQuestions;
	String currentAnswer = "";
	String currentQuestion = "";
	int numCorrect = 0;
	Question question;
	QuestionAdapter questionAdapter;
	Intent intent;
	int quizID;
	int numAnswerChoices = 4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		intent = getIntent();
		
		quizID = intent.getIntExtra("com.example.myfirstapp.MODE_ID", 1);
		question = new Question(quizID);
		
		questionAdapter = new QuestionAdapter(this, question);
		
		textViewRomaji = (TextView)findViewById(R.id.textViewRomaji);
		
		textViewScore = (TextView)findViewById(R.id.textViewScore);
		
		gridViewQuestions = (GridView)findViewById(R.id.gridViewQuestions);
		
		updateScore();
		
		for (int i = 0; i < questionAdapter.buttons.size(); i++)
		{
			((Button)questionAdapter.getItem(i)).setOnClickListener(mCorkyListener);
		}
		
		gridViewQuestions.setAdapter(questionAdapter);

		switchQuestion();
	}
	
	public OnClickListener mCorkyListener = new OnClickListener() 
	{
	    public void onClick(View v) 
	    {
	    	guess(v);
	    	switchQuestion();
	    	questionAdapter.changeAnswers();
	    	questionAdapter.notifyDataSetChanged();
	    }
	};
	
	public void guess(View view)
	{
		Button tempButton = (Button)view;
		
		if (tempButton.getText().equals(currentAnswer))
		{
			numCorrect++;
			updateScore();
		}
		
		switchQuestion();
	}
	
	public void updateScore()
	{
		textViewScore.setText("Score: " + numCorrect);
	}
	
	public void switchQuestion()
	{
		question.shuffleQuestions();
		int randNum = random.nextInt(4);
		
		currentQuestion = question.getQuestion(randNum);
		currentAnswer = question.getAnswer(randNum);
		textViewRomaji.setText(currentQuestion);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) 
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

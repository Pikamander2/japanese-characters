package com.pikamander2.testhelloworldapp1;

import java.util.ArrayList;
import java.util.Random;

import com.pikamander2.japanesequiz.R;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class QuestionAdapter extends BaseAdapter 
{
    private QuizActivity mContext;
    
    public ArrayList<String> choices = new ArrayList<String>();
    public ArrayList<Button> buttons = new ArrayList<Button>();
    
    public Random random = new Random();
    public static Question question;

    public QuestionAdapter(Context c, Question q) 
    {
        mContext = (QuizActivity)c;
        question = q;
    }
    
    public void changeAnswers(boolean romajiFirst)
    {
    	if (romajiFirst)
    	{
        	buttons.get(0).setText(question.getAnswer(0, romajiFirst));
        	buttons.get(1).setText(question.getAnswer(1, romajiFirst));
        	buttons.get(2).setText(question.getAnswer(2, romajiFirst));
        	buttons.get(3).setText(question.getAnswer(3, romajiFirst));
    	}
    	
    	else
    	{
        	buttons.get(0).setText(question.getAnswer(0, romajiFirst));
        	buttons.get(1).setText(question.getAnswer(1, romajiFirst));
        	buttons.get(2).setText(question.getAnswer(2, romajiFirst));
        	buttons.get(3).setText(question.getAnswer(3, romajiFirst));
    	}

    }

    public void makeButtons()
    {
    	for (int i = 0; i < 4; i++)
    	{
            Button newButton = new Button(mContext);
            newButton.setOnClickListener(mContext.answerOnClick);
            buttons.add(newButton);
            newButton.setTextSize(TypedValue.COMPLEX_UNIT_SP,mContext.getResources().getDimension(R.dimen.button_font_size));
            newButton.setText(question.getAnswer(i, true));
            newButton.setTextColor(Color.rgb(255,255,255));
    	}
    }
    
    public int getCount() 
    {
        return 4;
    }

    public Object getItem(int position) 
    {
        return null;
    }

    public long getItemId(int position) 
    {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) 
    {
    	if (buttons.size() == 0)
    	{
    		makeButtons();
    	}
    	
        return buttons.get(position);
    }
}
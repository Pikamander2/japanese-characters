package com.pikamander2.japanesequiz;

import java.util.ArrayList;
import java.util.Collections;
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
		buttons.get(0).setText(question.getRandomAnswer(romajiFirst));
		buttons.get(1).setText(question.getRandomAnswer(romajiFirst));
		buttons.get(2).setText(question.getRandomAnswer(romajiFirst));
		buttons.get(3).setText(question.getRandomAnswer(romajiFirst));

		buttons.get(random.nextInt(4)).setText(question.getCurrentAnswer(romajiFirst));
    }

    public void makeButtons()
    {
    	for (int i = 0; i < 4; i++)
    	{
            Button newButton = new Button(mContext);
            newButton.setOnClickListener(mContext.answerOnClick);
            buttons.add(newButton);
            newButton.setTextSize(TypedValue.COMPLEX_UNIT_SP,mContext.getResources().getDimension(R.dimen.button_font_size));
            newButton.setTextColor(Color.rgb(255,255,255));
    	}

			changeAnswers(true);
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
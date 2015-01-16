package com.pikamander2.japanesequiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Question
{	
	private Random random = new Random();

	private int currentAnswer;

	private ArrayList<String[]> listToUse;

	private int listId;
	
	private boolean romajiFirst = true;

	private static ArrayList<String[]> plainHiragana = new ArrayList<String[]>(Arrays.asList(new String[][]{{"あ", "a"},{"い", "i"},{"う", "u"},{"え", "e"},{"お", "o"},
			{"か", "ka"},{"き", "ki"},{"く", "ku"},{"け", "ke"},{"こ", "ko"},
			{"さ", "sa"},{"し", "shi"},{"す", "su"},{"せ", "se"},{"そ", "so"},
			{"た", "ta"},{"ち", "chi"},{"つ", "tsu"},{"て", "te"},{"と", "to"},
			{"な", "na"},{"に", "ni"},{"ぬ", "nu"},{"ね", "ne"},{"の", "no"},
			{"は", "ha"},{"ひ", "hi"},{"ふ", "fu"},{"へ", "he"},{"ほ", "ho"},
			{"ま", "ma"},{"み", "mi"},{"む", "mu"},{"め", "me"},{"も", "mo"},
			{"や", "ya"},{"ゆ", "yu"},{"よ", "yo"},
			{"ら", "ra"},{"り", "ri"},{"る", "ru"},{"れ", "re"},{"ろ", "ro"},
			{"わ", "wa"},{"を", "wo"},
			{"ん", "n"}}));
			
	private static ArrayList<String[]> dakutenHiragana = new ArrayList<String[]>(Arrays.asList(new String[][]{
			{"が", "ga"},{"ぎ", "gi"},{"ぐ", "gu"},{"げ", "ge"},{"ご", "go"},
			{"ざ", "za"},{"じ", "ji"},{"ず", "zu"},{"ぜ", "ze"},{"ぞ", "zo"},
			{"だ", "da"},{"ぢ", "ji"},{"づ", "zu"},{"で", "de"},{"ど", "do"},
			{"ば", "ba"},{"び", "bi"},{"ぶ", "bu"},{"べ", "be"},{"ぼ", "bo"},
			{"ぱ", "pa"},{"ぴ", "pi"},{"ぷ", "pu"},{"ぺ", "pe"},{"ぽ", "po"}
			}));

	private static ArrayList<String[]> plainKatakana = new ArrayList<String[]>(Arrays.asList(new String[][]{{"ア", "a"},{"イ", "i"},{"ウ", "u"},{"エ", "e"},{"オ", "o"},
			{"カ", "ka"},{"キ", "ki"},{"ク", "ku"},{"ケ", "ke"},{"コ", "ko"},
			{"サ", "sa"},{"シ", "shi"},{"ス", "su"},{"セ", "se"},{"ソ", "so"},
			{"タ", "ta"},{"チ", "chi"},{"ツ", "tsu"},{"テ", "te"},{"ト", "to"},
			{"ナ", "na"},{"ニ", "ni"},{"ヌ", "nu"},{"ネ", "ne"},{"ノ", "no"},
			{"ハ", "ha"},{"ヒ", "hi"},{"フ", "fu"},{"ヘ", "he"},{"ホ", "ho"},
			{"マ", "ma"},{"ミ", "mi"},{"ム", "mu"},{"メ", "me"},{"モ", "mo"},
			{"ヤ", "ya"},{"ユ", "yu"},{"ヨ", "yo"},
			{"ラ", "ra"},{"リ", "ri"},{"ル", "ru"},{"レ", "re"},{"ロ", "ro"},
			{"ワ", "wa"},{"ヲ", "wo"},
			{"ン", "n"}
			}));
	
	private static ArrayList<String[]> dakutenKatakana = new ArrayList<String[]>(Arrays.asList(new String[][]{
			{"ガ", "ga"},{"ギ", "gi"},{"グ", "gu"},{"ゲ", "ge"},{"ゴ", "go"},
			{"ザ", "za"},{"ジ", "ji"},{"ズ", "zu"},{"ゼ", "ze"},{"ゾ", "zo"},
			{"ダ", "da"},{"ヂ", "ji"},{"ヅ", "zu"},{"デ", "de"},{"ド", "do"},
			{"バ", "ba"},{"ビ", "bi"},{"ブ", "bu"},{"ベ", "be"},{"ボ", "bo"},
			{"パ", "pa"},{"ピ", "pi"},{"プ", "pu"},{"ペ", "pe"},{"ポ", "po"}
			}));

	public Question(int tempListId)
	{
		listId = tempListId;
		setList(tempListId);
	}

	public void switchRomajiFirst()
	{
		romajiFirst = !romajiFirst;
	}
	
    public void shuffleQuestions()
	{
		setList(listId);

		Collections.shuffle(listToUse);
	}
	
	public void setList(int tempListId)
	{
		int randNum;
		
		if (tempListId == 4)
		{
			tempListId = random.nextInt(2) + 1;
		}

		switch(tempListId)
		{
			case 1: //Hiragana
				randNum = random.nextInt(plainHiragana.size() + dakutenHiragana.size());
				
				if (randNum < plainHiragana.size())
				{
					listToUse = plainHiragana;
				}
				
				else
				{
					listToUse = dakutenHiragana;
				}
				
				break;
			case 2: //Katakana
				randNum = random.nextInt(plainKatakana.size() + dakutenKatakana.size());
				
				if (randNum < plainKatakana.size())
				{
					listToUse = plainKatakana;
				}
				
				else
				{
					listToUse = dakutenKatakana;
				}
				
				break;
		}
	}

	public String getAnswer(int charID)
	{
		return listToUse.get(charID)[romajiFirst ? 0 : 1];
	}

	public void setCurrentAnswer(int answer)
	{
		this.currentAnswer = answer;
	}

	public String getCurrentAnswer()
	{
		return listToUse.get(currentAnswer)[romajiFirst ? 0 : 1];
	}

	public String getQuestion(int charID)
	{
		return listToUse.get(charID)[romajiFirst ? 1 : 0];
	}

	public ArrayList<String[]> getUsedList()
	{
		return listToUse;
	}
}
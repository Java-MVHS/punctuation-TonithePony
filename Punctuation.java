//Yutong Chen
//12-13-24
//Punctuation.java
/*
 *
 */
public class Punctuation
{
	public static void main(String[] args)
	{
		Punctuation pct = new Punctuation();
		pct.searchIt();
	}
	public void searchIt()
	{
		String str = "Blood, Sweat, and Tears by Winston Churchill " +
			"May 13, 1940" + 
			"Mr. Speaker:" + 
			"On Friday evening last I received His Majesty’s commission to form a new " +
			"Administration. It was the evident wish and will of Parliament and the " + 
			"nation that this should be conceived on the broadest possible basis and that it should " +
			"include all parties, both those who supported the late Government and also the " + 
			"parties of the Opposition." +
			"\nI have completed the most important part of this task. A War Cabinet has " + 
			"been formed of five Members, representing, with the Liberal Opposition, the unity of the " + 
			"nation. The three party Leaders have agreed to serve, either in the War Cabinet or in "+ 
			"high executive office. The three Fighting Services have been filled. It was necessary " + 
			"that this should be done in one single day, on account of the extreme urgency and " + 
			"rigour of events. A number of other key positions were filled yesterday, and I am " + 
			"submitting a further list to His Majesty tonight. I hope to complete the appointment of the " + 
			"principal Ministers during tomorrow. The appointment of the other Ministers usually " + 
			"takes a little longer, but I trust that, when Parliament meets again, this part of my task " +
			"will be completed, and that the Administration will be complete in all respects." +
			"Sir, I considered it in the public interest to suggest that the House should " + 
			"be summoned to meet today. Mr. Speaker agreed and took the necessary steps, in " +
			"accordance with the powers conferred upon him by the Resolution of the House. At the " + 
			"end of the proceedings today, the Adjournment of the House will be proposed until " +
			"Tuesday, the 21st May, with, of course, provision for earlier meeting, if need be. The " +
			"business to be considered during that week will be notified to Members at the earliest " +
			"opportunity. I now invite the House, by the Resolution which stands in my name, to "+
			"record its approval of the steps taken and to declare its confidence in the new Government." + 
			"Sir, to form an Administration of this scale and complexity is a serious " +
			"undertaking in itself, but it must be remembered that we are in the preliminary stage of " +
			"one of the greatest battles in history, that we are in action at many points in Norway and " +
			"in Holland, that we have to be prepared in the Mediterranean, that the air battle is " + 
			"continuous and that many preparations have to be made here at home. In this crisis I " + 
			"hope I may be pardoned if I do not address the House at any length today. I hope that " +
			"any of my friends and colleagues, or former colleagues, who are affected by the political " + 
			"reconstruction, will make all allowances for any lack of ceremony with which it has been " + 
			"necessary to act. I would say to the House, as I said to those who’ve joined this " + 
			"government: \"I have nothing to offer but blood, toil, tears and sweat.\"" + 
			"We have before us an ordeal of the most grievous kind. We have before " + 
			"us many, many long months of struggle and of suffering. You ask, what is our policy? I " + 
			"will say: It is to wage war, by sea, land and air, with all our might and with all the " + 
			"strength that God can give us; to wage war against a monstrous tyranny, never " +
			"surpassed in the dark and lamentable catalogue of human crime. That is our policy. You " + 
			"ask, what is our aim? I can answer in one word: victory. Victory at all costs, victory in " + 
			"spite of all terror, victory, however long and hard the road may be; for without victory, " + 
			"there is no survival. Let that be realised; no survival for the British Empire, no survival " + 
			"for all that the British Empire has stood for, no survival for the urge and impulse of the " + 
			"ages, that mankind will move forward towards its goal. " +
			"But I take up my task with buoyancy and hope. I feel sure that our cause " + 
			"will not be suffered to fail among men. At this time I feel entitled to claim the aid of all, " + 
			"and I say, \"Come then, let us go forward together with our united strength.\" ";

		int firstIndex = 0;
		int spaceIndex = 1;
		String word = new String("");
		while(firstIndex < str.length()-1)
		{
			spaceIndex = getPunctuationWords(str, firstIndex);
			firstIndex = str.lastIndexOf(' ', spaceIndex-1)+1;
			word = str.substring(firstIndex, spaceIndex);
			//System.out.println("Debug: firstIndex is "+ firstIndex);
			firstIndex = spaceIndex + 1;	
			
			//System.out.println("Debug: spaceIndex is "+ spaceIndex);
			printWords(word);
		}
	}
	public int getPunctuationWords(String strIn, int firstIndexIn)
	{
		int spaceIndexIn = firstIndexIn + 1;
		spaceIndexIn = strIn.indexOf(' ', spaceIndexIn);
		//if has no punctuation, recursion, run getPunctuationWords(strIn, spaceIndexIn+ 1)
		if(checkForPunctuation(strIn.substring(firstIndexIn, spaceIndexIn)))
		{
			return spaceIndexIn;
		}else
		{
			return (getPunctuationWords(strIn, spaceIndexIn+ 1));
		}
		//else, it has punctuation, return spaceIndexIn;
		//return spaceIndexIn;
	}
	public boolean checkForPunctuation(String word)
	{
		boolean hasPunct = false;
		hasPunct = (word.indexOf(',')>-1)||(word.indexOf('.')>-1)||(word.indexOf('!')>-1);
		hasPunct = hasPunct||(word.indexOf('?')>-1)||(word.indexOf('\'')>-1)||(word.indexOf('\"')>-1);
		return hasPunct;
	}
	public void printWords(String wordIn)
	{
		System.out.println(wordIn);
	}
}

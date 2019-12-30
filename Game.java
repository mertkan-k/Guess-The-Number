package game;

import java.util.Random;
import java.util.Vector;

public class Game {
	
	protected final int defaultLen = 3;
	
	private boolean isCompleted;
	private String number;
	private int estimateCount;
	
	public int getEstimateCount() {return estimateCount;}
	public boolean IsCompleted() {return isCompleted;}
	
	Game(int maxLen){
		number = "";
		
		if (maxLen < 1 || maxLen > 10) {
			System.out.printf("Invalid maxLen: %d! Standard value used(%d)\n", maxLen, defaultLen);
			maxLen = defaultLen;
		}
		
		Random r = new Random();
		int i = 0;
		while (i < maxLen) {
			int v = r.nextInt(10);
			if (number.indexOf(Integer.toString(v)) < 0) {
				number += Integer.toString(v);
				i++;
			}
		}
		
	}
	
	public String Guess(String s) {
		if (IsCompleted()) {
			return "Game already completed!";
		}
		
		if (s.length() != number.length()) {
			return "Invalid guess!";
		}
		
		// For ignore 111 etc.
		for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)){
					return "Invalid guess!";
				}
			}
		}

		String ret = "";
		
		estimateCount++;
		
		int succesPos = 0, wrongPos = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(i) == number.charAt(j)) {
					if (i == j)
						succesPos++;
					else
						wrongPos++;
					break;
				}
			}
		}
		
		if (succesPos == s.length()) {
			isCompleted = true;
		}
		
		if (succesPos > 0) {
			ret += "+" + succesPos;
		}
		if (wrongPos > 0) {
			ret += "-" + wrongPos;
		}
		
		if (ret.length() == 0) {
			ret += "0";
		}
		
		return ret;
	}
	
}

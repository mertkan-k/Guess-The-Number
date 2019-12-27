package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		while(true)
		{
			Scanner s = new Scanner(System.in);

			System.out.print("Enter max. length for number: ");
			int n = s.nextInt();

			Game g = new Game(n);

			while (!g.IsCompleted()) {
				System.out.print("Enter your guess: ");
				String guess = s.next();

				System.out.println(guess + " -> " + g.Guess(guess));
			}

			System.out.println("Congratulations! Total estimates: " + g.getEstimateCount());

			System.out.println("Do you want to play again?(y/n)");

			if (s.next() == "n")
				break;
		}
	}

}

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int sticks = (int)(Math.random() * 10) + 21;
		System.out.println("There are " + sticks + " sticks in the pile.");
		
		System.out.println("Who do you want to go first? Type 1 to go first or 2 to go second.");
		boolean turn; //true - player turn, false - cpu turn
		if(input.nextInt() == 1) 
			turn = true;
		else 
			turn = false;
		
		
		while(sticks > 0) {
			if (turn) {
				sticks = playerMove(sticks, input);
				turn = false;
			}
			else {
				sticks = computerMove(sticks);
				turn = true;
			}
			System.out.println("There are " + sticks + " sticks left in the pile");
		}
		
		if(turn) 
			System.out.println("You lost!");
		
		else 
			System.out.println("You won!");
		
	}
	
	public static int playerMove(int sticks, Scanner input) {
		System.out.println("How many sticks do you want to take?");
		int take = input.nextInt();
		if (take > 3) 
			take = 3;
		else if(take < 1)
			take = 1;
		else if(take > sticks) {
			take = sticks;
		}
		
		System.out.println("You took " + take + " sticks.");
			
		return sticks - take;
	}
	
	public static int computerMove(int sticks) {
		int take;
		if (sticks % 4 != 0)
			take = sticks % 4;
		else
			take = (int)(Math.random() * 3) +1;
		
		System.out.println("The computer took " + take + " sticks.");
			
		return sticks - take;
	}
}

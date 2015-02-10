import java.util.Date;
import java.util.Scanner;


public class Main 
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		Inventory Games = new Inventory();
		Games.insertGame((new Item("Assassin's Creed", new Date(2004,6,21),25.00,8.0)));
		Games.insertGame((new Item("Killzone 2", new Date(2007,8,15),27.00,8.5)));
		Games.insertGame((new Item("Kingdom Hearts", new Date(2001,9,15),20.00,9.0)));
		Games.insertGame((new Item("Superman Returns", new Date(2003,2,11),2.00,1.0)));
		Games.insertGame((new Item("Call of Duty: Advanced Warfare", new Date(2014,11,11),50.00,7.5)));
		
		boolean q = false;
		char selection;
		while(q == false)
		{
			System.out.println("Choose a task: ");
			System.out.println("M - Make a sale.");
			System.out.println("S - Sell a game back.");
			System.out.println("G - Suggest a game.");
			System.out.println("F - Find a game.");
			System.out.println("Q - Quit");
			
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			selection = in.nextLine().toUpperCase().charAt(0);
			
			switch(selection)
			{
				case 'M':
					System.out.println("Which Game?");
					Item sale = Games.findGame(in.nextLine());
					if(sale != null)
					{
						System.out.println("Enter payment amount: ");
						sale.makeSale(in.nextDouble());
					}
					else
						System.out.println("Sorry, don't have that one in stock.");
					break;
				case 'S':
					System.out.println("Which Game?");
					Item sell = Games.findGame(in.nextLine());
					if(sell != null)
						System.out.println("Ok, for that game I'll give you: $" + Math.round(sell.sellBack(new Date(2015,9,2))));
					else
						System.out.println("Sorry, don't have that one in stock.");
						break;
				case 'G':
					System.out.println("My best rated Game: ");
					System.out.println(Games.suggestGame());
					System.out.println("My Cheapest Game: ");
					System.out.println(Games.findCheapestGame());
					break;
				case 'F':
					System.out.println("Which Game?");
					Item find = Games.findGame(in.nextLine());
					if(find != null)
						System.out.println("Oh yeah, I have that one. It's $" + find.price);
					else
						System.out.println("Sorry, don't have that one in stock.");
					break;
				case 'Q':
					q = true;
					break;
			}
			
		}
	}
}

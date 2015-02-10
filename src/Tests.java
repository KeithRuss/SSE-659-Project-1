import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;


public class Tests 
{
	Inventory ForTests = new Inventory();
	
	@SuppressWarnings("deprecation")
	@Test
	public void Gettertests() 
	{
		ForTests.insertGame((new Item("Assassin's Creed", new Date(2004,06,21),25.00,8.0)));
		
		assertEquals("Assassin's Creed", ForTests.getGame(0).getName());
		assertEquals(new Date(2004,06,21), ForTests.getGame(0).getReleaseDate());
		assertEquals(25.00, ForTests.getGame(0).getPrice(),0);
		assertEquals(8.0, ForTests.getGame(0).getRating(),0);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void Settertests() 
	{
		ForTests.insertGame((new Item("Assassin's Creed", new Date(2004,06,21),25.00,8.0)));
		ForTests.getGame(0).setPrice(30.00);

		assertEquals(30.00, ForTests.getGame(0).getPrice(),0);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void FindGame() 
	{
		ForTests.insertGame((new Item("Assassin's Creed", new Date(2004,6,21),25.00,8.0)));
		ForTests.insertGame((new Item("Killzone 2", new Date(2007,8,15),27.00,8.5)));

		ForTests.getGame(0).setPrice(30.00);

		assertEquals(ForTests.getGame(1).name, ForTests.findGame("Killzone 2").name);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void SuggestGame() 
	{
		ForTests.insertGame((new Item("Assassin's Creed", new Date(2004,6,21),25.00,8.0)));
		ForTests.insertGame((new Item("Killzone 2", new Date(2007,8,15),27.00,8.5)));

		ForTests.getGame(0).setPrice(30.00);

		assertEquals(ForTests.getGame(1).toString(), ForTests.suggestGame());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void CheapGame() 
	{
		ForTests.insertGame((new Item("Assassin's Creed", new Date(2004,6,21),25.00,8.0)));
		ForTests.insertGame((new Item("Killzone 2", new Date(2007,8,15),27.00,8.5)));

		assertEquals(ForTests.getGame(0).toString(), ForTests.findCheapestGame());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void SellGame() 
	{
		ForTests.insertGame((new Item("Assassin's Creed", new Date(2004,6,21),25.00,8.0)));
		ForTests.insertGame((new Item("Killzone 2", new Date(2007,8,15),27.00,8.5)));

		assertTrue(ForTests.getGame(0).sellBack(new Date(2015,2,9)) < ForTests.getGame(0).price);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void MakeSale() 
	{
		ForTests.insertGame((new Item("Assassin's Creed", new Date(2004,6,21),25.00,8.0)));
		ForTests.insertGame((new Item("Killzone 2", new Date(2007,8,15),27.00,8.5)));

		assertTrue(ForTests.getGame(0).makeSale(25.00));
		assertFalse(ForTests.getGame(1).makeSale(25.00));
	}
}

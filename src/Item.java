import java.util.Date;


public class Item 
{
	String name;
	Date release;
	double price;
	double rating;
	
	public Item(String name, Date release, double price, double rating)
	{
		this.name = name;
		this.release = release;
		this.price = price;
		this.rating = rating;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double newPrice)
	{
		price = newPrice;
	}
	public double getRating()
	{
		return rating;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Date getReleaseDate()
	{
		return release;
	}
	
	public double sellBack(Date currentDate)
	{
		double sellPrice;
		long days = (currentDate.getTime() - release.getTime())/1000/60/60/24;
		sellPrice = price - (days*0.002) - (1/rating *10);
		return sellPrice;
	}
	
	public boolean makeSale(double Payment)
	{
		double change = Payment - price;
		if(change < 0)
		{
			System.out.println("Sorry, that's not enough money");
			return false;
		}
		else
		{
			System.out.println("Thank you for your purchase. Your change is $" + change +". Thank you and come again.");
			return true;
		}
	}
	
	@SuppressWarnings("deprecation")
	public String toString()
	{
		return ("The game " + name + " was released in " + release.getYear() + " and recieved a rating of " + rating + ". It is currently listed at $" + price);
	}
	
	
}

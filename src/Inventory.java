import java.util.ArrayList;
import java.util.Date;


public class Inventory 
{
	ArrayList<Item> Inventory;
	
	public Inventory()
	{
		Inventory = new ArrayList<Item>();
	}
	public Inventory(ArrayList<Item> Inventory)
	{
		this.Inventory = Inventory;
	}
	
	public void insertGame(Item Game)
	{
		Inventory.add(Game);
	}
	
	public Item getGame(int position)
	{
		return Inventory.get(position);
	}
	
	public Item findGame(String name)
	{
		if (Inventory.size() > 0)
		{
			for(int i = 0; i < Inventory.size(); i++)
				if(Inventory.get(i).name.equals(name))
					return Inventory.get(i);
		}
		return null;
	}
	
	public String suggestGame()
	{
		if (Inventory.size() > 0)
		{
			Item Selection = Inventory.get(0);
			
			for(int i = 0; i < Inventory.size(); i++)
			{
				if(Inventory.get(i).rating > Selection.rating)
					Selection = Inventory.get(i); 
			}
			
			return Selection.toString();
		}
		return null;
	}
	
	public String findCheapestGame()
	{
		if (Inventory.size() > 0)
		{
			Item Selection = Inventory.get(0);
			
			for(int i = 0; i < Inventory.size(); i++)
			{
				if(Inventory.get(i).price < Selection.price)
					Selection = Inventory.get(i); 
			}
			
			return Selection.toString();
		}
		return null;
	}
	
	public String findHighestSellPrice(Date currentDate)
	{
		if (Inventory.size() > 0)
		{
			Item Selection = Inventory.get(0);
			
			for(int i = 0; i < Inventory.size(); i++)
			{
				if(Inventory.get(i).sellBack(currentDate) > Selection.sellBack(currentDate))
					Selection = Inventory.get(i); 
			}
			
			return Selection.name;
		}
		return null;
	}
}

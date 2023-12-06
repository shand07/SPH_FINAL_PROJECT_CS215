package application;

public class Item<T>
{
	
	T item;//Item that will be used to set our item type
	
	String name;
	


	double price;//Price of the item
	
	/**
	 * Used to set item type
	 * @param item type
	 */
	
	public Item(String name)
	{
		this.name = name;
		
	}
	
	public void setItemType(T type)
	{
		this.item = type;
	}
	
	/**
	 * Returns the item type
	 * @return Item type
	 */
	public T getItemType()
	{
		return item;
	}
	
	/**
	 * 
	 * @param value used to set the vale of the item
	 */
	
	public void setPrice(double value)
	{
		
		this.price = value;
		
	}
	
	
	/**
	 * 
	 * @return The value of the price
	 */
	
	public double getPrice()
	{
		return this.price;
	}
	
	
	@Override
	public String toString()
	{
		return name;
	}


}
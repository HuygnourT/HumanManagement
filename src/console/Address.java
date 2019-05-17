package console;

public class Address {
	private String address;
	public Address()
	{
		address ="";
	}
	public Address(String address)
	{
		this.address = address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String toString()
	{
		return this.address;
	}
}	

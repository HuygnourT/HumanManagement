package console;

import java.util.*;
public class Date {
	int day,month,year;
	public Date()
	{
		setYear(1900);
		setMonth(1);
		setDay(1);
	}
	public Date(int d,int m,int y)
	{
		setYear(y);
		setMonth(m);
		setDay(d);
	}
	public void setDay(int d)
	{
		if(d <= 0 || d > numberOfDays())
			day = 1;
		else
			day = d;
	}
	public void setMonth(int month)
	{
		if(month < 0 || month > 12)
			this.month = 1;
		else 
			this.month = month;
	}
	public void setYear(int year)
	{
		if(year > 5000 || year < 0)
			this.year = 1900;
		else 
			this.year = year;
	}
	public int getDay()
	{
		return this.day;
	}
	public int getMonth()
	{
		return this.month;
	}
	public int getYear()
	{
		return this.year;
	}
	public int numberOfDays()
	{
		switch(month)
		{
		case 4:case 6: case 9:case 11: return 30;
		case 2: if((year % 4 == 0 && year % 100 != 0) || year % 400 ==0) return 29;
				return 28;
		default: return 31;
		}
	}
	public String toString()
	{
		if(day == 1 && month == 1 && year == 1900)
			return "";
		else return day+"/"+month+"/"+year;
	}
}

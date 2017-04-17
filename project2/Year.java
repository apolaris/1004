//*********************************
//Beichen Zhang , bz2309
//
//2/20/2017
//
//1004_001
//
//This class represents a calendar year.
//
//It contains a method that determines if
//the year is a leap year.
//
//*********************************


public class Year{
	private int year;
	public Year(int y){
		year = y;
	}
	public boolean isLeapYear(){
		if(year % 4 == 0){
			if(year % 100 == 0){
				if(year % 400 == 0)
					return true;
				else
					return false;
			}
			else
				return true;
		}
		else
			return false;
	}
}


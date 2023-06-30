package soobin.calendar;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysOffMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		}
		return MAX_DAYS[month - 1];
	}

//	년도를 입력하세요.
//	YEAR> 2017
//	달을 입력하세요.
//	MONTH> 3
//	첫번째 요일을 입력하세요. (SU, MO, WE, TH, FR, SA)
//	WEEKDAY> WE

//	    <<2017년  3월>>
//	 SU MO TU WE TH FR SA
//	---------------------
//	           1  2  3  4
//	  5  6  7  8  9 10 11
//	  ...
	
	public void printCalendar(int year, int month, int weekday) {
		System.out.println("=====================");
		System.out.printf("  <<%4d년%3d월>>\n", year, month);
		System.out.println("----------------------");
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");

		//print blank space
		for(int i= 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDay = getMaxDaysOffMonth(year, month);
		int count = 7 - weekday;
		int delimiter = count < 7 ? count : 0;
		
		//print first line
		for(int i= 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		//print from second line to last
		count++;
		for(int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if(i % 7 == delimiter) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("=====================");
	}

}
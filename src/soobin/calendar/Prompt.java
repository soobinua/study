package soobin.calendar;

import java.util.Scanner;

public class Prompt {

	/**
	 * @param week 요일명
	 * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
	 */
	public int parseDay(String week) {
		if(week.equals("su")) return 0;
		else if(week.equals("mo")) return 1;
		else if(week.equals("tu")) return 2;
		else if(week.equals("we")) return 3;
		else if(week.equals("th")) return 4;
		else if(week.equals("fr")) return 5;
		else if(week.equals("sa")) return 6;
		else return 0;
	}
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 0;
		int year = 0;
		int weekday = 0;
		
		while (true) {
			System.out.println("연도를 입력하세요. (exit : -1)");
			System.out.print("YEAR > ");
			year = scanner.nextInt();
			
			if(year == -1) {
				break;
			}

			System.out.println("달을 입력하세요.");
			System.out.print("MONTH > ");
			month = scanner.nextInt();
			
			if (month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다.");
			}
			
			System.out.println("첫째 날의 요일을 입력하세요.(su, mo, tu, we, th, fr, sa)");
			System.out.print("MONTH > ");
			String strWeekday = scanner.next();
			weekday = parseDay(strWeekday);

			// System.out.printf("%d일은 %d일까지 있습니다.\n", month,
			// cal.getMaxDaysOffMonth(month));
			cal.printCalendar(year, month, weekday);
		}

		System.out.println("Bye~");
		scanner.close();
	}

	public static void main(String[] args) {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
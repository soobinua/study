package soobin.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "<cal> ";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 0;
		int year = 0;
		while (true) {
			System.out.println("연도를 입력하세요.");
			System.out.print("YEAR > ");
			year = scanner.nextInt();

			System.out.println("달을 입력하세요.");
			System.out.print("MONTH > ");
			month = scanner.nextInt();
			
			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			// System.out.printf("%d일은 %d일까지 있습니다.\n", month,
			// cal.getMaxDaysOffMonth(month));
			cal.printCalendar(year, month);
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
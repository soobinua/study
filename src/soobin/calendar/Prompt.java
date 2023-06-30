package soobin.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "<cal> ";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 0;
		while (true) {
			System.out.println("달을 입력하세요.");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			// System.out.printf("%d일은 %d일까지 있습니다.\n", month,
			// cal.getMaxDaysOffMonth(month));
			cal.printCalendar(2023, month);
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
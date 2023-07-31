package exception;

import java.util.Scanner;

public class Adder {

	public static void main(String[] args) {
		// 두 정수를 입력받아 더한 결과를 출력
		Scanner scanner = new Scanner(System.in);

		System.out.println("첫 번째 수를 입력하세요.");
		String numberString1 = scanner.nextLine();
		System.out.println("두 번째 수를 입력하세요.");
		String numberString2 = scanner.next();

		try {
			int number1 = Integer.parseInt(numberString1);
			int number2 = Integer.parseInt(numberString2);
			int sum = number1 + number2;
			System.out.println("두 수의 합은 : " + sum);
		} catch (Exception e) {
			System.out.println("숫자를 변환하는 동안 오류가 발생했습니다.");
		}

		scanner.close();
	}

}

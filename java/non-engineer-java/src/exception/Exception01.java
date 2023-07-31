package exception;

import java.util.Scanner;

public class Exception01 { // 예외

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		String numberInput = scanner.nextLine();
		try { // 예외 발생 가능성이 있는 코드
			int number = Integer.parseInt(numberInput);
			number = number + 1;
			System.out.println("다음 숫자는 " + number + "입니다.");
		} catch (Exception e) { // 예외가 발생했을 때 실행될 코드
			System.out.println("숫자를 입력해주세요!");
			System.out.println("입력값 = " + numberInput);
		}

		scanner.close();
	}

}

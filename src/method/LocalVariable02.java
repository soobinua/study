package method;

import java.util.Scanner;

public class LocalVariable02 {

	public static void main(String[] args) {
		echoSomeInputs();
	}

	private static void echoSomeInputs() {
		System.out.println("원하는 출력을 선택하세요.");
		System.out.println("1. 숫자 출력");
		System.out.println("2. 문자 출력");

		Scanner scanner = new Scanner(System.in); // Scanner 한 번만 생성
		String input = scanner.nextLine();
		if (input.equals("1")) {
			echoInteger(scanner); // 메소드의 매개변수로 Scanner 전달
		} else if (input.equals("2")) {
			echoString(scanner); // 메소드의 매개변수로 Scanner 전달
		}

		scanner.close();
	}

	private static void echoInteger(Scanner scanner) { // 메소드의 매개변수로 Scanner 받기
		int input = scanner.nextInt();
		System.out.println(input);
	}

	private static void echoString(Scanner scanner) { // 메소드의 매개변수로 Scanner 받기
		String input = scanner.nextLine();
		System.out.println(input);
	}

	// Scanner를 한 번만 생성했지만 매개변수로 이를 하나하나 전달해야 한다.
	// 전역변수(멤버변수) 사용하는 방법 GlobalVariable
}

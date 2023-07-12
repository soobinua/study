package method;

import java.util.Scanner;

public class LocalVariable01 {

	public static void main(String[] args) {
		System.out.println("원하는 출력을 선택하세요.");
		System.out.println("1. 숫자 출력");
		System.out.println("2. 문자 출력");

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		if (input.equals("1")) {
			echoInteger();
		} else if (input.equals("2")) {
			echoString();
		}

		scanner.close();
	}

	private static void echoInteger() {
		// 지역변수. 메소드 내부에서 선언한 변수
		// 메소드 실행 끝나면 역할 다하고 사라진다
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		System.out.println(input);
		scanner.close();
	}

	private static void echoString() {
		Scanner scanner = new Scanner(System.in); // Scanner 중복
		String input = scanner.nextLine();
		System.out.println(input);
		scanner.close();
	}

	// Scanner 계속 생성하는 것 불필요한 중복
	// 메소드의 매개변수로 Scanner 받는 방법 LocalVariable02
}

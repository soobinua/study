package method;

import java.util.Scanner;

public class GlobalVariable {

	// 멤버변수(전역변수)
	public static Scanner scanner = new Scanner(System.in);
	// 변수 앞에 public static 붙여야 public static으로 시작하는 메소드 안에서 사용 가능
	// 멤버변수 선언할 때는 메소드보다 위쪽에 선언
	// 프로그램 시작될때부터 종료될때까지 언제든 사용가능

	public static void main(String[] args) {
		echoSomeInputs();
	}

	private static void echoSomeInputs() {
		System.out.println("원하는 출력을 선택하세요.");
		System.out.println("1. 숫자 출력");
		System.out.println("2. 문자 출력");
		String input = scanner.nextLine();

		if (input.equals("1")) {
			echoInteger();
		} else if (input.equals("2")) {
			echoString();
		}
	}

	private static void echoInteger() {
		System.out.println("출력할 숫자를 입력하세요.");
		int input = scanner.nextInt();
		System.out.println(input);
	}

	private static void echoString() {
		System.out.println("출력할 문자를 입력하세요.");
		String input = scanner.nextLine();
		System.out.println(input);
	}

}

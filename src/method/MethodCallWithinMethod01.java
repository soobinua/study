package method;

import java.util.Scanner;

public class MethodCallWithinMethod01 {

	public static void main(String[] args) {
		calculate(); // calculate 메소드 호출
	}

	public static void calculate() {
		// 사용자 입력 받기 위한 Scanner 생성
		Scanner scanner = new Scanner(System.in);

		System.out.println("원하는 연산을 선택하세요.");
		System.out.println("1. 덧셈");
		System.out.println("2. 곱셈");

		// 원하는 연산의 번호를 문자열 타입으로 입력받는다.
		String input = scanner.nextLine();

		// 연산을 수행하기를 원하는 첫 번째 숫자 입력받는다.
		System.out.println("첫 번째 숫자를 입력하세요.");
		int num1 = scanner.nextInt();

		// 연산을 수행하기를 원하는 두 번째 숫자 입력받는다.
		System.out.println("두 번재 숫자를 입력하세요.");
		int num2 = scanner.nextInt();

		// 만일 덧셈을 선택했다면 덧셈 add 메소드 호출하고 결과값 출력
		if (input.equals("1")) {
			int sum = add(num1, num2); // 메소드 안에서 다른 메소드 호출
			System.out.println(num1 + " + " + num2 + " = " + sum);
		}

		// 만일 곱셈을 선택했다면 곱셈 multiply 메소드 호출하고 결과값 출력
		if (input.equals("2")) {
			int sum = multiply(num1, num2); // 메소드 안에서 다른 메소드 호출
			System.out.println(num1 + " x " + num2 + " = " + sum);
		}

		scanner.close();

	}

	// 덧셈 수행해 결과값 반환하는 메소드
	private static int add(int num1, int num2) {
		System.out.println("덧셈 수행");
		return num1 + num2;
	}

	// 곱셈 수행해 결과값 반환하는 메소드
	private static int multiply(int num1, int num2) {
		System.out.println("곱셈 수행");
		return num1 * num2;
	}

}

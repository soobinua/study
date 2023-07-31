package loop;

import java.util.Scanner;

public class PasswordInput01 {

	public static void main(String[] args) {
		// 올바른 비밀번호 입력할 때까지 비밀번호 입력 반복
		// 반복문 - while
		String password = "password1234";
		Scanner scanner = new Scanner(System.in);

		System.out.println("비밀번호를 입력해주세요.");
		String input = scanner.nextLine();

		while (input.equals(password) != true) {
			System.out.println("비밀번호를 입력해주세요.");
			input = scanner.nextLine();
		}

		System.out.println("올바른 비밀번호를 입력했습니다.");

		scanner.close();

		// while문 - 조건이 참이어야 중괄호 안 코드 실행
	}

}

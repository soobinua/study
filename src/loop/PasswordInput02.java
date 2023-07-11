package loop;

import java.util.Scanner;

public class PasswordInput02 {

	public static void main(String[] args) {
		// 올바른 비밀번호 입력할 때까지 비밀번호 입력 반복
		// 반복문 - do-while
		String password = "password1234";
		Scanner scanner = new Scanner(System.in);
		String input;

		do {
			// 실행 코드
			System.out.println("비밀번호를 입력해주세요.");
			input = scanner.nextLine();
		} while (input.equals(password) != true); // 조건

		System.out.println("올바른 비밀번호를 입력했습니다.");

		scanner.close();

		// do-while문 - 일단 중괄호 코드 한 번 실행 후 조건 참인지 비교
		// 조건이 참이라면 중괄호 코드 반복해서 실행
	}

}

package method;

import java.util.Scanner;

public class ReturnMethod {

	public static void main(String[] args) {
		System.out.println("이름을 입력해주세요.");

		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();

		sayHola(name);

		scanner.close();
	}

	public static void sayHola(String name) {
		if ("바보".equals(name)) {
			System.out.println("고운 말을 사용해주세요.");
			return; // 메소드 탈출
			// 메소드 반환값 타입 void인 경우 return 반환값 없이 바로 메소드 탈출
		}

		System.out.println(name + "님, Hola!");
	}
}

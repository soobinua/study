package input;

import java.util.Scanner;

public class Input02 {

	public static void main(String[] args) {
		// 키보드로부터 한 줄 입력받기
		System.out.println("이름을 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine(); // 사용자가 입력한 줄을 그대로 문자열 값으로 되돌려준다.
		System.out.println(name + "님, 반갑습니다!");
		scanner.close();
	}

}

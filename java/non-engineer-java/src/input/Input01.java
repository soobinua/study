package input;

import java.util.Scanner;

public class Input01 {

	public static void main(String[] args) {
		// 키보드로부터 한 줄 입력받기
		// Scanner 타입은 생성 시 입력 소스로 사용될 다른 값을 필요로 한다.
		Scanner scanner = new Scanner(System.in); // System.in 표준 입력
		String input = scanner.nextLine(); // 사용자가 입력한 줄을 그대로 문자열 값으로 되돌려준다.
		System.out.println(input);
		scanner.close();
	}

}

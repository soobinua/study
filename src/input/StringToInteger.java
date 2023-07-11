package input;

import java.util.Scanner;

public class StringToInteger {

	public static void main(String[] args) {
		// 키보드로부터 입력받은 숫자 사용하기
		System.out.println("숫자를 입력하세요.");
		Scanner scanner = new Scanner(System.in);

		String intString = scanner.nextLine();
		int number = Integer.parseInt(intString); // (문자열타입) 넣어주면 이를 정수로 바꿔준다.
		number = number + 1;

		System.out.println("입력한 숫자의 다음 숫자는 : " + number + " 입니다.");

		scanner.close();
	}

}

package conditional;

import java.util.Scanner;

public class StringCompare02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("치킨을 입력해 주세요.");
		String input = scanner.nextLine();
		String chicken = "치킨";
		System.out.println(input.equals(chicken));

		scanner.close();

		// System.out.println(input == chicken); // 단순하게 문자열이 같은지 판단 X
		// 자바 문자열과 같은 타입에 비교 연산자 사용할 때 그 값을 직접 비교 X
		// 메모리 상에서 그 값이 저장되어 있는 위치, 즉 메모리의 주소값 비교
		// 소스코드 "치킨"과 표준 입력 "치킨" 문자열은 서로 다른 주소이기 때문에 비교연산자 false
		// 문자열 비교할 때는 equals() 사용
	}

}

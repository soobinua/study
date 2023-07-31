package conditional;

import java.util.Scanner;

public class PriceOfFood02 {

	public static void main(String[] args) {
		System.out.println("메뉴 번호를 입력해 주세요.");
		System.out.println("1. 치킨");
		System.out.println("2. 순대국");
		System.out.println("3. 버거");

		Scanner scanner = new Scanner(System.in);
		int menuNumber;

		try {
			menuNumber = scanner.nextInt(); // nextInt() 숫자
		} catch (Exception e) {
			menuNumber = -1;
		}

		switch (menuNumber) {
		case 1:
			System.out.println("치킨은 10,000원 입니다.");
			break;
		case 2:
			System.out.println("순대국은 8,000원 입니다.");
			break;
		case 3:
			System.out.println("버거는 5,000원 입니다.");
			break;
		default:
			System.out.println("판매하지 않는 메뉴입니다.");
			break;
		}

		scanner.close();
	}

}

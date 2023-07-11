package conditional;

import java.util.Scanner;

public class PriceOfFood01 {

	public static void main(String[] args) {
		System.out.println("음식 이름을 입력해보세요.");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();

		switch (name) {
		case "치킨":
			System.out.println("치킨은 10,000원 입니다.");
			break;
		case "순대국":
			System.out.println("순대국은 8,000원 입니다.");
			break;
		case "버거":
			System.out.println("버거는 5,000원 입니다.");
			break;
		default:
			System.out.println("판매하지 않는 메뉴입니다.");
			break;
		}

		scanner.close();
	}

}

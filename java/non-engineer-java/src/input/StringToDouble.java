package input;

import java.util.Scanner;

public class StringToDouble {

	public static void main(String[] args) {
		// 키보드로부터 입력받은 숫자 사용하기
		Scanner scanner = new Scanner(System.in);

		System.out.println("달러 환율을 입력하세요.");
		String exchangeString = scanner.nextLine();

		System.out.println("순대국 값을 입력하세요.");
		String priceOfSoupString = scanner.nextLine();

		double exchange = Double.parseDouble(exchangeString); // (문자열타입) 넣어주면 이를 실수로 바꿔준다.
		double priceOfSoup = Double.parseDouble(priceOfSoupString);

		System.out.println("순대국은 " + priceOfSoup / exchange + "달러 입니다.");

		scanner.close();
	}

}

package exception;

import java.util.Scanner;

public class DogFood {

	public static void main(String[] args) {
		// 1일 권장 사료 급여량 : 강아주 몸무게 1kg당 10g의 사료를 급여
		// 강아지의 몸무게를 입력받아 1일 권장 사료 급여량 계산하고 출력
		Scanner scanner = new Scanner(System.in);
		System.out.println("강아지의 몸무게를 입력해주세요.");
		String weightInString = scanner.nextLine();

		try {
			double weight = Double.parseDouble(weightInString);
			double amount = weight * 10;
			System.out.println("1일 권장 사료 급여량 : " + amount);
		} catch (Exception e) {
			System.out.println("숫자를 변환하는 동안 오류가 발생했습니다.");
		}

		scanner.close();
	}

}

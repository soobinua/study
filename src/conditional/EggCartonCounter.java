package conditional;

import java.util.Scanner;

public class EggCartonCounter {

	public static void main(String[] args) {
		// 양계장 닭이 낳은 달걀 수에 따라 포장에 필요한 계란판 수 출력
		// 달걀 30개당 하나의 계란판
		// 계란판이 필요하지 않은 경우 "계란판이 필요하지 않습니다."
		// 필요한 경우 "총 x개의 계란판이 필요합니다."

		// 사용자로부터 총 달걀의 수를 입력받기 위한 Scanner 생성
		Scanner scanner = new Scanner(System.in);
		System.out.println("닭이 낳은 달걀 수를 입력하세요.");

		int eggCartonSize = 30; // 계란판 하나당 포장되는 달걀 수
		int totalEggs = 0; // 총 달걀 수를 입력받기 위해 0으로 초기화

		// 사용자로부터 문자열 입력받기
		String input = scanner.nextLine();

		try {
			// 사용자가 입력한 문자열을 정수로 변환
			// 예외 발생할 수 있으므로 try 영역 안 작성
			totalEggs = Integer.parseInt(input);

			if (totalEggs < 30) {
				// 사용자가 입력한 달걀의 수가 30개 미만인 경우
				System.out.println("계란판이 필요하지 않습니다.");
			} else {
				// 사용자가 입력한 달걀의 수가 30개 이상인 경우
				// 포장에 필요한 계란판 수 계산
				int totalEggCartons = totalEggs / eggCartonSize;
				System.out.println("총 " + totalEggCartons + "개의 계란판이 필요합니다.");
			}
		} catch (NumberFormatException e) {
			// 사용자가 입력한 문자열을 정수로 변환하는데 실패한 경우
			// 잘못된 입력이라는 메시지 출력
			System.out.println("잘못된 입력입니다.");
		}

		scanner.close();
	}

}

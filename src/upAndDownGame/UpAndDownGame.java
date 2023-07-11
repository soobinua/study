package upAndDownGame;

import java.util.Random;
import java.util.Scanner;

public class UpAndDownGame {

	public static void main(String[] args) {
		/*
		 * 숫자 맞추기 게임
		 * 1. 임의의 숫자 생성 
		 * 2. 다음 과정 8회 반복 
		 * - 입력받은 숫자가 임의의 숫자와 일치하면 축하 메시지 출력하고 반복문 탈출 
		 * - 입력받은 숫자가 임의의 숫자보다 작다면 작다는 메시지 출력 
		 * - 입력받은 숫자가 임의의 숫자보다 크다면 크다는 메시지 출력 
		 * 3. 숫자를 맞추거나 반복문 종료 후 게임을 종료한다는 메시지 출력
		 */
		
		System.out.println("지금부터 0~255 사이에서 숫자를 하나 뽑겠습니다.");
		System.out.println("여러분은 제가 뽑은 숫자를 맞춰야합니다.");

		// 0~255 사이의 숫자 중 임의의 숫자 하나 선택
		Random random = new Random();
		int randomNumber = random.nextInt(256);

		// 플레이어로부터 숫자 입력을 받기 위한 Scanner 생성
		Scanner scanner = new Scanner(System.in);

		// 8회 반복 내용 작성
		for (int i = 0; i < 8; i = i + 1) {
			// 플레이어에게 알려주기 위해 남은 시도 횟수 출력
			// i는 0부터 7까지 증가하기 때문에 8 - i로 남은 횟수 알아낼 수 있다.
			System.out.println(8 - i + "번의 기회가 있습니다.");

			// 플레이어로부터 숫자 입력받기
			System.out.println("추측한 숫자를 입력하세요.");
			String input = scanner.nextLine();
			int guess = Integer.parseInt(input);

			if (randomNumber == guess) {
				System.out.println("축하합니다! 정답입니다!");
				break;
			} else if (randomNumber < guess) {
				System.out.println("제가 생각한 숫자가 더 작습니다.");
			} else {
				System.out.println("제가 생각한 숫자가 더 큽니다.");
			}

			// 8회 반복으로 기회 끝
			if (i == 7) {
				System.out.println("더 이상 기회가 없습니다.");
			}
		}

		System.out.println("게임을 종료합니다.");
		
		scanner.close();
	}

}

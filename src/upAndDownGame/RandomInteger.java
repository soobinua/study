package upAndDownGame;

import java.util.Random;

public class RandomInteger {

	public static void main(String[] args) {
		// 난수 생성
		Random random = new Random();
		int randomNumber = random.nextInt(256); // 0부터 255까지의 숫자 중 하나의 랜덤 숫자
		System.out.println(randomNumber);

	}

}

package loop;

public class GuguClass {

	public static void main(String[] args) {
		// 반복문 - 중첩 for
		for (int i = 2; i < 10; i = i + 1) { // 2부터 9까지 현재 몇단인지 기준에서 반복
			for (int j = 1; j < 10; j = j + 1) { // 현재 단의 수에 1부터 9가지 곱해 출력
				int result = i * j;
				System.out.println(i + " X " + j + " = " + result);
			}
		}

	}

}

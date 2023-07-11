package upAndDownGame;

public class ThreadSleep {

	public static void main(String[] args) {
		// 지연 시간 추가
		System.out.println("지금 무슨 생각을 하고 있는지 맞춰보겠다.");
		try {
			Thread.sleep(3000); // 지연시간 (1/1000초 단위)
		} catch (InterruptedException e) {
			System.out.println("Thread.sleep 실패");
		}

		System.out.println("치킨"); // 3초 뒤 치킨 출력
	}

}

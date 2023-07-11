package loop;

public class Continue01 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i = i + 1) {
			if (i % 2 == 0) {
				continue; // 코드 더 이상 진행하지 않고 바로 반복문의 처음으로 되돌아가 다음 반복 실행
			}
			System.out.println(i);
		}
	}

}

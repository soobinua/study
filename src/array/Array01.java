package array;

public class Array01 {

	public static void main(String[] args) {
		// 배열을 반복문에 사용
		String[] days = { "월", "화", "수", "목", "금", "토", "일" };

		for (int i = 0; i < days.length; i = i + 1) { // 배열 길이만큼 반복
			System.out.println(days[i] + "요일");
		}

	}

}

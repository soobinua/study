package array;

public class Array02 {

	public static void main(String[] args) {
		String[] days = { "월", "화", "수", "목", "금", "토", "일" };

		days[0] = "일"; // 배열의 특정 요소 바꾸기

		for (int i = 0; i < days.length; i = i + 1) {
			System.out.println(days[i] + "요일");
			// 월요일 없어지고 일요일
		}

	}

}

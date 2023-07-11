package array;

public class Array03 {

	public static void main(String[] args) {
		String[] days = { "월", "화", "수", "목", "금", "토", "일" };

		// 반목문 for-each
		for (String day : days) { // 배열자료형 변수명 : 배열
			System.out.println(day + "요일");
		}

	}

}

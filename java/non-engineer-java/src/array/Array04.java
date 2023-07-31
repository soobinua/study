package array;

public class Array04 {

	public static void main(String[] args) {
		String[] days = { "월", "화", "수", "목", "금", "토", "일" };

		System.out.println(days[7]);
		// 배열 인덱스 0부터 시작으로 마지막 요소 6
		// 배열의 마지막 요소의 인덱스보다 뒤의 번호 접근시 오류
		// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 7

		// 배열 크기는 만들어내는 동시에 정해져 이후 길이 변경 불가
	}

}

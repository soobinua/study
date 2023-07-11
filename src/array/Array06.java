package array;

import java.util.Arrays;

public class Array06 {

	public static void main(String[] args) {
		String[] days = { "월", "화", "수", "목", "금", "토", "일" };
		String[] days2 = Arrays.copyOf(days, 8);

		days2[7] = "일";

		for (String s : days2) {
			System.out.println(s);
		}
		// 배열 크기는 만들어내는 동시에 정해져 이후 길이 변경 불가
		// 배열에 값 추가하고 싶다면 내용을 복제한 새 배열 만드는 변칙적 방법 사용
	}

}

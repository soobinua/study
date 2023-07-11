package array;

import java.util.Arrays;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		// 2차원 배열
		String[][] days = { // [앞의 대괄호] 줄번호(0부터2) [뒤의 대괄호] 요일의번호(0부터6)
				{ "월", "화", "수", "목", "금", "토", "일" }, 
				{ "일", "화", "수", "목", "금", "토", "일" },
				{ "월", "화", "수", "목", "금", "금", "금" }, 
		};
		
		System.out.println(Arrays.toString(days[0])); // 배열 안 첫번째 배열
		System.out.println(Arrays.toString(days[1])); // 배열 안 두번째 배열
		System.out.println(Arrays.toString(days[2])); // 배열 안 세번째 배열

		System.out.println(days[2][6]); // 2차원 배열 내부 세번재 배열에서 여섯번째 요소
	}

}

package array;

public class ArraySum {

	public static void main(String[] args) {
		// 배열에 담긴 모든 수를 더한 값 출력
		int[] num = { 10, 20, 30, 40, 50 };

		int sum = 0;
		for (int i : num) {
			sum += i;
		}
		System.out.println("배열의 총합 : " + sum);

	}

}

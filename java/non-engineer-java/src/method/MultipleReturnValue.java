package method;

public class MultipleReturnValue {

	public static void main(String[] args) {
		int[] numbers = addAndMultiply(2, 3);
		int sum = numbers[0];
		int product = numbers[1];

		System.out.println("2 + 3 = " + sum);
		System.out.println("2 x 3 = " + product);
	}

	public static int[] addAndMultiply(int num1, int num2) {
		int sum = num1 + num2;
		int product = num1 * num2;

		int[] result = { sum, product }; // 배열 한가지 타입만 지원

		return result; // 여러개 반환값
		// return 반환값 넘기는 용도
	}
}

package method;

public class ReturnValue01 {

	public static void main(String[] args) {
		int result = add(2, 3);
		System.out.println("2 + 3 = " + result);
	}

	public static int add(int num1, int num2) { // add 메소드 반환 타입 int
		return num1 + num2; // 정수형 값 반환
		// return 반환값 넘기는 용도
	}
}

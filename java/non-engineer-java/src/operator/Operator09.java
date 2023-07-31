package operator;

public class Operator09 {

	public static void main(String[] args) {
		// int number = 1.2;
		// error : Type mismatch: cannot convert from double to int
		// 변수의 자료형 이외의 값 대입하려고 하면 오류 발생

		// 자바에서는 정수형 변수에 실수를 그냥 대입하는 행위는 허용하지 않는다.
		// 형 변환 이용해야 한다.

		int number = (int) 1.6; // 형 변환. 숫자 간 자료형 변환할 수 있다.
		System.out.println(number); // 1.6 정수로 변환하면 소수점 아래 0.6 버려지고 1
	}

}

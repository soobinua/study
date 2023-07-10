
public class Operator10 {

	public static void main(String[] args) {
		// 자바에서는 정수형 변수에 실수를 그냥 대입하는 행위는 허용하지 않는다.
		// 이들 간의 연산 자체는 허용한다.
		// 정수끼리 계산했을 때와 실수가 포함되었을 때와의 결과는 조금 다르다.
		System.out.println(1 + 1.2);
		System.out.println(7 / 2); // 정수와 정수의 계산 결과는 무조건 정수로 소수점 아래 숫자 버린다.
		System.out.println(7 / 2.0); // 정수와 실수의 계산 결과는 실수

	}

}

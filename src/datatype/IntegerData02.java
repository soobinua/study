package datatype;

public class IntegerData02 {

	public static void main(String[] args) {
		// 정수형 변수끼리는 연산 가능
		// long 타입 제외 모든 연산 결과 int 타입
		// long 타입이 포함된 경우 결과 long 타입
		short shortNum = 5;
		int intNum = 10;
		long longNum = 20;

		int intResult = intNum - shortNum;
		long longResult = longNum - intNum;

		System.out.println(intResult);
		System.out.println(longResult);
	}

}

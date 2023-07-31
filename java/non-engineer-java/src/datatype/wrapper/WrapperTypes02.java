package datatype.wrapper;

public class WrapperTypes02 {

	public static void main(String[] args) {
		// 자료형 - 래퍼 타입
		Integer integerNumber = 3;
		// Integer 타입의 주요 기능은 float, double 등의 실수나 문자열로 바꿔준다.
		Float floatNumber = integerNumber.floatValue(); 	// 3.0f
		Double doubleNumber = integerNumber.doubleValue();	// 3.0d
		String stringNumber = integerNumber.toString();		// "3"

	}

}

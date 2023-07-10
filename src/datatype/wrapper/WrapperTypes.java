package datatype.wrapper;

public class WrapperTypes {

	public static void main(String[] args) {
		// 자료형 - 래퍼 타입
		Integer integerNumber = 3;
		Long longNumber = 3L;
		Float floatNumber = 3.0f;
		Double doubleNumber = 3.0d;
		Boolean booleanValue = true;

		// 문자열 제외 자료형들을 원시(primitive) 자료형이라고 부른다.
		// 원시자료형은 순수하게 상수 형태로 표현할 수 있는 자료형
		// 자료의 크기에 대한 제약을 가지고 있으며 추가적인 기능들 제공 X
		// 문자열은 문자열의 글자 수, 문자열 자르기 등 추가적인 기능 제공 O
		// 자바는 숫자형이나 논리형에도 이런 기능을 제공하기 위해 래퍼(wrapper) 타입들 제공한다.
	}

}

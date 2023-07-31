package collection.list;

import java.util.ArrayList;

public class ListExample01 {

	public static void main(String[] args) {
		// List에 데이터 추가 - add()
		ArrayList<String> foods = new ArrayList<String>(); // 문자열 타입 ArrayList 변수 생성

		foods.add("치킨"); // add 메소드를 호출해 문자열 데이터들 추가
		foods.add("피자");

		System.out.println(foods);

		// List에서는 원시 자료형을 사용할 수 없기 때문에 int, double, boolean 사용할 수 없다.
		// int -> Integer : ArrayList<Integer>로 사용
		// double -> Double : ArrayList<Double>로 사용
		// boolean -> Boolean : ArrayList<Boolean>로 사용
	}
}

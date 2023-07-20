package collection.list;

import java.util.ArrayList;

public class ListExample03 {

	public static void main(String[] args) {
		// List에 데이터 제거 - remove(인덱스 입력)
		ArrayList<String> foods = new ArrayList<String>(); // 문자열 타입 ArrayList 변수 생성

		foods.add("치킨");
		foods.add("피자");

		foods.remove(0); // remove메소드 데이터의 위치를 지정해 특정 데이터 제거

		System.out.println(foods);
	}
}

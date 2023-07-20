package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListSetError {

	public static void main(String[] args) {
		// List의 특정 위치의 값 변경
		List<String> foods = new ArrayList<String>();

		foods.add("파");
		foods.add("치킨");
		foods.add("피자");

		foods.set(0, "치킨"); // set(값을 바꿀 요소의 인덱스, 바꿔 넣으려는 값)

		System.out.println(foods);
	}
}

package list;

import java.util.ArrayList;
import java.util.List;

public class ListSet {

	public static void main(String[] args) {
		// List의 특정 위치의 값 변경
		List<String> foods = new ArrayList<String>();

		foods.add("파");
		foods.add("치킨");
		foods.add("피자");

		foods.set(10, "치킨"); // set(값을 바꿀 요소의 인덱스, 바꿔 넣으려는 값)
		// 인덱스로 존재하지 않는 번호 사용하면 오류 발생
		System.out.println(foods);

		// 배열이나 List를 사용할 때는 항상 해당 목록이 가지고 있는 요소들의 개수에 유념해야 한다.
	}
}

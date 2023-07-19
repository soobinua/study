package list;

import java.util.ArrayList;

public class ListOutOfBound {

	public static void main(String[] args) {
		// 인덱스는 0번부터 시작한다.
		ArrayList<String> foods = new ArrayList<String>();

		foods.add("치킨");
		foods.add("피자");

		foods.remove(2); // 매개변수로 2를 입력했으나 실제 목록에는 0번과 1번째만 존재

		System.out.println(foods);
		// Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
		// 목록의 길이는 2로, 0번과 1번째만 존재하는데 2번째를 지정해 오류 발생
	}
}

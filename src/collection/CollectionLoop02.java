package collection;

import java.util.HashSet;

public class CollectionLoop02 {

	public static void main(String[] args) {
		// 반복문에서 컬렉션 Set 이용
		HashSet<String> myFavoriteFoods = new HashSet<>();

		myFavoriteFoods.add("치킨");
		myFavoriteFoods.add("피자");
		myFavoriteFoods.add("고구마말랭이");

		for (String food : myFavoriteFoods) {
			System.out.println(food + " 맛있어요!");
		}
		// Set은 순서가 중요하지 않다.
		// Set은 입력한 순서와는 다른 순서로 처리될 수 있다.
		// Set을 사용할 때는 순서가 보장되지 않는다는 점에 유념
	}
}

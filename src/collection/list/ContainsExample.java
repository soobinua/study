package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ContainsExample {

	public static void main(String[] args) {
		List<String> myFavoriteFoods = new ArrayList<>();

		myFavoriteFoods.add("치킨");
		myFavoriteFoods.add("피자");
		myFavoriteFoods.add("치킨");
		// List는 중복을 허용하기 때문에 무언가를 중복해서 추가한다면 목록에 바로 반영되므로 데이터 추가할 때 주의
		// 해결하기 위해서는 값 추가하기 전에 이 값이 이미 존재하는지 확인해야 한다.

		System.out.println(myFavoriteFoods);
	}
}

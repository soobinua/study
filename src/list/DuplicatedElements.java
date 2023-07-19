package list;

import java.util.ArrayList;

public class DuplicatedElements {

	public static void main(String[] args) {
		// List에 특정 데이터가 있는지 확인 - contains()
		ArrayList<String> myFavoriteFoods = new ArrayList<>();

		myFavoriteFoods.add("치킨");
		myFavoriteFoods.add("피자");

		boolean containsChicken = myFavoriteFoods.contains("치킨"); // boolean 값을 되돌려줌으로써 값이 존재하는지 여부 확인 가능

		System.out.println("목록에 치킨이 있는가? :" + containsChicken);
	}
}

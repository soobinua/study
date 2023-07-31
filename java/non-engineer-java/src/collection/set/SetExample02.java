package collection.set;

import java.util.HashSet;
import java.util.Set;

public class SetExample02 {

	public static void main(String[] args) {
		// Set - 데이터 추가 add()
		Set<String> myFavoriteFoods = new HashSet<>();

		myFavoriteFoods.add("치킨");
		myFavoriteFoods.add("피자");
		myFavoriteFoods.add("치킨"); // 중복을 허용하지 않아 중복해서 데이터 추가하는 경우 무시

		System.out.println(myFavoriteFoods);
	}
}

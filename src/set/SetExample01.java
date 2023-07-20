package set;

import java.util.HashSet;
import java.util.Set;

public class SetExample01 {

	public static void main(String[] args) {
		// Set - 데이터 제거 remove()
		Set<String> myFavoriteFoods = new HashSet<>();

		myFavoriteFoods.add("치킨");
		myFavoriteFoods.add("피자");
		myFavoriteFoods.add("치킨"); // 중복을 허용하지 않아 중복해서 데이터 추가하는 경우 무시

		myFavoriteFoods.remove("치킨"); // 데이터 제거

		System.out.println(myFavoriteFoods);

		// Set도 contains() 이용해 특정 데이터가 집합 안에 포함되어 있는지 확인 가능하다.
		// 하지만 List에서는 중복 체크용으로 contains()을 사용했던 것과 달리
		// Set에서는 말 그대로 특정 데이터의 포함 여부를 판단하는 조금 더 원초적인 용도
		// contains()는 List나 Set이나 동일한 기능을 하지만 어떤 것을 사용할지를 선택하는 것은 프로그래머의 몫
		// 주민등록번호 목록과 같이 동일한 값이 존재하지 않는 경우에는 애초부터 오입력 방지를 위해 Set을 사용하는 편이 더 낫다.
		// 컬렉션의 몇 번째에 어느 값이 있는지 알고 사용하기 위해서는 List 선택하는 편이 더 좋다.
		// 용도에 맞게 사용하는 것이 중요
	}
}

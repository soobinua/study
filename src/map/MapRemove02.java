package map;

import java.util.HashMap;

public class MapRemove02 {

	public static void main(String[] args) {
		HashMap<String, String> dictionary = new HashMap<>();

		dictionary.put("chicken", "닭");
		dictionary.put("hippo", "하마");
		dictionary.put("anteater", "개미핥기");

		System.out.println("put 메소드를 이용해 값을 null로 입력");
		dictionary.put("hippo", null); // put 메소드 이용해 값을 null로 입력한다면
		System.out.println(dictionary.get("hippo"));
		System.out.println(dictionary.size()); // Map의 크기는 줄어들지 않는다.

		System.out.println(dictionary);

		System.out.println("remove 메소드 사용");
		dictionary.remove("hippo"); // remove 메소드 이용 시
		System.out.println(dictionary.get("hippo"));
		System.out.println(dictionary.size()); // Map의 크기 자체 줄어든다.

		System.out.println(dictionary);

		// 비슷한 결과를 만들어낼 수는 있지만 데이터를 제거할 때는 remove 메소드를 사용하는 것이 좋다.
	}

}

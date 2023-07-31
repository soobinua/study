package map;

import java.util.HashMap;

public class MapRemove01 {

	public static void main(String[] args) {
		HashMap<String, String> dictionary = new HashMap<>();

		dictionary.put("chicken", "닭");
		dictionary.put("hippo", "하마");
		dictionary.put("anteater", "개미핥기");

		dictionary.remove("hippo"); // Map에서 데이터 제거

		System.out.println(dictionary);
	}

}

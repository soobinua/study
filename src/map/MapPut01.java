package map;

import java.util.HashMap;

public class MapPut01 {

	public static void main(String[] args) {
		// Map : 키-값 쌍으로 이루어져 있는 자료구조
		// Map은 순서를 따지지 않기 때문에 List처럼 특정 위치의 데이터를 가져다 사용할 수 없다.
		// 대신 키를 알고 있으면 그 키를 통해 값을 가져오는 방법을 사용한다.

		HashMap<String, String> dictionary = new HashMap<>(); // 문자열을 키로 하고 또 다른 문자열을 값으로 하는 Map

		dictionary.put("chicken", "닭"); // Map에 데이터 추가 put(키, 값) 메소드 이용
		dictionary.put("hippo", "하마");
		dictionary.put("anteater", "개미핥기");

		System.out.println(dictionary);
	}

}

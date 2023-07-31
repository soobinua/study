package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapLoop03 {

	public static void main(String[] args) {
		HashMap<String, String> dictionary = new HashMap<>();

		dictionary.put("chicken", "닭");
		dictionary.put("hippo", "하마");
		dictionary.put("anteater", "개미핥기");

		// Entry 타입 : 키와 값을 쌍으로 가지고 있다.
		Set<Map.Entry<String, String>> wordPairs = dictionary.entrySet(); // Map의 entrySet 메소드를 호출하면 키-값 쌍으로 이루어진 Map.Entry들의 집합을 반환한다.

		for (Map.Entry<String, String> wordPair : wordPairs) {
			String englishWord = wordPair.getKey();
			String koreanWord = wordPair.getValue();

			System.out.println(englishWord + " : " + koreanWord);

		}
	}

}

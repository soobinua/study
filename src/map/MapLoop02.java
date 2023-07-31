package map;

import java.util.Collection;
import java.util.HashMap;

public class MapLoop02 {

	public static void main(String[] args) {
		HashMap<String, String> dictionary = new HashMap<>();

		dictionary.put("chicken", "닭");
		dictionary.put("hippo", "하마");
		dictionary.put("anteater", "개미핥기");

		Collection<String> koreanWords = dictionary.values(); // Map의 values 메소드 사용하면 값 목록을 컬렉션으로 가져올 수 있다.
		// values 메소드를 사용하면 값 목록을 가져올 수 있지만
		// 키가 중복을 허용하지 않는 것에 반해 값은 중복을 허용하고 있기 때문에 값으로 키를 유추할 수 없다.

		for (String koreanWord : koreanWords) {
			System.out.println(koreanWord);
		}
	}

}

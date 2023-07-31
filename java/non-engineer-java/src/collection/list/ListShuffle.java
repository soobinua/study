package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListShuffle {

	public static void main(String[] args) {
		// List 순서 섞기 - shuffle() 요소들의 순서 무작위로 섞음
		List<Integer> integers = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			integers.add(i);
		}

		Collections.shuffle(integers);
		// 실행할 때마다 List의 요소들 다른 순서로 섞여 나온다.
		System.out.println(integers);
	}
}

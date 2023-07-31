package collection;

import java.util.ArrayList;

public class CollectionIsEmpty {

	public static void main(String[] args) {
		// 컬렉션 목록이 비었는지 여부 판단 - isEmpty()
		ArrayList<String> videos = new ArrayList<>();

		if (videos.isEmpty()) { // isEmpty() 반환값 boolean 타입으로 true인 경우 목록 비어있는 것
			System.out.println("목록이 비어있습니다.");
		} else { // false인 경우 목록이 비어있지 않다는 것
			System.out.println("총 " + videos.size() + "개의 동영상이 있습니다.");
		}
	}
}

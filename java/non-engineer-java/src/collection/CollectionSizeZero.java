package collection;

import java.util.ArrayList;

public class CollectionSizeZero {

	public static void main(String[] args) {
		// 컬렉션 크기 확인 방법 - size()
		ArrayList<String> videos = new ArrayList<>();

		if (videos.size() == 0) {
			System.out.println("목록이 비어있습니다.");
		} else {
			System.out.println("총 " + videos.size() + "개의 동영상이 있습니다.");
		}
	}
}

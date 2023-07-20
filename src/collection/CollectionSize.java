package collection;

import java.util.ArrayList;

public class CollectionSize {

	public static void main(String[] args) {
		// 컬렉션 크기 확인 방법 - size()
		ArrayList<String> videos = new ArrayList<>();

		videos.add("뽀로로와 노래해요");
		videos.add("[헤이지니 비밀의 문] 미니특공대 루시 악당을 물리쳐라");
		videos.add("[미방송_외장하드털이_2탄] 누가 펭수를 자극했는가");

		System.out.println("총 " + videos.size() + "개의 동영상이 있습니다.");
	}
}

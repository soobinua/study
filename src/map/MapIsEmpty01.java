package map;

import java.util.HashMap;

public class MapIsEmpty01 {

	public static void main(String[] args) {
		HashMap<String, String> contacts = new HashMap<>();

		if (contacts.isEmpty()) { // isEmpty() 메소드 boolean 형태로 Map 비어있는지 여부 확인 가능
			System.out.println("연락처가 비어있습니다.");
		}
	}

}

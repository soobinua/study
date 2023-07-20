package collection.list;

import java.util.ArrayList;
import java.util.Collections;

public class Sort02 {

	public static void main(String[] args) {
		ArrayList<String> students = new ArrayList<>();
		students.add("장민호");
		students.add("이찬원");
		students.add("정동원");
		students.add("임영웅");

		Collections.sort(students); // 기본적으로 목록을 오름차순으로 정렬
		Collections.reverse(students); // 현재 목록의 순서를 거꾸로 뒤집어주는 역할

		// 오름차순으로 정렬 후 뒤집었으니 내림차순 정렬
		System.out.println(students);

		// 주의.
		// reverse() 목록을 거꾸로 정렬해주는 기능 X
		// sort()와 다르게 목록의 순서를 거꾸로 뒤집어 주는 기능
		// ex. 원래 목록[1, 3, 2] 에서 reverse() 한 번 사용하면 결과 [2, 3, 1]
	}
}

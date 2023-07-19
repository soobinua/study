package list;

import java.util.ArrayList;
import java.util.Collections;

public class Sort01 {

	public static void main(String[] args) {
		// List 정렬 - Collections.sort(정렬하고 싶은 목록) 오름차순으로 정렬
		ArrayList<String> students = new ArrayList<>();
		students.add("장민호");
		students.add("이찬원");
		students.add("정동원");
		students.add("임영웅");

		Collections.sort(students); // 기본적으로 목록을 오름차순으로 정렬

		System.out.println(students);
	}
}

package collection.list;

import java.util.ArrayList;

public class ListGet02 {

	public static void main(String[] args) {
		// List 목록에서 특정 위치의 요소 가져오기 - get(특정 위치 요소)
		ArrayList<String> students = new ArrayList<String>();

		students.add("에드 시런");
		students.add("저스틴 비버");
		students.add("브루노 마스");

		String student = students.get(3); // 잘못된 위치 지정 시 에러

		System.out.println("0번 학생 :" + student);
		// Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
	}
}

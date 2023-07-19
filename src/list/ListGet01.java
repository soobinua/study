package list;

import java.util.ArrayList;

public class ListGet01 {

	public static void main(String[] args) {
		// List 목록에서 특정 위치의 요소 가져오기 - get(특정 위치 요소)
		ArrayList<String> students = new ArrayList<String>();

		students.add("에드 시런");
		students.add("저스틴 비버");
		students.add("브루노 마스");

		String student = students.get(0);

		System.out.println("0번 학생 :" + student);
	}
}

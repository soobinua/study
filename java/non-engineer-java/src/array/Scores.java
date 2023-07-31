package array;

import java.util.Scanner;

public class Scores {

	public static void main(String[] args) {
		// 과목과 점수를 배열로 선언하고 과목명을 입력받아 해당 과목의 점수 출력
		String[] subjects = { "국어", "영어", "수학", "과학" };
		int[] scores = { 90, 75, 30, 40 };

		Scanner scanner = new Scanner(System.in);
		System.out.println("점수를 보고 싶은 과목을 입력해주세요.");

		String inputsubject = scanner.nextLine();

		for (int i = 0; i < subjects.length; i = i + 1) {
			String subject = subjects[i];

			if (subject.equals(inputsubject)) {
				System.out.println(inputsubject + "점수는 " + scores[i] + "점 입니다.");
			}
		}

		scanner.close();

	}

}

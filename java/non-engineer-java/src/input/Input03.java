package input;

import java.util.Scanner;

public class Input03 {

	public static void main(String[] args) {
		// 키보드로부터 띄어쓰기 단위로 입력받기
		System.out.println("영어 단어와 한글 단어를 하나씩 입력해보세요.");
		Scanner scanner = new Scanner(System.in);

		String englishWord = scanner.next(); // 띄어쓰기 단위로 문자를 분할해서 되돌려준다.
		String koreanWord = scanner.next();

		System.out.println("입력된 영단어 : " + englishWord);
		System.out.println("입력된 한글 단어 : " + koreanWord);

		scanner.close();
	}

}

package file.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput01 {

	public static void main(String[] args) {
		// 텍스트 파일의 내용 출력
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream("src/file/input/chicken.txt");
		} catch (FileNotFoundException e) { // 파일이 존재하지 않을 가능성 예외 처리
			System.out.println("파일이 존재하지 않습니다.");
			System.exit(10); // 프로그램 종료 코드(우리가 정의하는 오류 번호) 오류번호 미리 정의해두면 10번으로 종료 시 파일 없다는 것 인지 가능
		}

		Scanner scanner = new Scanner(inputStream);
		String line = scanner.nextLine();
		System.out.println(line);
//		String line2 = scanner.nextLine();
		// 파일 내용 한 줄뿐인데 두 번 이상 호출하면 오류
		// Exception in thread "main" java.util.NoSuchElementException: No line found

		scanner.close();
	}

}

package file.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput03 {

	public static void main(String[] args) {
		// 여러 줄로 된 텍스트 파일의 내용 출력
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream("src/file/input/acronym5.txt");
		} catch (FileNotFoundException e) { // 파일이 존재하지 않을 가능성 예외 처리
			System.out.println("파일이 존재하지 않습니다.");
			System.exit(10); // 프로그램 종료 코드(우리가 정의하는 오류 번호) 오류번호 미리 정의해두면 10번으로 종료 시 파일 없다는 것 인지 가능
		}

		Scanner scanner = new Scanner(inputStream);
		while (scanner.hasNextLine()) { // hasNextLine() 다음 줄이 존재한다면 true
			String line = scanner.nextLine();
			System.out.println(line);
		}

		scanner.close();
	}

}

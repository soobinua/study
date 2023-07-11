package file.output;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOutput05 {

	public static void main(String[] args) {
		// 키보드 입력을 텍스트 파일로 저장 - 한줄
		Scanner scanner = new Scanner(System.in);
		System.out.println("저장할 문자열을 입력하세요.");
		try {
			FileWriter writer = new FileWriter("src/file/output/output03.txt");
			String input = scanner.nextLine();
			writer.write(input);
			writer.close();
			scanner.close();
		} catch (IOException e) {
			System.out.println("파일 생성에 실패했습니다.");
			System.exit(11);
		}

	}

}

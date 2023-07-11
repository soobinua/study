package file.output;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOutput06 {

	public static void main(String[] args) {
		// 키보드 입력을 텍스트 파일로 저장 - 여러줄
		// 입력받은 문자열 비어 있을 경우 종료
		Scanner scanner = new Scanner(System.in);
		FileWriter writer = null;

		try {
			writer = new FileWriter("src/file/output/output04.txt", true);
		} catch (IOException e) {
			System.out.println("파일 생성에 실패했습니다.");
			System.exit(11);
		}

		System.out.println("저장할 문자열을 입력하세요. (종료 : 입력 없이 엔터)");

		while (true) {
			String input = scanner.nextLine();

			if (input.equals("")) {
				System.out.println("입력 종료");
				break;
			}

			try {
				writer.write(input);
				writer.write("\n");
			} catch (IOException e) {
				System.out.println("파일에 문자열을 쓰지 못했습니다.");
				System.exit(12);
			}
		}

		try {
			writer.close();
			scanner.close();
		} catch (IOException e) {
			System.out.println("파일을 닫기 실패");
			System.exit(13);
		}

	}

}

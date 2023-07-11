package file.output;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput01 {

	public static void main(String[] args) {
		// 텍스트 파일로 저장
		try {
			FileWriter writer = new FileWriter("src/file/output/output01.txt");
			writer.close(); // 파일을 열고 다 사용한 뒤 꼭 닫아주어야 한다.
		} catch (IOException e) {
			System.out.println("파일 생성에 실패했습니다.");
			System.exit(11);
		}

	}

}

package file.output;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput03 {

	public static void main(String[] args) {
		// 텍스트 파일로 저장
		try {
			// 프로그램 실행할 때마다 파일이 새로 써진다.
			// 기본적으로 FileWriter 파일에 내용 쓸 때 매번 파일을 새 파일로 덮어 쓴다.
			FileWriter writer = new FileWriter("src/file/output/output01.txt");
			writer.write("치킨은 살 안 쪄요.\n"); // 줄바꿈 문자(\n) 입력해야 줄바꿈된다.
			writer.write("살은 내가 쪄요.");
			writer.close(); // 파일을 열고 다 사용한 뒤 꼭 닫아주어야 한다.
		} catch (IOException e) {
			System.out.println("파일 생성에 실패했습니다.");
			System.exit(11);
		}

	}

}

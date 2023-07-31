package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Diary {

	public static void main(String[] args) {
		// 메모장 프로그램을 기반으로 간단 일기장 프로그램
		// 년, 월, 일 순으로 날짜를 입력받아 파일명으로 사용
		// 제목과 날씨를 입력받아 내용의 첫 줄에 날짜와 날씨, 제목 추가

		// 사용자로부터 입력 처리를 담당할 Scanner 선언
		Scanner scanner = new Scanner(System.in);

		// 반복문1
		// 무한반복. 사용자가 3를 입력하면 반복문 탈출 구현
		while (true) {
			System.out.println("원하는 작업 번호를 입력해주세요.");
			System.out.println("1. 일기 읽기");
			System.out.println("2. 새 일기");
			System.out.println("3. 종료");

			// 사용자가 입력한 명령 번호를 저장할 변수 선언
			int taskNum;

			// nextLine()으로 한 줄 읽어온 뒤 정수형으로 변환해 taskNum에 대입
			// 예외 발생 경우 (사용자가 정수 아닌 값 입력)
			// "잘못된 입력입니다." 출력 후 반복문 1의 처음으로 돌아가기
			try {
				String input = scanner.nextLine();
				taskNum = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}

			if (taskNum == 1) { // 일기 읽기를 선택한 경우
				// 파일명으로 사용하기 위한 년도를 입력받는다.
				System.out.println("년도를 입력하세요.(예: 1970)");
				String year = scanner.nextLine();

				// 파일명으로 사용하기 위한 월을 입력받는다.
				System.out.println("월을 입력하세요.(예: 01)");
				String month = scanner.nextLine();

				// 파일명으로 사용하기 위한 일을 입력받는다.
				System.out.println("날짜를 입력하세요.(예: 01)");
				String date = scanner.nextLine();

				// 년, 월, 일을 조합해 파일명을 만든다.
				String fileName = year + "-" + month + "-" + date + ".txt";

				// 파일 내용을 읽어들이기 위해 FileInputStream 선언
				FileInputStream inputStream = null;

				// 조합한 파일명을 가지고 FileInputStream 생성
				// 파일 없을 경우 "일기가 존재하지 않습니다." 메시지 출력 후 반복문 1의 처음으로 돌아가기
				try {
					inputStream = new FileInputStream("src/file/" + fileName);
				} catch (FileNotFoundException e) {
					System.out.println("일기가 존재하지 않습니다.");
					continue;
				}

				// FileInputStream이 성공적으로 생성되면 안내 메시지 출력
				System.out.println(year + "-" + month + "-" + date + "의 일기");

				// FileInputStream으로부터 파일의 내용을 읽어들일 Scanner 선언
				Scanner reader = new Scanner(inputStream);

				// 반복문2
				// 파일의 내용을 한줄씩 읽어 끝까지 출력
				while (reader.hasNextLine()) {
					System.out.println(reader.nextLine());
				}
				System.out.println("\n");

				// 파일을 다 사용했으면 닫아주기
				reader.close();
			} else if (taskNum == 2) { // 새 일기를 선택한 경우
				// 파일명으로 사용하기 위한 년도를 입력받기.
				System.out.println("년도를 입력하세요.(예: 1970)");
				String year = scanner.nextLine();

				// 파일명으로 사용하기 위한 월을 입력받기.
				System.out.println("월을 입력하세요.(예: 01)");
				String month = scanner.nextLine();

				// 파일명으로 사용하기 위한 일을 입력받기.
				System.out.println("날짜를 입력하세요.(예: 01)");
				String date = scanner.nextLine();

				// 년, 월, 일을 조합해 파일명을 만든다.
				String fileName = year + "-" + month + "-" + date + ".txt";

				// 파일을 쓰기 위해 FileWriter 선언
				FileWriter writer = null;

				// 조합한 파일명을 가지고 FileWriter 생성
				// 파일 생성에 실패한 경우 "파일 생성에 실패했습니다." 출력 후 반복문의 처음으로 돌아간다.
				try {
					writer = new FileWriter("src/file/" + fileName);
				} catch (IOException e) {
					System.out.println("파일 생성에 실패했습니다.");
					continue;
				}

				System.out.println("날씨를 입력하세요.");
				String weather = scanner.nextLine();

				System.out.println("제목을 입력하세요.");
				String title = scanner.nextLine();

				try {
					writer.write("날씨: " + weather);
					writer.write("\n");
					writer.write("제목: " + title);
					writer.write("\n");
				} catch (IOException e) {
					System.out.println("파일에 문자열을 쓰지 못했습니다.");
				}

				System.out.println("일기 내용을 작성하세요.");
				System.out.println("(종료: 빈 줄에서 엔터키 입력)");
				// 반복문3
				// 계속해서 사용자 입력 값을 받기 위해 무한반복
				while (true) {
					String input = scanner.nextLine();

					// 사용자가 입력한 값이 빈 문자열("")이라면
					// 파일에 쓸 문자열을 입력받는 반복문3 탈출
					if (input.equals("")) {
						break;
					}

					// 사용자가 입력한 문자열을 파일에 쓰고 줄바꿈 문자를 통해 줄바꿈 추가
					try {
						writer.write(input);
						writer.write("\n");
					} catch (IOException e) {
						System.out.println("파일에 문자열을 쓰지 못했습니다.");
					}
				}

				// 빈 문자열을 입력받아 반복문3 탈출했다면 입력이 종료된 것이므로 파일 닫기
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println("파일을 닫는 데 실패했습니다.");
				}
			} else if (taskNum == 3) { // 종료를 선택한 경우
				// 프로그램을 종료하는 메세지 출력 후 반복문1 탈출
				System.out.println("프로그램을 종료합니다.");
				scanner.close();
				break;
			}

			// 사용자가 입력한 값이 1, 2, 3 중 하나가 아닌 경우
			// "잘못된 입력입니다"라는 메세지 출력
			else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
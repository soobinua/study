package collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NotepadWithList {
	// 간단 메모장 프로그램에 "src/collection/notes.txt"파일을 이용해 지금까지 작성했던 파일명의 목록을 저장하고 보여주는 기능 추가
	// 프로그램이 시작될 때 "src/collection/notes.txt"파일에 저장된 파일명의 목록을 읽어 ArrayList에 추가
	// 새 메모가 작성되면 ArrayList에 메모 파일명을 추가하고 정렬
	// 프로그램을 종료할 때는 이 목록이 다시 "src/collection/notes.txt" 파일로 저장

	// 사용자로부터 입력 처리를 담당할 Scanner를 전역변수로 선언
	public static Scanner scanner = new Scanner(System.in);

	// 메모 목록을 담은 ArrayList
	// 프로그램이 시작되면 readMemoList() 를 호출해 메모 목록을 미리 로드
	public static List<String> memoList = readMemoList();

	public static void main(String[] args) {
		// 무한반복. 사용자가 3을 입력하면 반복문을 탈출
		while (true) {
			System.out.println("원하는 작업 번호를 입력해주세요.");
			System.out.println("1. 메모 읽기");
			System.out.println("2. 새 메모");
			System.out.println("3. 메모 목록");
			System.out.println("4. 종료");

			// 사용자로부터 명령 번호를 입력받기
			String operation = scanner.nextLine();
			int taskNum = parseIntegerOrNegative1(operation);

			if (taskNum == 1) { // 메모 읽기를 선택한 경우
				System.out.println("메모 파일명을 입력하세요.");

				// 사용자로부터 문자열로 파일명을 입력받기
				String fileName = scanner.nextLine();

				// 사용자가 입력한 파일명으로 된 파일을 읽어 내용을 출력
				readMemo(fileName);
			} else if (taskNum == 2) { // 새 메모를 선택한 경우
				System.out.println("저장할 메모 파일명을 입력하세요.");

				// 새 메모를 저장하기 위해 새 파일명을 입력받기
				String fileName = scanner.nextLine();

				// 사용자가 입력한 파일명으로 메모를 작성
				writeMemo(fileName);
			} else if (taskNum == 3) { // 메모 목록을 선택한 경우
				showMemoList();
			} else if (taskNum == 4) { // 종료를 선택한 경우
				// 프로그램을 종료한다는 메세지 출력 후 반복문을 탈출
				System.out.println("프로그램을 종료합니다.");
				saveMemoList();
				break;
			} else {
				// 사용자가 입력한 값이 1, 2, 3 중 하나가 아닌 경우
				// "잘못된 입력입니다"라는 메세지를 출력
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private static void readMemo(String fileName) {
		// 파일 내용을 읽어들이기 위해 FileInputStream을 선언
		FileInputStream inputStream = null;

		// 사용자로부터 입력한 파일명을 가지고 FileInputStream을 생성
		// 파일이 없을 경우 "파일이 존재하지 않습니다."라는 메시지를 출력한 후 메소드 탈출
		try {
			inputStream = new FileInputStream("src/collection/" + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
			return;
		}

		// FileInputStream이 성공적으로 생성되면 안내 메세지를 출력
		System.out.println(fileName + "의 내용을 출력합니다.");

		// FileInputStream으로부터 파일의 내용을 읽어들일 Scanner를 선언
		Scanner reader = new Scanner(inputStream);

		// 파일의 내용을 한줄씩 읽어 끝까지 출력
		while (reader.hasNextLine()) {
			System.out.println(reader.nextLine());
		}
		System.out.println("\n");

		// 파일을 다 사용했으면 닫아주기
		reader.close();
	}

	private static void writeMemo(String fileName) {
		if (memoList.contains(fileName)) {
			// 메모 목록에 동일한 파일명이 존재하는 경우 메소드를 탈출
			System.out.println("파일이 이미 존재합니다.");
			return;
		}

		// 파일을 쓰기 위해 FileWriter를 선언
		FileWriter writer = null;

		// 사용자가 입력한 파일명을 가지고 FileWriter를 생성
		// 파일 생성에 실패한 경우 "파일 생성에 실패했습니다." 출력 후 반복문의 처음으로 돌아가기
		try {
			writer = new FileWriter("src/collection/" + fileName);
		} catch (IOException e) {
			System.out.println("파일 생성에 실패했습니다.");
			return;
		}

		System.out.println("메모할 문자열을 입력하세요.");
		System.out.println("(종료: 빈 줄에서 엔터키 입력)");

		while (true) {
			// 이 while 문은 반복해서 사용자 입력을 파일에 씁니다.
			// 사용자로부터 문자열을 한줄 입력받습니다.
			String input = scanner.nextLine();

			// 사용자가 입력한 값이 빈 문자열("")이라면 반복문을 탈출
			if (input.equals("")) {
				break;
			}

			// 사용자가 입력한 문자열을 파일에 쓰고 줄바꿈 문자를 통해 줄바꿈을 추가
			try {
				writer.write(input);
				writer.write("\n");
			} catch (IOException e) {
				System.out.println("파일에 문자열을 쓰지 못했습니다.");
			}
		}

		// 빈 문자열을 입력받아 반복문을 탈출했다면 입력이 종료된 것이므로
		// 파일을 닫아주고 메모 목록에 파일명을 추가
		// 메모 목록에 파일명을 추가한 뒤에는 정렬
		try {
			writer.close();
			memoList.add(fileName);
			Collections.sort(memoList);
		} catch (IOException e) {
			System.out.println("파일을 닫는 데 실패했습니다.");
		}
	}

	public static ArrayList<String> readMemoList() {
		// src/collection/notes.txt 파일을 읽기 위한 FileInputStream을 생성
		FileInputStream inputStream = null;

		// 파일로부터 읽은 메모 목록을 저장할 ArrayList
		ArrayList<String> memoList = new ArrayList<>();

		try {
			// src/collection/notes.txt 파일 열기
			inputStream = new FileInputStream("src/collection/notes.txt");
		} catch (FileNotFoundException e) {
			// 파일이 존재하지 않는 경우 빈 ArrayList 를 반환
			return memoList;
		}

		// 파일의 내용을 읽기 위해 Scanner를 생성
		Scanner scanner = new Scanner(inputStream);

		while (scanner.hasNextLine()) {
			// 파일의 내용을 한줄씩 읽어 ArrayList 에 저장
			String fileName = scanner.nextLine();
			memoList.add(fileName);
		}
		scanner.close();

		// 파일 목록이 추가된 ArrayList를 반환
		return memoList;
	}

	public static void showMemoList() {
		if (memoList.isEmpty()) {
			// 메모 목록이 빈 경우 메세지를 출력
			System.out.println("작성된 메모가 없습니다.");
		} else {
			System.out.println("메모 목록을 출력합니다.");

			// 메모 목록을 순회하며 파일명을 출력
			for (String fileName : memoList) {
				System.out.println(fileName);
			}
			System.out.println("");
		}
	}

	public static void saveMemoList() {
		// 메모 파일을 저장하기 위해 FileWriter 를 선언
		FileWriter writer = null;

		try {
			// src/collection/notes.txt 라는 파일명으로 FileWriter 를 생성
			writer = new FileWriter("src/collection/notes.txt");

			// 메모 목록을 순회하며 notes.txt 안에 파일명을 씁니다.
			for (String fileName : memoList) {
				writer.write(fileName);
				writer.write("\n");
			}

			// 다 쓴 파일은 닫아주기
			writer.close();
		} catch (IOException e) {
			// 파일 쓰기가 실패한 경우 메세지를 출력
			System.out.println("메모 목록을 저장하는 데 실패했습니다.");
		}
	}

	public static int parseIntegerOrNegative1(String input) {
		// 문자열을 정수로 변환해 반환
		// 예외가 발생한 경우(사용자가 정수가 아닌 값 입력) -1 을 반환
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return -1;
		}
	}
}

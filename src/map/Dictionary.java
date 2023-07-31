package map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

	public static void main(String[] args) {
		// 파일에 영단어와 한국어 단어 쌍 목록을 입력해두고 이 파일을 읽어 영한 단어 사전을 제공

		// 미리 생성해둔 사전 파일명
		String dictionaryFile = "src/map/dictionary.txt";

		// 파일로부터 사전 데이터를 읽어 Map으로 만들기
		// 상세한 구현은 뒤쪽에 정의된 readDictionary 메소드로 정의
		Map<String, String> dictionary = readDictionary(dictionaryFile);

		// 사용자로부터 번역할 단어를 입력받기 위해 Scanner 생성
		Scanner scanner = new Scanner(System.in);

		while (true) {
			// 이 반복문은 사용자로부터 문자열을 입력받은 키
			// HashMap(dictionary)에서 데이터를 가져다가 출력해준다
			System.out.println("번역할 영단어를 입력하세요.(종료 : q)");

			// 사용자로부터 문자열 입력받기
			String englishWord = scanner.nextLine();

			// 사용자가 q를 입력했다면 반복문 탈출
			if (englishWord.equals("q")) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}

			if (dictionary.containsKey(englishWord)) {
				// HashMap(dictionary)에 영단어를 키로 하는 한국어 단어가 있다면 한국어 단어 출력
				String koreanWord = dictionary.get(englishWord);
				System.out.println(englishWord + "는 " + koreanWord + "입니다.");
			} else {
				// HashMap(dictionary)에 영단어를 키로 하는 한국어가 없다면 사전에 단어가 없다는 메시지 출력
				System.out.println("사전에서 단어를 찾을 수 없습니다.");
			}
		}

		scanner.close();
	}

	private static Map<String, String> readDictionary(String fileName) {
		// 파일로부터 읽어온 단어 데이터를 담을 Map 생성
		Map<String, String> dictionary = new HashMap<>();

		// 사전 파일을 읽기 위해 FileInputStream 선언
		FileInputStream inputStream = null;

		try {
			// fileName으로부터 FileInputStream 생성
			inputStream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// 파일이 존재하지 않는 경우 메시지 출력 후 프로그램 종료
			System.out.println("사전 파일이 존재하지 않습니다.");
			System.exit(20);
		}

		// 파일로부터 내용을 읽어오기 위해 Scanner 생성
		Scanner scanner = new Scanner(inputStream);

		// 파일의 내용을 끝까지 읽기 위한 반복문
		while (scanner.hasNextLine()) {
			// next()를 호출해 그 줄의 첫 단어(영단어)를 읽어온다.
			String englishWord = scanner.next();
			// 다시 한번 next()를 호출해 그 줄의 두번째 단어(한글 단어)를 읽어온다.
			String koreanWord = scanner.next();

			// HashMap에 영단어를 키로, 한글 단어를 값으로 입력
			dictionary.put(englishWord, koreanWord);
		}
		scanner.close();

		// 파일을 끝까지 읽어 단어를 추가했다면 HashMap을 반환
		return dictionary;

	}

}

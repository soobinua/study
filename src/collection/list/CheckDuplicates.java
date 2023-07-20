package collection.list;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckDuplicates {

	public static void main(String[] args) {
		System.out.println("좋아하는 음식의 이름을 입력하세요.(종료: 0)");
		// 입력 요청과 함께 미리 문자열 타입의 List, 입력을 받을 Scanner 생성
		ArrayList<String> myFavoriteFoods = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			// 반복문을 수행하며 사용자로부터 문자열을 입력받는다.
			String food = scanner.nextLine();

			if (food.equals("0")) { // 사용자가 "0" 입력했다면 반복문 탈출
				break;
			}

			if (myFavoriteFoods.contains(food)) { // ArrayList의 contains 메소드를 이용해 만일 우리의 목록에 이미 사용자가 입력한 값 있다면
				System.out.println(food + "는 이미 목록에 있습니다."); // 이미 목록에 존재한다는 메시지 출력
			} else {
				myFavoriteFoods.add(food);
			}
		}

		System.out.println(myFavoriteFoods); // 반복문 탈출하면 지금까지 목록에 추가한 내용들을 출력

		scanner.close();
	}
}

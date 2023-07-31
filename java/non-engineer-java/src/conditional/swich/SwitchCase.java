package conditional.swich;

public class SwitchCase {

	public static void main(String[] args) {
		int month = 0;
		switch (month) {
		case 1: // (value) 괄호 안 값이 case 조건에 일치하는 경우 실행
			System.out.println("January");
			break; // 없다면 모든 코드 실행
		case 2:
			System.out.println("February");
			break;
		case 3: // 값 3으로 일치
			System.out.println("March"); // 실행
			break; // switch 구문을 종료한다는 표시
		case 4:
			System.out.println("April");
			break;
		default:
			System.out.println("번역 불가"); // 일치하는 값이 없을 때
		}
	}

}

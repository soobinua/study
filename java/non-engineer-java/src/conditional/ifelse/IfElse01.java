package conditional.ifelse;

public class IfElse01 {

	public static void main(String[] args) {
		int money = 6000;
		if (money >= 8000) {// 조건이 참이라면
			System.out.println("순대국은 맛있다."); // 명령 실행
		} else if (money >= 5000) { // 다른 조건 참
			System.out.println("버거 맛있어"); // 명령 실행
		} else { // 조건이 거짓이라면
			System.out.println("배고프다..."); // 명령 실행
		}

	}

}

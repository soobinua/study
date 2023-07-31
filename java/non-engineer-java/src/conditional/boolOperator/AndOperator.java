package conditional.boolOperator;

public class AndOperator {

	public static void main(String[] args) {
		// 논리합 연산자 - &&
		int age = 15;
		// 10살 이상이고 20살 미만
		if (age >= 10 && age < 20) { // && 양쪽의 두 조건 모두 true일 때 true
			System.out.println("10대");
		} else {
			System.out.println("10대 아님");
		}

	}

}

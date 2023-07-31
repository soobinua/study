package conditional.boolOperator;

public class OrOperator {

	public static void main(String[] args) {
		// 논리합 연산자 - ||
		int age = 15;
		// 10살 미만이거나 20살 이상
		if (age < 10 || age >= 20) { // || 두 조건 중 하나만 true여도 true
			System.out.println("10대 아님");
		} else {
			System.out.println("10대");
		}
	}

}

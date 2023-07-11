package conditional;

public class NestedIf {

	public static void main(String[] args) {
		int age = 15;
		if (age >= 10) { // 10살 이상
			if (age < 20) {// 20살 미만
				System.out.println("10대");
			} else { // 중복 else
				System.out.println("10대 아님");
			}
		} else { // 중복 else
			System.out.println("10대 아님");
		}

	}

}

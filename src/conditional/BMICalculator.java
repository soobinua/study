package conditional;

import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {
		// BMI지수 = 몸무게(kg) / (신장(m) * 신장(m))
		// BMI 계산해 18.5 미만이면 저체중, 23 이상이면 과체중 출력

		Scanner scanner = new Scanner(System.in);

		System.out.println("몸무게를 입력하세요.");
		String weightString = scanner.nextLine();

		System.out.println("키를 입력하세요.");
		String heightString = scanner.nextLine();

		double weight = Double.parseDouble(weightString);
		double height = Double.parseDouble(heightString);
		double bmi = weight / (height * height);

		if (bmi < 18.5) {
			System.out.println("저체중입니다.");
			System.out.println("당신의 BMI : " + bmi);
		} else if (bmi >= 23) {
			System.out.println("과체중입니다.");
			System.out.println("당신의 BMI : " + bmi);
		} else {
			System.out.println("정상입니다.");
			System.out.println("당신의 BMI : " + bmi);
		}

		scanner.close();
	}

}
